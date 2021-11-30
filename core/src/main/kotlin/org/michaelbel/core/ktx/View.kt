@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.forEach

fun View.doOnApplyWindowInsets(block: (View, insets: WindowInsetsCompat) -> WindowInsetsCompat) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets -> block(v, insets) }
}

/**
 * Найти дочернее представление по координатам во время нажатия на экран.
 */
fun findViewAtPosition(parent: View, x: Int, y: Int): View? {
    if (parent is ViewGroup) {
        val viewGroup: ViewGroup = parent
        viewGroup.forEach {
            val viewAtPosition: View? = findViewAtPosition(it, x, y)
            if (viewAtPosition != null) {
                return viewAtPosition
            }
        }
        return null
    } else {
        val rect = Rect()
        parent.getGlobalVisibleRect(rect)
        return if (rect.contains(x, y)) parent else null
    }
}

fun View.findViewCenterY(): Int {
    val location = IntArray(2)
    this.getLocationOnScreen(location)
    val top = location[1]
    val height: Int = this.measuredHeight
    return top.plus(height.div(2))
}

fun View.toBitmap(): Bitmap {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    layout(left, top, right, bottom)
    draw(canvas)
    return bitmap
}

fun View.toBitmapDrawable(): BitmapDrawable {
    val measureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    measure(measureSpec, measureSpec)
    layout(0, 0, measuredWidth, measuredHeight)

    val bitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)

    background?.draw(canvas)
    draw(canvas)

    return BitmapDrawable(resources, bitmap)
}