@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint

fun Bitmap.saturationBitmap(saturation: Float): Bitmap {
    val colorMatrix = ColorMatrix().apply {
        setSaturation(saturation)
    }

    val paint = Paint().apply {
        colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    val resultBitmap = copy(Bitmap.Config.ARGB_8888, true)

    Canvas(resultBitmap).apply {
        drawBitmap(resultBitmap, 0F, 0F, paint)
    }

    return resultBitmap
}

fun Bitmap.brightBitmap(brightness: Float): Bitmap {
    val colorTransform = floatArrayOf(
        1F, 0F, 0F, 0F, brightness,
        0F, 1F, 0F, 0F, brightness,
        0F, 0F, 1F, 0F, brightness,
        0F, 0F, 0F, 1F, 0F
    )

    val colorMatrix = ColorMatrix().apply {
        setSaturation(0F)
        set(colorTransform)
    }

    val paint = Paint().apply {
        colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    val resultBitmap: Bitmap = copy(Bitmap.Config.ARGB_8888, true)

    Canvas(resultBitmap).apply {
        drawBitmap(resultBitmap, 0F, 0F, paint)
    }

    return resultBitmap
}

fun Bitmap.contrastBitmap(contrast: Float): Bitmap {
    val colorTransform = floatArrayOf(
        contrast, 0F, 0F, 0F,
        0F, 0F, contrast, 0F,
        0F, 0F, 0F, 0F,
        contrast, 0F, 0F, 0F,
        0F, 0F, 1F, 0F
    )

    val colorMatrix = ColorMatrix().apply {
        setSaturation(0F)
        set(colorTransform)
    }

    val paint = Paint().apply {
        colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    val resultBitmap = copy(Bitmap.Config.ARGB_8888, true)

    Canvas(resultBitmap).apply {
        drawBitmap(resultBitmap, 0F, 0F, paint)
    }

    return resultBitmap
}