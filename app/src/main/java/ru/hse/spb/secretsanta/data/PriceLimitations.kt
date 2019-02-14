package ru.hse.spb.secretsanta.data

import java.lang.IllegalArgumentException

/**
 * Price limitations for a particular festival. Limitations are just two [Int]s: price lower and upper bounds.
 */
class PriceLimitations(val lowerBound: Int, val upperBound: Int) {
    init {
        if (lowerBound < 0 || upperBound < 0) {
            throw IllegalArgumentException("Price limits must be non negative integers")
        }

        if (lowerBound > upperBound) {
            throw IllegalArgumentException("Price lower bound must not be greater than upper bound")
        }

        if (upperBound == 0) {
            throw IllegalArgumentException("Price upper bound must not be zero")
        }
    }
}