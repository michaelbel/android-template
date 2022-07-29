@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation
import org.michaelbel.template.extensions.api

/**
 * RecyclerView
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/recyclerview">RecyclerView</a>
 */

private const val RecyclerViewVersion = "1.2.1"
private const val RecyclerviewSelectionVersion = "1.1.0"

private const val RecyclerView = "androidx.recyclerview:recyclerview:$RecyclerViewVersion"
private const val RecyclerViewSelection = "androidx.recyclerview:recyclerview-selection:$RecyclerviewSelectionVersion"

fun DependencyHandler.implementationRecyclerViewDependencies() {
    implementation(RecyclerView)
    implementation(RecyclerViewSelection)
}

fun DependencyHandler.apiRecyclerViewDependencies() {
    api(RecyclerView)
    api(RecyclerViewSelection)
}