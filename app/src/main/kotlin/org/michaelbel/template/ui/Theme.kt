package org.michaelbel.template.ui

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
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

@RequiresApi(31)
fun Context.dynamicColorScheme(darkTheme: Boolean): ColorScheme {
    return if (darkTheme) {
        dynamicDarkColorScheme(this)
    } else {
        dynamicLightColorScheme(this)
    }
}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val context: Context = LocalContext.current

    val appColorScheme: ColorScheme = if (Build.VERSION.SDK_INT >= 31) {
        context.dynamicColorScheme(darkTheme)
    } else {
        if (darkTheme) {
            DarkColorScheme
        } else {
            LightColorScheme
        }
    }

    MaterialTheme(
        colorScheme = appColorScheme,
        content = content
    )
}