@file:Suppress("unused")

package org.michaelbel.core.ktx

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

fun ConstraintLayout.buildConstraints(
    builder: ConstraintSet.() -> Unit
) = buildConstraintLayout(this, builder)

private fun buildConstraintLayout(
    layout: ConstraintLayout,
    builder: ConstraintSet.() -> Unit
) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(layout)
    builder(constraintSet)
    constraintSet.applyTo(layout)
}