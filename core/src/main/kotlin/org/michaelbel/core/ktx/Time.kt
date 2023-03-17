@file:Suppress("unused")

package org.michaelbel.core.ktx

import kotlin.math.roundToInt

private const val SECONDS_IN_MINUTE = 60
private const val SECONDS_IN_HOUR = SECONDS_IN_MINUTE * 60

fun Float.toSeconds(): Int = (this * SECONDS_IN_MINUTE).roundToInt()

val Int.secondsToTime: String
    get() {
        val minutes: String = (this / SECONDS_IN_MINUTE).toString().padStart(2, '0')
        val seconds: String = (this % SECONDS_IN_MINUTE).toString().padStart(2, '0')
        return "$minutes:$seconds"
    }

val Int.secondsToTime2: String
    get() {
        val hours: String = (this / SECONDS_IN_HOUR).toString().padStart(2, '0')
        val minutes: String = ((this % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE).toString().padStart(2, '0')
        val seconds: String = (this % SECONDS_IN_MINUTE).toString().padStart(2, '0')
        return "$hours:$minutes:$seconds"
    }

fun isTimePasses(interval: Long, expireTime: Long, currentTime: Long): Boolean {
    return (currentTime - expireTime) >= interval
}