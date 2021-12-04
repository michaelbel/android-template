package org.michaelbel.template.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.michaelbel.template.R

private val openSansFontFamily = FontFamily(
    Font(R.font.open_sans),
    Font(R.font.open_sans_bold, FontWeight.Bold),
    Font(R.font.open_sans_extrabold, FontWeight.ExtraBold),
    Font(R.font.open_sans_light, FontWeight.Light),
    Font(R.font.open_sans_semibold, FontWeight.SemiBold)
)

private fun typographyFromDefaults(
    displayLarge: TextStyle?,
    displayMedium: TextStyle?,
    displaySmall: TextStyle?,
    headlineLarge: TextStyle?,
    headlineMedium: TextStyle?,
    headlineSmall: TextStyle?,
    titleLarge: TextStyle?,
    titleMedium: TextStyle?,
    titleSmall: TextStyle?,
    bodyLarge: TextStyle?,
    bodyMedium: TextStyle?,
    bodySmall: TextStyle?,
    labelLarge: TextStyle?,
    labelMedium: TextStyle?,
    labelSmall: TextStyle?
): Typography {
    val defaults = Typography()
    return Typography(
        displayLarge = defaults.displayLarge.merge(displayLarge),
        displayMedium = defaults.displayMedium.merge(displayMedium),
        displaySmall = defaults.displaySmall.merge(displaySmall),
        headlineLarge = defaults.headlineLarge.merge(headlineLarge),
        headlineMedium = defaults.headlineMedium.merge(headlineMedium),
        headlineSmall = defaults.headlineSmall.merge(headlineSmall),
        titleLarge = defaults.titleLarge.merge(titleLarge),
        titleMedium = defaults.titleMedium.merge(titleMedium),
        titleSmall = defaults.titleSmall.merge(titleSmall),
        bodyLarge = defaults.bodyLarge.merge(bodyLarge),
        bodyMedium = defaults.bodyMedium.merge(bodyMedium),
        bodySmall = defaults.bodySmall.merge(bodySmall),
        labelLarge = defaults.labelLarge.merge(labelLarge),
        labelMedium = defaults.labelMedium.merge(labelMedium),
        labelSmall = defaults.labelSmall.merge(labelSmall)
    )
}

val AppTypography = typographyFromDefaults(
    displayLarge = TextStyle(
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight.Bold
    ),
    displayMedium = TextStyle(
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight.Bold
    ),
    displaySmall = TextStyle(
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight.Bold
    ),
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
)