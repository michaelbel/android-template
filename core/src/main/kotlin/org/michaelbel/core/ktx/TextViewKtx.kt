@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.annotation.DrawableRes

object Drawables {
    const val START = 1
    const val TOP = 2
    const val END = 3
    const val BOTTOM = 4
}

var TextView.drawableStart: Drawable
    inline get() = compoundDrawablesRelative[Drawables.START]
    set(value) = setCompoundDrawablesRelativeWithIntrinsicBounds(value, null, null, null)

var TextView.drawableTop: Drawable
    inline get() = compoundDrawablesRelative[Drawables.TOP]
    set(value) = setCompoundDrawablesRelativeWithIntrinsicBounds(null, value, null, null)

var TextView.drawableEnd: Drawable
    inline get() = compoundDrawablesRelative[Drawables.END]
    set(value) = setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, value, null)

var TextView.drawableBottom: Drawable
    inline get() = compoundDrawablesRelative[Drawables.BOTTOM]
    set(value) = setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, value)

fun TextView.setDrawableStart(@DrawableRes drawableRes: Int) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(drawableRes, 0, 0, 0)
}

fun TextView.setDrawableTop(@DrawableRes drawableRes: Int) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(0, drawableRes, 0, 0)
}

fun TextView.setDrawableEnd(@DrawableRes drawableRes: Int) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawableRes, 0)
}

fun TextView.setDrawableBottom(@DrawableRes drawableRes: Int) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, drawableRes)
}