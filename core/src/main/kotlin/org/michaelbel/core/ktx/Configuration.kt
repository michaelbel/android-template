@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.content.res.Configuration
import android.graphics.Insets
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowInsets
import android.view.WindowManager
import android.view.WindowMetrics
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

@Suppress("Deprecation")
inline val Context.deviceWidth: Int
    get() {
        val windowManager: WindowManager = ContextCompat
            .getSystemService(this, WindowManager::class.java) as WindowManager

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
inline val Context.deviceHeight: Int
    get() {
        val windowManager: WindowManager = ContextCompat
            .getSystemService(this, WindowManager::class.java) as WindowManager

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

inline val screenWidthDp: Dp
    @Composable get() {
        val configuration: Configuration = LocalConfiguration.current
        return configuration.screenWidthDp.dp
    }

inline val screenHeightDp: Dp
    @Composable get() {
        val configuration: Configuration = LocalConfiguration.current
        return configuration.screenWidthDp.dp
    }
