@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.os.Build
import android.view.Window
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

fun Window.setLightStatusBar(state: Boolean) {
    val windowInsetControllerCompat = WindowInsetsControllerCompat(this, decorView)
    windowInsetControllerCompat.isAppearanceLightStatusBars = state
}

fun Window.setLightNavigationBar(state: Boolean) {
    val windowInsetControllerCompat = WindowInsetsControllerCompat(this, decorView)
    windowInsetControllerCompat.isAppearanceLightNavigationBars = state
}

fun Window.setStatusBarColorRes(@ColorRes colorResId: Int) {
    statusBarColor = ContextCompat.getColor(context, colorResId)
}

fun Window.setNavigationBarColorRes(@ColorRes colorResId: Int) {
    navigationBarColor = ContextCompat.getColor(context, colorResId)
}

fun Window.setNavigationBarDividerColorRes(@ColorRes colorResId: Int) {
    if (Build.VERSION.SDK_INT >= 28) {
        navigationBarDividerColor = ContextCompat.getColor(context, colorResId)
    }
}