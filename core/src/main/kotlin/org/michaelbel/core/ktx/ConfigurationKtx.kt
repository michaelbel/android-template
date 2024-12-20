@file:Suppress("unused", "ObsoleteSdkInt", "RestrictedApi")

package org.michaelbel.core.ktx

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Insets
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.WindowMetrics
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.core.content.ContextCompat
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowLayoutInfo

inline val Context.deviceWidth: Int
    get() {
        val windowManager: WindowManager = ContextCompat
            .getSystemService(this, WindowManager::class.java) as WindowManager

        return if (Build.VERSION.SDK_INT >= 30) {
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMetrics.bounds.width() - insets.left - insets.right
        } else {
            val displayMetrics = DisplayMetrics()
            display.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
    }

inline val Context.deviceHeight: Int
    get() {
        val windowManager: WindowManager = ContextCompat
            .getSystemService(this, WindowManager::class.java) as WindowManager

        return if (Build.VERSION.SDK_INT >= 30) {
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMetrics.bounds.height() - insets.top - insets.bottom
        } else {
            val displayMetrics = DisplayMetrics()
            display.getMetrics(displayMetrics)
            displayMetrics.heightPixels
        }
    }

inline val Context.isPortrait: Boolean
    get() = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

inline val Context.isLandscape: Boolean
    get() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

inline val Context.isRTL: Boolean
    get() = resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL

inline val Context.isLTR: Boolean
    get() = resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_LTR

inline val Context.versionName: String?
    get() = try {
        packageManager.getPackageInfo(packageName, 0).versionName
    } catch (e: PackageManager.NameNotFoundException) {
        null
    }

inline val Context.versionCode: Long?
    get() = try {
        if (Build.VERSION.SDK_INT >= 28) {
            packageManager.getPackageInfo(packageName, 0).longVersionCode
        } else {
            packageManager.getPackageInfo(packageName, 0).versionCode.toLong()
        }
    } catch (e: PackageManager.NameNotFoundException) {
        null
    }

inline val screenWidth: Int
    @Composable get() {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp
    }

inline val screenHeight: Int
    @Composable get() {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp
    }

inline val screenWidthDp: Dp
    @Composable get() {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp.dp
    }

inline val screenHeightDp: Dp
    @Composable get() {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp.dp
    }

inline val screenWidthPx: Float
    @Composable get() {
        val density = LocalDensity.current
        val screenWidthPx = with(density) { screenWidthDp.toPx() }
        return screenWidthPx
    }

inline val screenHeightPx: Float
    @Composable get() {
        val density = LocalDensity.current
        val screenHeightPx = with(density) { screenHeightDp.toPx() }
        return screenHeightPx
    }

inline val aspectRatio: Float
    @Composable get() = screenWidthPx / screenHeightPx

inline val isPortrait: Boolean
    @Composable get() = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT

inline val isLandscape: Boolean
    @Composable get() = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

inline val isTabletPortrait: Boolean
    @Composable get() = !isFoldable() && isPortrait && screenWidth >= 600

inline val isTabletLandscape: Boolean
    @Composable get() = !isFoldable() && isLandscape && screenWidth >= 1200

inline val isDesktop: Boolean
    @Composable get() {
        val adaptiveInfo = currentWindowAdaptiveInfo()
        val density = LocalDensity.current
        val windowSize = with(density) { currentWindowSize().toSize().toDpSize() }
        return adaptiveInfo.windowSizeClass.isExpanded && windowSize.width >= 1920.dp
    }

@Composable
fun isFoldable(): Boolean {
    val context = LocalContext.current
    val windowLayoutInfo = remember { WindowInfoTracker.getOrCreate(context).windowLayoutInfo(context) }
    val foldableState = windowLayoutInfo.collectAsState(initial = WindowLayoutInfo(emptyList()))
    return foldableState.value.displayFeatures.any { it is FoldingFeature }
}