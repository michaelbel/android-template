@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun View.statusBarHeightPx(): Int {
    val insets = ViewCompat.getRootWindowInsets(this)
    val top = insets?.getInsets(WindowInsetsCompat.Type.statusBars())?.top ?: 0
    return top
}

fun View.navigationBarHeightPx(): Int {
    val insets = ViewCompat.getRootWindowInsets(this)
    val bottom = insets?.getInsets(WindowInsetsCompat.Type.navigationBars())?.bottom ?: 0
    return bottom
}

inline val Context.actionBarHeight: Int
    get() {
        val typedValue = TypedValue()
        return if (theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)
        } else 0
    }