@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.Insets
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowInsets
import android.view.WindowMetrics
import androidx.core.view.ViewCompat

@Suppress("Deprecation")
inline val Activity.deviceWidth: Int
    get() {
        return if (Build.VERSION.SDK_INT >= 30) {
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets.getInsetsIgnoringVisibility(
                WindowInsets.Type.systemBars()
            )
            windowMetrics.bounds.width() - insets.left - insets.right
        } else {
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
    }

@Suppress("Deprecation")
inline val Activity.deviceHeight: Int
    get() {
        return if (Build.VERSION.SDK_INT >= 30) {
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets.getInsetsIgnoringVisibility(
                WindowInsets.Type.systemBars()
            )
            windowMetrics.bounds.height() - insets.top - insets.bottom
        } else {
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.heightPixels
        }
    }

inline val Context.isPortrait: Boolean
    get() = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

inline val Context.isLandscape: Boolean
    get() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

inline val Context.isRTL: Boolean
    get() = resources.configuration.layoutDirection == ViewCompat.LAYOUT_DIRECTION_RTL

inline val Context.isLTR: Boolean
    get() = resources.configuration.layoutDirection == ViewCompat.LAYOUT_DIRECTION_LTR