package org.michaelbel.template.ui.theme

import android.content.Context
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme()

private val DarkColorScheme = darkColorScheme()

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val context: Context = LocalContext.current

    val dynamicColorScheme: ColorScheme = if (isSystemInDarkTheme()) {
        dynamicDarkColorScheme(context)
    } else {
        dynamicLightColorScheme(context)
    }

    val autoColorScheme: ColorScheme = if (isSystemInDarkTheme()) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val appColorScheme: ColorScheme = if (Build.VERSION.SDK_INT >= 31) {
        dynamicColorScheme
    } else {
        autoColorScheme
    }

    MaterialTheme(
        colorScheme = appColorScheme,
        content = content
    )
}

/*private object AppRippleTheme: RippleTheme {

    @Composable
    override fun defaultColor(): Color = MaterialTheme.colorScheme.primary

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Color.Black,
        lightTheme = !isSystemInDarkTheme()
    )
}

private val LightElevation = Elevations()
private val DarkElevation = Elevations(card = 1.dp)

private val LightImages = Images(lockupLogo = R.drawable.ic_outline_error_24)
private val DarkImages = Images(lockupLogo = R.drawable.ic_outline_error_24)

@Composable
fun AppTheme(
    darkTheme: Boolean,
    colorScheme: ColorScheme,
    content: @Composable () -> Unit
) {
    val elevation = if (darkTheme) DarkElevation else LightElevation
    val images = if (darkTheme) DarkImages else LightImages
    CompositionLocalProvider(
        LocalElevations provides elevation,
        LocalImages provides images
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}*/