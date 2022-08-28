@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.kapt

/**
 * Lifecycle
 *
 * @see <a href="https://d.android.com/jetpack/androidx/releases/lifecycle">Lifecycle</a>
 */

private const val LifecycleVersion = "2.5.0"

private const val LifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:$LifecycleVersion"
private const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$LifecycleVersion"
private const val LifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LifecycleVersion"
private const val LifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$LifecycleVersion"
private const val LifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$LifecycleVersion"
private const val LifecycleService = "androidx.lifecycle:lifecycle-service:$LifecycleVersion"
private const val LifecycleProcess = "androidx.lifecycle:lifecycle-process:$LifecycleVersion"

fun DependencyHandler.apiLifecycleDependencies() {
    api(LifecycleCommon)
    api(LifecycleRuntime)
    api(LifecycleViewModel)
    api(LifecycleViewModelSavedState)
    kapt(LifecycleCommon)
}