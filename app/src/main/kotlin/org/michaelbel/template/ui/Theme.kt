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

@RequiresApi(31)
private fun Context.dynamicColorScheme(darkTheme: Boolean): ColorScheme {
    return if (darkTheme) {
        dynamicDarkColorScheme(this)
    } else {
        dynamicLightColorScheme(this)
    }
}

@Composable
fun TemplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColors: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val dynamicColorsAvailable = Build.VERSION.SDK_INT >= 31

    val colorScheme = if (dynamicColorsAvailable && dynamicColors) {
        context.dynamicColorScheme(darkTheme)
    } else {
        if (darkTheme) darkColorScheme() else lightColorScheme()
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}