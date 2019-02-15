package ru.hse.spb.secretsanta.data

/**
 * Wishlist of a person. Contains two lists: one for wishes and another one for anti wishes. Each wish or anti
 * wish is a [WishlistEntry].
 */
class Wishlist(val wishes: List<WishlistEntry>, val antiWishes: List<WishlistEntry>)

/**
 * One entry of a [Wishlist]
 */
inline class WishlistEntry(val description: String)
