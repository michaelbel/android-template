@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * CardView
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/cardview">CardView</a>
 */

private const val CardViewVersion = "1.0.0"

private const val CardView = "androidx.cardview:cardview:$CardViewVersion"

fun DependencyHandler.implementationCardViewDependencies() {
    implementation(CardView)
}