@file:Suppress("unused")

package org.michaelbel.core.ktx

import kotlin.math.roundToInt

private const val SECONDS_IN_MINUTE = 60

fun Float.toSeconds(): Int = (this * SECONDS_IN_MINUTE).roundToInt()

fun Int.secondsToTimeString(): String {
    val minutes: String = (this / SECONDS_IN_MINUTE).toString().padStart(2, '0')
    val seconds: String = (this % SECONDS_IN_MINUTE).toString().padStart(2, '0')
    return "$minutes:$seconds"
}