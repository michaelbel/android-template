@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * Appcompat
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/appcompat">Appcompat</a>
 */

private const val AppCompatVersion = "1.5.0"

private const val AppCompat = "androidx.appcompat:appcompat:$AppCompatVersion"
private const val AppCompatResources = "androidx.appcompat:appcompat-resources:$AppCompatVersion"

fun DependencyHandler.implementationAppcompatDependencies() {
    implementation(AppCompat)
    implementation(AppCompatResources)
}

fun DependencyHandler.apiAppcompatDependencies() {
    api(AppCompat)
    api(AppCompatResources)
}