@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.util.TypedValue
import java.util.Locale
import kotlin.math.pow
import kotlin.math.roundToInt

fun Number.dp(context: Context): Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    toFloat(),
    context.resources.displayMetrics
).roundToInt()

fun Number.isBetween(int1: Int, int2: Int): Boolean = this in (int1 + 1) until int2

infix fun Number.isBetween(range: IntRange): Boolean = this in range.first until range.last

val Number.isInteger: Boolean
    get() {
        val afterDecimal: String = toString().substringAfter('.')
        return afterDecimal.toInt() == 0
    }

val Long.formatSize: String
    get() = when {
        this < 1024 -> String.format(Locale.getDefault(), "%d B", this)
        this < 1024.0.pow(2.0) -> String.format(Locale.getDefault(), "%.1f KB", this / 1024.0F)
        this < 1024.0.pow(3.0) -> String.format(Locale.getDefault(), "%.1f MB", this / 1024.0.pow(2.0))
        this < 1024.0.pow(4.0) -> String.format(Locale.getDefault(), "%.1f GB", this / 1024.0.pow(3.0))
        this < 1024.0.pow(5.0) -> String.format(Locale.getDefault(), "%.1f TB", this / 1024.0.pow(4.0))
        this < 1024.0.pow(6.0) -> String.format(Locale.getDefault(), "%.1f PB", this / 1024.0.pow(5.0))
        this < 1024.0.pow(7.0) -> String.format(Locale.getDefault(), "%.1f EB", this / 1024.0.pow(6.0))
        this < 1024.0.pow(8.0) -> String.format(Locale.getDefault(), "%.1f ZB", this / 1024.0.pow(7.0))
        else -> String.format(Locale.getDefault(), "%.1f YB", this / 1024.0.pow(8.0))
    }