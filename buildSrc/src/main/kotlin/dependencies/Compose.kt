@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestApi
import org.michaelbel.template.extensions.androidTestImplementation
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.debugApi
import org.michaelbel.template.extensions.implementation
import org.michaelbel.template.extensions.debugImplementation

/**
 * Jetpack Compose
 *
 * @see <a href="https://d.android.com/jetpack/androidx/releases/compose">Compose</a>
 */

private const val ComposeCompilerVersion = "1.3.0"
private const val ComposeAnimationVersion = "1.2.1"
private const val ComposeFoundationVersion = "1.2.1"
private const val ComposeMaterialVersion = "1.2.1"
private const val ComposeRuntimeVersion = "1.2.1"
private const val ComposeUiVersion = "1.2.1"

private const val Material3Version = "1.0.0-alpha11"
private const val Material3SamplesVersion = "1.0.0-SNAPSHOT"
private const val MaterialIconsVersion = "1.1.0-SNAPSHOT"

private const val ComposeAnimation = "androidx.compose.animation:animation:$ComposeAnimationVersion"
private const val ComposeAnimationCore = "androidx.compose.animation:animation-core:$ComposeAnimationVersion"
private const val ComposeAnimationGraphics = "androidx.compose.animation:animation-graphics:$ComposeAnimationVersion"
private const val ComposeCompiler = "androidx.compose.compiler:compiler:$ComposeCompilerVersion"
private const val ComposeFoundation = "androidx.compose.foundation:foundation:$ComposeFoundationVersion"
private const val ComposeFoundationLayout = "androidx.compose.foundation:foundation-layout:$ComposeFoundationVersion"
private const val ComposeMaterialIconsCore = "androidx.compose.material:material-icons-core-samples:$MaterialIconsVersion"
private const val ComposeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:$ComposeMaterialVersion"
private const val ComposeMaterial3 = "androidx.compose.material3:material3:$Material3Version"
private const val ComposeMaterial3Samples = "androidx.compose.material3:material3-samples:$Material3SamplesVersion"
private const val ComposeRuntime = "androidx.compose.runtime:runtime:$ComposeRuntimeVersion"
private const val ComposeRuntimeLivedata = "androidx.compose.runtime:runtime-livedata:$ComposeRuntimeVersion"
private const val ComposeUi = "androidx.compose.ui:ui:$ComposeUiVersion"
private const val ComposeUiGeometry = "androidx.compose.ui:ui-geometry:$ComposeUiVersion"
private const val ComposeUiGraphics = "androidx.compose.ui:ui-graphics:$ComposeUiVersion"
private const val ComposeUiText = "androidx.compose.ui:ui-text:$ComposeUiVersion"
private const val ComposeUiUtil = "androidx.compose.ui:ui-util:$ComposeUiVersion"
private const val ComposeUiTest = "androidx.compose.ui:ui-test-junit4:$ComposeUiVersion"
private const val ComposeUiTestManifest = "androidx.compose.ui:ui-test-manifest:$ComposeUiVersion"
private const val ComposeUiTooling = "androidx.compose.ui:ui-tooling:$ComposeUiVersion"
private const val ComposeUiViewBinding = "androidx.compose.ui:ui-viewbinding:$ComposeUiVersion"

const val OptExperimentalAnimationApi = "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"
const val OptExperimentalComposeUiApi = "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi"
const val OptExperimentalFoundationApi = "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi"

fun DependencyHandler.implementationComposeDependencies() {
    implementation(ComposeCompiler)
    implementation(ComposeFoundation)
    implementation(ComposeFoundationLayout)
    implementation(ComposeMaterialIconsCore)
    implementation(ComposeMaterialIconsExtended)
    implementation(ComposeMaterial3)
    implementation(ComposeMaterial3Samples)
    implementation(ComposeRuntime)
    implementation(ComposeRuntimeLivedata)
    implementation(ComposeUi)
    implementation(ComposeUiViewBinding)
    implementation(ComposeUiTooling)
    debugImplementation(ComposeUiTestManifest)
    androidTestImplementation(ComposeUiTest)
}

fun DependencyHandler.apiComposeDependencies() {
    api(ComposeCompiler)
    api(ComposeFoundation)
    api(ComposeFoundationLayout)
    api(ComposeMaterialIconsCore)
    api(ComposeMaterialIconsExtended)
    api(ComposeMaterial3)
    api(ComposeMaterial3Samples)
    api(ComposeRuntime)
    api(ComposeRuntimeLivedata)
    api(ComposeUi)
    api(ComposeUiViewBinding)
    api(ComposeUiTooling)
    debugApi(ComposeUiTestManifest)
    androidTestApi(ComposeUiTest)
}

fun DependencyHandler.implementationComposeTestDependencies() {
    androidTestImplementation(ComposeUiTest)
    implementation(ComposeUiTestManifest)
}