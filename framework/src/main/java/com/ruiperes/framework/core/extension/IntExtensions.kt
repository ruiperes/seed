package com.ruiperes.framework.core.extension

import kotlin.math.abs
import kotlin.math.log10

fun Int.length() = when (this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}

fun Int.between(startValue: Int, endValue: Int) = this in startValue until endValue

fun Int.isEven() = this % 2 == 0

fun Int.isOdd() = this % 2 == 1