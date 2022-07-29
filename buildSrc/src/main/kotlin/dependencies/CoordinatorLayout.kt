@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * CoordinatorLayout
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/coordinatorlayout">CoordinatorLayout</a>
 */

private const val CoordinatorLayoutVersion = "1.2.0"

private const val CoordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:$CoordinatorLayoutVersion"

fun DependencyHandler.implementationCoordinatorLayoutDependencies() {
    implementation(CoordinatorLayout)
}