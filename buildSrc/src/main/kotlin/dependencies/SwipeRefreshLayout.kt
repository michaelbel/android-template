@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * SwipeRefreshLayout
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout">SwipeRefreshLayout</a>
 */

private const val SwipeRefreshLayoutVersion = "1.1.0"

private const val SwipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:$SwipeRefreshLayoutVersion"

fun DependencyHandler.implementationSwipeRefreshLayoutDependencies() {
    implementation(SwipeRefreshLayout)
}