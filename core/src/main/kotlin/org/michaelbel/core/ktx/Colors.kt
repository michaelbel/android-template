@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.ui.graphics.Color
import kotlin.math.floor
import kotlin.math.roundToInt
import android.graphics.Color as AndroidColor

inline val Int.toHexColor: String
    get() = String.format("#%06X", 0xFFFFFF and this)

inline val String.androidColor: Int
    get() = AndroidColor.parseColor(this)

inline val String.composeColor: Color
    get() = Color(androidColor)

fun Context.getAttrColor(@AttrRes colorAttr: Int): Int {
    var color = 0
    val attrs = intArrayOf(colorAttr)

    return try {
        val typedArray = obtainStyledAttributes(attrs)
        color = typedArray.getColor(0, 0)
        typedArray.recycle()
        color
    } catch (e: Exception) {
        color
    }
}

fun Context.getColorArray(@ArrayRes arrayRes: Int): IntArray? {
    if (arrayRes == 0) {
        return null
    }

    val ta = resources.obtainTypedArray(arrayRes)
    val colors = IntArray(ta.length())

    for (i in 0 until ta.length()) {
        colors[i] = ta.getColor(i, 0)
    }

    ta.recycle()
    return colors
}

@ColorInt
fun adjustAlpha(@ColorInt color: Int, @FloatRange(from = 0.00, to = 1.00) factor: Float): Int {
    val alpha = (AndroidColor.alpha(color) * factor).roundToInt()
    val red = AndroidColor.red(color)
    val green = AndroidColor.green(color)
    val blue = AndroidColor.blue(color)
    return AndroidColor.argb(alpha, red, green, blue)
}

@ColorInt
fun modifyAlpha(
    @ColorInt color: Int,
    @IntRange(from = 0, to = 255) alpha: Int
): Int = color and 0x00FFFFFF or (alpha shl 24)

fun rgbToHsv(r: Int, g: Int, b: Int): DoubleArray {
    val rf = r / 255.0
    val gf = g / 255.0
    val bf = b / 255.0
    val max = if (rf > gf && rf > bf) rf else if (gf > bf) gf else bf
    val min = if (rf < gf && rf < bf) rf else if (gf < bf) gf else bf
    var h: Double
    val s: Double
    val d = max - min

    s = if (max == 0.0) 0.0 else d / max

    if (max == min) {
        h = 0.0
    } else {
        h = if (rf > gf && rf > bf) {
            (gf - bf) / d + if (gf < bf) 6 else 0
        } else if (gf > bf) {
            (bf - rf) / d + 2
        } else {
            (rf - gf) / d + 4
        }

        h /= 6.0
    }

    return doubleArrayOf(h, s, max)
}

fun hsvToRgb(h: Double, s: Double, v: Double): IntArray {
    var r = 0.0
    var g = 0.0
    var b = 0.0
    val i = floor(h * 6).toInt().toDouble()
    val f = h * 6 - i
    val p = v * (1 - s)
    val q = v * (1 - f * s)
    val t = v * (1 - (1 - f) * s)

    when (i.toInt() % 6) {
        0 -> {
            r = v
            g = t
            b = p
        }
        1 -> {
            r = q
            g = v
            b = p
        }
        2 -> {
            r = p
            g = v
            b = t
        }
        3 -> {
            r = p
            g = q
            b = v
        }
        4 -> {
            r = t
            g = p
            b = v
        }
        5 -> {
            r = v
            g = p
            b = q
        }
    }

    return intArrayOf((r * 255).toInt(), (g * 255).toInt(), (b * 255).toInt())
}