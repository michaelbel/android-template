@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Palette
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/palette">Palette</a>
 */

private const val PaletteVersion = "1.0.0"

private const val Palette = "androidx.palette:palette-ktx:$PaletteVersion"

fun DependencyHandler.implementationPaletteDependencies() {
    implementation(Palette)
}