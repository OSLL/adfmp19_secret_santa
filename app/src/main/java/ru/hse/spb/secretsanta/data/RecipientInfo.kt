package ru.hse.spb.secretsanta.data

/**
 * Info about gift recipient. Contains [PersonId], his/her [Wishlist] and optional [GiftReview].
 */
class RecipientInfo(
    val id: PersonId,
    val wishlist: Wishlist,
    val giftReview: GiftReview?
)
