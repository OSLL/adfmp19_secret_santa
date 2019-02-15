package ru.hse.spb.secretsanta.data.interfaces

import ru.hse.spb.secretsanta.data.*
import ru.hse.spb.secretsanta.data.exceptions.ClientErrorException
import ru.hse.spb.secretsanta.data.statuses.FestivalMode
import ru.hse.spb.secretsanta.data.statuses.GiftReviewType
import ru.hse.spb.secretsanta.data.statuses.SantaGiftStatus
import java.util.*

class DummyFestivalAdminClientInterface : FestivalAdminClientInterface {
    private val participantIds: List<PersonId> = listOf(
        PersonId("1"),
        PersonId("2"),
        PersonId("3"),
        PersonId("4"),
        PersonId("5"),
        PersonId("6"),
        PersonId("7"),
        PersonId("8"),
        PersonId("9"),
        PersonId("10")
    )

    private val participantNames: List<String> = listOf(
        "Hattie Kaiser",
        "Philip Mills",
        "Tracey Mccallum",
        "Lennox Aguirre",
        "Amritpal Bullock",
        "Ahyan Marshall",
        "Isobel Dawe",
        "Nicky Atherton",
        "Sonya Christensen",
        "Mateo Holcomb"
    )

    override val festivalId: FestivalId = FestivalId("Merry Christmas")

    override val thisPersonId: PersonId = participantIds[0]

    private var mode: FestivalMode = FestivalMode.PREPARATION

    override fun getMode(): FestivalMode = mode

    private var rules: FestivalRules

    init {
        val deadline = Calendar.getInstance()
        deadline.set(2020, 1, 12, 12, 0)

        rules = FestivalRules(
            deadline,
            PriceLimitations(500, 2000),
            "Folks, we are going to meet on Jan 12 at Nicky's place and exchange the gifts (secretly). Don't forget to sign your gift."
        )
    }

    override fun getRules(): FestivalRules = rules

    override fun getParticipants(): List<Person> =
        (0 until participantIds.size).map { Person(participantIds[it], participantNames[it]) }

    override fun getGiftsInfo(): Map<PersonId, SantaGiftInfo> {
        if (mode != FestivalMode.ENDED) {
            throw ClientErrorException("It is not possible to look at gifts info before festival has ended.")
        }

        return mapOf(*(0 until participantIds.size).map {
            Pair(
                participantIds[it],
                SantaGiftInfo(
                    participantIds[(it + 1) % participantIds.size],
                    SantaGiftStatus.PRESENTED
                )
            )
        }.toTypedArray())
    }

    private var thisPersonWishlist: Wishlist = Wishlist(
        listOf(
            WishlistEntry("Socks with different patterns and images"),
            WishlistEntry("New PlayStation game"),
            WishlistEntry("Interesting book"),
            WishlistEntry("Magic wand from Harry Potter franchise (not a vibrator)"),
            WishlistEntry("Fluffy toy"),
            WishlistEntry("Warm sweater (my size is M)"),
            WishlistEntry("Small backpack")
        ),
        listOf(
            WishlistEntry("Sweets"),
            WishlistEntry("Board game"),
            WishlistEntry("I don't like decorations. If something must stay in one place and I should look at it then it's a bad gift for me.")
        )
    )

    override fun getThisPersonWishlist(): Wishlist = thisPersonWishlist

    override fun getRecipientInfo(): RecipientInfo {
        if (mode == FestivalMode.PREPARATION) {
            throw ClientErrorException("There is no recipient when festival has not been started.")
        }

        return RecipientInfo(
            participantIds[1],
            Wishlist(
                listOf(
                    WishlistEntry("Comic book"),
                    WishlistEntry("Tasty tea"),
                    WishlistEntry("Marzipan sweets"),
                    WishlistEntry("Jar for cookies"),
                    WishlistEntry("Fancy cup"),
                    WishlistEntry("Expensive pen"),
                    WishlistEntry("Cool poster")
                ),
                listOf(
                    WishlistEntry("Any cloth"),
                    WishlistEntry("Be very careful if you want to give me a book. I don't like books. Not all of them, but most of them.")
                )
            ),
            GiftReview("That was an amazing gift! Exactly what I wanted. Thx :)")
        )
    }

    override fun startFestival() {
        if (mode != FestivalMode.PREPARATION) {
            throw ClientErrorException("Festival has already been started.")
        }

        mode = FestivalMode.ACTIVE
    }

    override fun changeRules(newRules: FestivalRules) {
        if (mode != FestivalMode.PREPARATION) {
            throw ClientErrorException("It is not possible to change festival rules after it has been started.")
        }

        rules = newRules
    }

    override fun kickPerson(personId: PersonId) {
    }

    override fun destroyFestival() {
    }

    override fun leaveFestival() {
    }

    private var hasThisPersonSentReview: Boolean = false

    override fun hasThisPersonSentReview(): Boolean {
        return hasThisPersonSentReview
    }

    override fun sentReview(review: GiftReview?, reviewType: GiftReviewType) {
        if (mode != FestivalMode.ENDED) {
            throw ClientErrorException("Festival has not ended. It is not possible to send reviews.")
        }

        hasThisPersonSentReview = true
    }

    override fun changeThisPersonWishlist(newWishlist: Wishlist) {
        thisPersonWishlist = newWishlist
    }
}
