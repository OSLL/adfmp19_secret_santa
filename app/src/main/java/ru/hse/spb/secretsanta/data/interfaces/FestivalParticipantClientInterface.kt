package ru.hse.spb.secretsanta.data.interfaces

import ru.hse.spb.secretsanta.data.*
import ru.hse.spb.secretsanta.data.statuses.FestivalMode
import ru.hse.spb.secretsanta.data.statuses.GiftReviewType
import ru.hse.spb.secretsanta.data.exceptions.NetworkFailureException

/**
 * Client interface of a participant of a festival. Interface allows to perform various read and write
 * requests generally to a server that maintains all the information.
 *
 * It is supposed that UI classes use this interface directly, so its implementation must be as much friendly
 * as possible. Failures may be indicated by [NetworkFailureException] and its subclasses.
 */
interface FestivalParticipantClientInterface {
    /**
     * Id of this festival.
     */
    val festivalId: FestivalId

    /**
     * [PersonId] of person who uses this particular client.
     */
    val thisPersonId: PersonId

    /**
     * @return [FestivalMode] of this festival.
     */
    fun getMode(): FestivalMode

    /**
     * @return [FestivalRules] of this festival.
     */
    fun getRules(): FestivalRules

    /**
     * @return list of participants of this festival.
     */
    fun getParticipants(): List<Person>

    /**
     * @return [Wishlist] of person who uses this particular client.
     */
    fun getThisPersonWishlist(): Wishlist

    /**
     * @return [RecipientInfo] of gift recipient of person who uses this particular client.
     */
    fun getRecipientInfo(): RecipientInfo

    /**
     * Person who uses this particular client leaves this festival.
     */
    fun leaveFestival()

    /**
     * @return {@code true} if person who uses this particular client has sent a review.
     */
    fun hasThisPersonSentReview(): Boolean

    /**
     * Person who uses this particular client sends [GiftReview].
     *
     * @param review a review that is sent.
     * @param reviewType type of a review that is sent.
     */
    fun sentReview(review: GiftReview?, reviewType: GiftReviewType)

    /**
     * Person who uses this particular client changes his/her [Wishlist].
     *
     * @param newWishlist a new [Wishlist] that completely replaces the old one.
     */
    fun changeThisPersonWishlist(newWishlist: Wishlist)
}
