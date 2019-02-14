package ru.hse.spb.secretsanta.data

import java.util.*

/**
 * Rules of a particular festival. Rules consist of a festival deadline, price limitations and an optional
 * comment.
 */
class FestivalRules(
    val deadline: Calendar,
    val priceLimitations: PriceLimitations,
    val additionalComment: String?
)
