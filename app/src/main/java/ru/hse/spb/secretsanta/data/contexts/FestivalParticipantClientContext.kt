package ru.hse.spb.secretsanta.data.contexts

import ru.hse.spb.secretsanta.data.*
import ru.hse.spb.secretsanta.data.statuses.FestivalMode
import ru.hse.spb.secretsanta.data.statuses.GiftReviewType
import ru.hse.spb.secretsanta.data.exceptions.NetworkFailureException

/**
 * Client context of a participant of a festival. Context allows to perform various read and write
 * requests generally to a server that maintains all the information.
 *
 * It is supposed that UI classes use this context directly, so its implementation must be as much friendly
 * as possible. Failures may be indicated by [NetworkFailureException] and its subclasses.
 */
interface FestivalParticipantClientContext {
    /**
     * Id of this festival.
     */
    val festivalId: FestivalId

    /**
     * [PersonId] of person who uses this particular client.
     */
    val thisPersonId: PersonId

    /**
     * [FestivalMode] of this festival.
     */
    val mode: FestivalMode

    /**
     * [FestivalRules] of this festival.
     */
    val rules: FestivalRules

    /**
     * List of participants of this festival.
     */
    val participants: List<Person>

    /**
     * [Wishlist] of person who uses this particular client.
     */
    val thisPersonWishlist: Wishlist

    /**
     * [RecipientInfo] of gift recipient of person who uses this particular client.
     */
    val recipientInfo: RecipientInfo

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
