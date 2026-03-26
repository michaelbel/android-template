@file:Suppress("unused", "ObsoleteSdkInt")

package org.michaelbel.shared.ktx

import android.provider.Settings
import android.view.Window
import android.view.WindowManager.LayoutParams
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.core.view.WindowInsetsControllerCompat

fun Window.setLightStatusBar(state: Boolean) {
    val windowInsetControllerCompat = WindowInsetsControllerCompat(this, decorView)
    windowInsetControllerCompat.isAppearanceLightStatusBars = state
}

fun Window.setLightNavigationBar(state: Boolean) {
    val windowInsetControllerCompat = WindowInsetsControllerCompat(this, decorView)
    windowInsetControllerCompat.isAppearanceLightNavigationBars = state
}

fun Window.updateAttributes(block: LayoutParams.() -> Unit) {
    val layoutParams = LayoutParams()
    layoutParams.copyFrom(attributes)
    layoutParams.apply(block)
    attributes = layoutParams
}

@Composable
fun isThreeButtonNav(): Boolean {
    val context = LocalContext.current
    val v = Settings.Secure.getInt(context.contentResolver, "navigation_mode", -1)
    if (v in 0..2) return v == 0
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current
    val gestures = WindowInsets.systemGestures
    val hasGestureInsets = gestures.getLeft(density, layoutDirection) > 0 || gestures.getRight(density, layoutDirection) > 0 || gestures.getTop(density) > 0 || gestures.getBottom(density) > 0
    return !hasGestureInsets
}
