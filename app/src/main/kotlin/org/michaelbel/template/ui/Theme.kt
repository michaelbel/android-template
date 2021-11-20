package org.michaelbel.template.ui

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightThemeColors = lightColors(

)

private val DarkThemeColors = darkColors(

)

private object AppRippleTheme: RippleTheme {

    @Composable
    override fun defaultColor(): Color = MaterialTheme.colors.primary

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Color.Black,
        lightTheme = !isSystemInDarkTheme()
    )
}

@Composable
fun AppTheme(
    theme: Int = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM,
    content: @Composable () -> Unit
) {
    val autoColors = if (isSystemInDarkTheme()) DarkThemeColors else LightThemeColors

    val dynamicColors: Colors = if (Build.VERSION.SDK_INT >= 31) {
        val context = LocalContext.current
        if (isSystemInDarkTheme()) dynamicDarkColorScheme(context) else dynamicLightColorScheme(
            context
        )
        autoColors
    } else autoColors

    val colors = when (theme) {
        AppCompatDelegate.MODE_NIGHT_NO -> LightThemeColors
        AppCompatDelegate.MODE_NIGHT_YES -> DarkThemeColors
        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -> autoColors
        else -> dynamicColors
    }

    MaterialTheme(
        colors = colors,
        typography = AppTypography,
        shapes = AppShapes
    ) {
        CompositionLocalProvider(
            LocalRippleTheme provides AppRippleTheme,
            content = content
        )
    }
}