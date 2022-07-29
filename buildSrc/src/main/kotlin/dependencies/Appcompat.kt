@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api

/**
 * Appcompat
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/appcompat">Appcompat</a>
 */

private const val AppCompatVersion = "1.4.1"

private const val AppCompat = "androidx.appcompat:appcompat:$AppCompatVersion"
private const val AppCompatResources = "androidx.appcompat:appcompat-resources:$AppCompatVersion"

fun DependencyHandler.apiAppcompatDependencies() {
    api(AppCompat)
    api(AppCompatResources)
}