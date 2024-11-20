@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.animation.ValueAnimator

inline fun ValueAnimator.doOnUpdate(
    crossinline action: (animator: ValueAnimator) -> Unit
) = addUpdateListener { action(it) }