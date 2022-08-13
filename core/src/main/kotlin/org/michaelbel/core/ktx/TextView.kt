@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.annotation.DrawableRes

fun TextView.setDrawableStart(@DrawableRes drawableRes: Int) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(drawableRes, 0, 0, 0)
}

fun TextView.setDrawableStart(drawable: Drawable?) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null)
}

fun TextView.setDrawableEnd(@DrawableRes drawableRes: Int) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawableRes, 0)
}

fun TextView.setDrawableEnd(drawable: Drawable?) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable, null)
}