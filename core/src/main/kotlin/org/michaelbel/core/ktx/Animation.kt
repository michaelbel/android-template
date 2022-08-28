@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.view.animation.Animation

interface CustomAnimationListener: Animation.AnimationListener {
    override fun onAnimationStart(animation: Animation?) {}
    override fun onAnimationEnd(animation: Animation?) {}
    override fun onAnimationRepeat(animation: Animation?) {}
}

inline fun Animation.doOnEnd(
    crossinline action: (animation: Animation?) -> Unit
) {
    setAnimationListener(object: CustomAnimationListener {
        override fun onAnimationEnd(animation: Animation?) {
            action(animation)
        }
    })
}