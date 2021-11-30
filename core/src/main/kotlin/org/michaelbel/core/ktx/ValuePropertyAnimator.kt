@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.animation.Animator
import android.view.ViewPropertyAnimator

interface CustomAnimatorListener: Animator.AnimatorListener {
    override fun onAnimationStart(it: Animator?) {}
    override fun onAnimationEnd(it: Animator?) {}
    override fun onAnimationCancel(it: Animator?) {}
    override fun onAnimationRepeat(it: Animator?) {}
}

inline fun ViewPropertyAnimator.doOnStart(
    crossinline action: (animator: Animator?) -> Unit
): ViewPropertyAnimator {
    return setListener(object: CustomAnimatorListener {
        override fun onAnimationStart(it: Animator?) {
            action(it)
        }
    })
}

inline fun ViewPropertyAnimator.doOnEnd(
    crossinline action: (animator: Animator?) -> Unit
): ViewPropertyAnimator {
    return setListener(object: CustomAnimatorListener {
        override fun onAnimationEnd(it: Animator?) {
            action(it)
        }
    })
}