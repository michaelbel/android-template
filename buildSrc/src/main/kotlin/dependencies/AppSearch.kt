@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * AppSearch
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/appsearch">AppSearch</a>
 */

private const val AppSearchVersion = "1.0.0-alpha04"

private const val AppSearch = "androidx.appsearch:appsearch:$AppSearchVersion"
private const val AppSearchCompiler = "androidx.appsearch:appsearch-compiler:$AppSearchVersion"
private const val AppSearchLocalStorage = "androidx.appsearch:appsearch-local-storage:$AppSearchVersion"
private const val AppSearchPlatformStorage = "androidx.appsearch:appsearch-platform-storage:$AppSearchVersion"

fun DependencyHandler.implementationAppSearchDependencies() {
    implementation(AppSearch)
    implementation(AppSearchCompiler)
    implementation(AppSearchLocalStorage)
    implementation(AppSearchPlatformStorage)
}