@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.TransitionDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.core.graphics.drawable.DrawableCompat

fun Drawable.toBitmap(): Bitmap {
    if (this is BitmapDrawable) {
        return bitmap
    }

    val bitmap = if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
        Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
    } else {
        Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
    }

    Canvas(bitmap).apply {
        setBounds(0, 0, width, height)
        draw(this)
    }

    return bitmap
}

fun Context.getTintDrawable(
    @DrawableRes drawableRes: Int,
    @ColorRes colorRes: Int
): Drawable {
    val source = ContextCompat.getDrawable(this, drawableRes)?.mutate()
    val wrapped = DrawableCompat.wrap(source as Drawable)
    DrawableCompat.setTint(wrapped, ContextCompat.getColor(this, colorRes))
    return wrapped
}

fun Drawable.setColor(@ColorInt color: Int) {
    colorFilter = BlendModeColorFilterCompat
        .createBlendModeColorFilterCompat(color, BlendModeCompat.SRC_ATOP)
}

fun Context.selectableItemBackgroundDrawable(
    @ColorRes colorRes: Int? = null
): Drawable? {
    val attrs = intArrayOf(android.R.attr.selectableItemBackground)
    val typedArray = obtainStyledAttributes(attrs)
    val drawableSelectable = typedArray.getDrawable(0)
    typedArray.recycle()

    if (colorRes != null) {
        return LayerDrawable(
            arrayOf(
                ColorDrawable(ContextCompat.getColor(this, colorRes)),
                drawableSelectable
            )
        )
    }

    return drawableSelectable
}

fun Context.selectableItemBackgroundBorderlessDrawable(
    @ColorRes colorRes: Int? = null
): Drawable? {
    val attrs = intArrayOf(android.R.attr.selectableItemBackgroundBorderless)
    val typedArray = obtainStyledAttributes(attrs)
    val drawableSelectable = typedArray.getDrawable(0)
    typedArray.recycle()

    if (colorRes != null) {
        return LayerDrawable(arrayOf(
            ColorDrawable(ContextCompat.getColor(this, colorRes)),
            drawableSelectable
        ))
    }

    return drawableSelectable
}

fun Context.selectableItemBackgroundDrawable(
    transitionDrawable: TransitionDrawable
): Drawable {
    val attrs = intArrayOf(android.R.attr.selectableItemBackground)
    val typedArray = obtainStyledAttributes(attrs)
    val drawableSelectable = typedArray.getDrawable(0)
    typedArray.recycle()
    return LayerDrawable(arrayOf(transitionDrawable, drawableSelectable))
}

fun Context.selectableItemRippleDrawable(
    view: View,
    @ColorRes rippleColor: Int
): RippleDrawable {
    val rippleDrawable = view.background as RippleDrawable
    val states = arrayOf(intArrayOf(android.R.attr.state_enabled))
    val colors = intArrayOf(ContextCompat.getColor(this, rippleColor))
    val colorStateList = ColorStateList(states, colors)
    rippleDrawable.setColor(colorStateList)
    return rippleDrawable
}