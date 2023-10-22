@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Webkit
 *
 * Updated August 24, 2022
 * @see <a href="https://d.android.com/jetpack/androidx/releases/webkit">Webkit</a>
 */

private const val WebkitVersion = "1.5.0"

private const val Webkit = "androidx.webkit:webkit:$WebkitVersion"

fun DependencyHandler.implementationWebkitDependencies() {
    implementation(Webkit)
}