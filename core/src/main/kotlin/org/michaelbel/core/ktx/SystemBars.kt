@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.WindowManager

inline val Context.deviceWidth: Int
    get() {
        val windowManager: WindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        return point.x
    }

inline val Context.deviceHeight: Int
    get() {
        val windowManager: WindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        return point.y
    }

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