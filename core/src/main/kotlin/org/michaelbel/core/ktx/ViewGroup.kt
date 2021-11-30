@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.view.View
import android.view.ViewGroup

inline fun <reified V> ViewGroup.filterIsInstance(): List<V> {
    val views = mutableListOf<V>()
    for (index in 0 until childCount) {
        val view: View = getChildAt(index)
        if (view is V) {
            views.add(view)
        }
    }
    return views
}