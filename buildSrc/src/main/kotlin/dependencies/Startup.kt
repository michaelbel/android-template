@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation
import org.michaelbel.template.extensions.api

/**
 * Startup
 *
 * @see <a href="https://d.android.com/jetpack/androidx/releases/startup">Startup</a>
 */

private const val StartupVersion = "1.1.1"

private const val Startup = "androidx.startup:startup-runtime:$StartupVersion"

fun DependencyHandler.implementationStartupDependencies() {
    implementation(Startup)
}

fun DependencyHandler.apiStartupDependencies() {
    api(Startup)
}