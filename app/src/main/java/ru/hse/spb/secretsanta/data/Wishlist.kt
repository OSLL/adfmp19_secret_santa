package ru.hse.spb.secretsanta.data

/**
 * Wishlist of a person. Contains two lists: one for wishes and another one for anti wishes. Each wish is
 * just a [String] description.
 */
class Wishlist(val wishes: List<String>, val antiWishes: List<String>)
