@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.util.TypedValue

inline val Context.statusBarHeight: Int
    get() {
        val resId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (resId > 0) resources.getDimensionPixelSize(resId) else 0
    }

inline val Context.navigationBarHeight: Int
    get() {
        val resId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resId > 0) resources.getDimensionPixelSize(resId) else 0
    }

inline val Context.actionBarHeight: Int
    get() {
        val typedValue = TypedValue()
        return if (theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)
        } else 0
    }