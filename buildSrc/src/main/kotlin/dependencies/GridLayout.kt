@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * GridLayout
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/gridlayout">GridLayout</a>
 */

private const val GridLayoutVersion = "1.0.0"

private const val GridLayout = "androidx.gridlayout:gridlayout:$GridLayoutVersion"

fun DependencyHandler.implementationGridLayoutDependencies() {
    implementation(GridLayout)
}