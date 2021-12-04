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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.michaelbel.template.R

private val YellowLightThemeColorScheme = lightColorScheme(
    primary = yellow500,
    onPrimary = Color.Black,
    secondary = blue700,
    onSecondary = Color.White
)

private val YellowDarkThemeColorScheme = darkColorScheme(
    primary = yellow200,
    secondary = blue200,
    onSecondary = Color.Black,
    surface = yellowDarkPrimary
)

@Composable
fun YellowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = if (darkTheme) {
        YellowDarkThemeColorScheme
    } else {
        YellowLightThemeColorScheme
    }
    AppTheme(darkTheme, colorScheme, content)
}

private val BlueLightThemeColorScheme = lightColorScheme(
    primary = blue700,
    onPrimary = Color.White,
    secondary = yellow500
)

private val BlueDarkThemeColorScheme = darkColorScheme(
    primary = blue200,
    secondary = yellow200,
    surface = blueDarkPrimary
)

@Composable
fun BlueTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = if (darkTheme) {
        BlueDarkThemeColorScheme
    } else {
        BlueLightThemeColorScheme
    }
    AppTheme(darkTheme, colorScheme, content)
}

private val PinkLightThemeColorScheme = lightColorScheme(
    primary = pink500,
    secondary = pink500,
    onPrimary = Color.Black,
    onSecondary = Color.Black
)

private val PinkDarkThemeColorScheme = darkColorScheme(
    primary = pink200,
    secondary = pink200,
    surface = pinkDarkPrimary
)

@Composable
fun PinkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = if (darkTheme) {
        PinkDarkThemeColorScheme
    } else {
        PinkLightThemeColorScheme
    }
    AppTheme(darkTheme, colorScheme, content)
}

/*private object AppRippleTheme: RippleTheme {

    @Composable
    override fun defaultColor(): Color = MaterialTheme.colorScheme.primary

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Color.Black,
        lightTheme = !isSystemInDarkTheme()
    )
}*/

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
        YellowDarkThemeColorScheme
    } else {
        YellowLightThemeColorScheme
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
}