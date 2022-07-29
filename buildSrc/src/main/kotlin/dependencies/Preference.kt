@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Preference
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/preference">Preference</a>
 */

private const val PreferenceVersion = "1.2.0"

private const val Preference = "androidx.preference:preference-ktx:$PreferenceVersion"

fun DependencyHandler.implementationPreferenceDependencies() {
    implementation(Preference)
}