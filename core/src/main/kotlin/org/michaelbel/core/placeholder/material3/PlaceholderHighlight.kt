package org.michaelbel.core.placeholder.material3

import androidx.annotation.FloatRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.runtime.Composable
import org.michaelbel.core.placeholder.PlaceholderDefaults
import org.michaelbel.core.placeholder.PlaceholderHighlight
import org.michaelbel.core.placeholder.fade
import org.michaelbel.core.placeholder.shimmer

/**
 * Creates a [PlaceholderHighlight] which fades in an appropriate color, using the
 * given [animationSpec].
 *
 * @param animationSpec the [AnimationSpec] to configure the animation.
 */
@Composable
fun PlaceholderHighlight.Companion.fade(
    animationSpec: InfiniteRepeatableSpec<Float> = PlaceholderDefaults.fadeAnimationSpec
) = PlaceholderHighlight.fade(
    highlightColor = PlaceholderDefaults.fadeHighlightColor(),
    animationSpec = animationSpec,
)

/**
 * Creates a [PlaceholderHighlight] which 'shimmers', using a default color.
 *
 * The highlight starts at the top-start, and then grows to the bottom-end during the animation.
 * During that time it is also faded in, from 0f..progressForMaxAlpha, and then faded out from
 * progressForMaxAlpha..1F.
 *
 * @param animationSpec the [AnimationSpec] to configure the animation.
 * @param progressForMaxAlpha The progress where the shimmer should be at it's peak opacity.
 * Defaults to 0.6F.
 */
@Composable
internal fun PlaceholderHighlight.Companion.shimmer(
    animationSpec: InfiniteRepeatableSpec<Float> = PlaceholderDefaults.shimmerAnimationSpec,
    @FloatRange(from = 0.0, to = 1.0) progressForMaxAlpha: Float = 0.6F
): PlaceholderHighlight = PlaceholderHighlight.shimmer(
    highlightColor = PlaceholderDefaults.shimmerHighlightColor(),
    animationSpec = animationSpec,
    progressForMaxAlpha = progressForMaxAlpha,
)