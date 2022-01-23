@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.view.Window
import androidx.core.view.WindowInsetsControllerCompat

fun Window.setLightStatusBar(state: Boolean) {
    val windowInsetControllerCompat = WindowInsetsControllerCompat(this, decorView)
    windowInsetControllerCompat.isAppearanceLightStatusBars = state
}

fun Window.setLightNavigationBar(state: Boolean) {
    val windowInsetControllerCompat = WindowInsetsControllerCompat(this, decorView)
    windowInsetControllerCompat.isAppearanceLightNavigationBars = state
}