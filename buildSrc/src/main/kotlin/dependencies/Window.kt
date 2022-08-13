@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * WindowManager
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/window">WindowManager</a>
 */

private const val WindowVersion = "1.0.0"

private const val Window = "androidx.window:window:$WindowVersion"
private const val WindowTesting = "androidx.window:window-testing:$WindowVersion"

fun DependencyHandler.implementationWindowDependencies() {
    implementation(Window)
    implementation(WindowTesting)
}

fun DependencyHandler.apiWindowDependencies() {
    api(Window)
    api(WindowTesting)
}