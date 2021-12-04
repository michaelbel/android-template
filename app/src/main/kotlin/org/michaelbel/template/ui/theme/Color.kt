package org.michaelbel.template.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.luminance
import kotlin.math.max
import kotlin.math.min

/**
 * Return the fully opaque color that results from compositing [onSurface] atop [surface] with the
 * given [alpha]. Useful for situations where semi-transparent colors are undesirable.
 */
@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}

fun Color.contrastAgainst(background: Color): Float {
    val fg = if (alpha < 1F) compositeOver(background) else this

    val fgLuminance = fg.luminance() + 0.05F
    val bgLuminance = background.luminance() + 0.05F

    return max(fgLuminance, bgLuminance) / min(fgLuminance, bgLuminance)
}