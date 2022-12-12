@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation
import org.michaelbel.template.extensions.kapt

/**
 * Hilt
 *
 * @see <a href="https://github.com/google/dagger/releases">Hilt</a>
 */

private const val HiltVersion = "2.44"
private const val HiltViewModelVersion = "1.0.0-alpha03"
private const val HiltNavigationVersion = "1.0.0"
private const val HiltNavigationComposeVersion = "1.0.0"
private const val HiltNavigationFragmentVersion = "1.0.0"
private const val HiltWorkVersion = "1.0.0"

const val HiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$HiltVersion"
private const val HiltAndroid = "com.google.dagger:hilt-android:$HiltVersion"
private const val HiltCompiler = "com.google.dagger:hilt-compiler:$HiltVersion"
private const val HiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$HiltViewModelVersion"
private const val HiltNavigation = "androidx.hilt:hilt-navigation:$HiltNavigationVersion"
private const val HiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$HiltNavigationComposeVersion"
private const val HiltNavigationFragment = "androidx.hilt:hilt-navigation-fragment:$HiltNavigationFragmentVersion"
private const val HiltWork = "androidx.hilt:hilt-work:$HiltWorkVersion"

fun DependencyHandler.implementationHiltDependencies() {
    implementation(HiltAndroid)
    implementation(HiltNavigationCompose)
    implementation(HiltNavigationFragment)
    implementation(HiltWork)
    kapt(HiltCompiler)
}