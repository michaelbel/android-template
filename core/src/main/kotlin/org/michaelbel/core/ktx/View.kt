@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.forEach
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.core.view.updateLayoutParams

var View.startPadding: Int
    inline get() = paddingLeft
    set(value) = setPadding(value, paddingTop, paddingRight, paddingBottom)

var View.topPadding: Int
    inline get() = paddingTop
    set(value) = setPadding(paddingLeft, value, paddingRight, paddingBottom)

var View.endPadding: Int
    inline get() = paddingRight
    set(value) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

var View.bottomPadding: Int
    inline get() = paddingBottom
    set(value) = setPadding(paddingLeft, paddingTop, paddingRight, value)

var View.startMargin: Int
    inline get() = marginStart
    set(value) = updateLayoutParams<ViewGroup.MarginLayoutParams> { marginStart = value }

var View.topMargin: Int
    inline get() = marginTop
    set(value) = updateLayoutParams<ViewGroup.MarginLayoutParams> { topMargin = value }

var View.endMargin: Int
    inline get() = marginEnd
    set(value) = updateLayoutParams<ViewGroup.MarginLayoutParams> { marginEnd = value }

var View.bottomMargin: Int
    inline get() = marginBottom
    set(value) = updateLayoutParams<ViewGroup.MarginLayoutParams> { bottomMargin = value }

fun View.doOnApplyWindowInsets(block: (View, insets: WindowInsetsCompat) -> WindowInsetsCompat) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets -> block(v, insets) }
}

fun View.setOnGlobalLayoutListenerSingle(onGlobalLayoutAction: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            onGlobalLayoutAction()
        }
    })
}

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

@SuppressLint("ClickableViewAccessibility")
fun View.setOnClickListenerWithPoint(action: (View, Point) -> Unit) {
    val coordinates = Point()
    val screenPosition = IntArray(2)
    setOnTouchListener { v, event ->
        if (event.action == MotionEvent.ACTION_DOWN) {
            v.getLocationOnScreen(screenPosition)
            coordinates.set(
                event.x.toInt() + screenPosition[0],
                event.y.toInt() + screenPosition[1]
            )
        }
        false
    }
    setOnClickListener { view ->
        action.invoke(view, coordinates)
    }
}