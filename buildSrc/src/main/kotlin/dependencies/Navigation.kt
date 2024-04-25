@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestApi
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * Navigation
 *
 * Updated September 7, 2022
 * @see <a href="https://d.android.com/jetpack/androidx/releases/navigation">Navigation</a>
 */

private const val NavigationVersion = "2.5.2"

private const val NavigationFragment = "androidx.navigation:navigation-fragment-ktx:$NavigationVersion"
private const val NavigationUi = "androidx.navigation:navigation-ui-ktx:$NavigationVersion"
private const val NavigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:$NavigationVersion"
private const val NavigationTesting = "androidx.navigation:navigation-testing:$NavigationVersion"

const val NavigationSafeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$NavigationVersion"

private const val NavigationCompose = "androidx.navigation:navigation-compose:$NavigationVersion"

fun DependencyHandler.implementationNavigationDependencies() {
    implementation("androidx.navigation:navigation-compose:2.5.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.2")
}

fun DependencyHandler.apiNavigationDependencies() {
    api(NavigationCompose)
    api(NavigationDynamic)
    api(NavigationFragment)
    api(NavigationUi)
    androidTestApi(NavigationTesting)
}