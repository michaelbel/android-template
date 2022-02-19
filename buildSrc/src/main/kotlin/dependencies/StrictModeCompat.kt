@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * StrictModeCompat
 *
 * @see <a href="https://github.com/androidbroadcast/StrictModeCompat">StrictModeCompat</a>
 */

private const val StrictModeCompatVersion = "30.2.0"

private const val StrictModeCompat = "com.github.kirich1409:strict-mode-compat-ktx:$StrictModeCompatVersion"

fun DependencyHandler.implementationStrictModeCompatDependencies() {
    implementation(StrictModeCompat)
}