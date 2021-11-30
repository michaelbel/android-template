@file:Suppress("unused")

package org.michaelbel.core.ktx

import androidx.transition.Transition
import androidx.transition.TransitionListenerAdapter
import androidx.transition.TransitionSet

inline fun TransitionSet.doOnTransitionEnd(crossinline action: () -> Unit) {
    addListener(object: TransitionListenerAdapter() {
        override fun onTransitionEnd(transition: Transition) {
            action()
        }
    })
}