package org.michaelbel.template.extensions

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.Firebase
import org.michaelbel.template.Google
import org.michaelbel.template.Jetpack
import org.michaelbel.template.Testing

fun DependencyHandler.implementationHiltDependencies() {
    implementation(Google.HiltAndroid)
    kapt(Google.HiltCompiler)
}

fun DependencyHandler.apiJetpackDependencies() {
    api(Jetpack.Activity)
    api(Jetpack.ActivityCompose)
    api(Jetpack.AppCompat)
    api(Jetpack.Browser)
    api(Jetpack.ComposeCompiler)
    api(Jetpack.ComposeFoundation)
    api(Jetpack.ComposeFoundationLayout)
    api(Jetpack.ComposeMaterialIconsCore)
    api(Jetpack.ComposeMaterialIconsExtended)
    api(Jetpack.ComposeMaterial3)
    api(Jetpack.ComposeMaterial3Samples)
    api(Jetpack.ComposeRuntime)
    api(Jetpack.ComposeRuntimeLivedata)
    api(Jetpack.ComposeUi)
    api(Jetpack.ComposeUiViewBinding)
    api(Jetpack.ComposeUiTooling)
    api(Jetpack.ConstraintLayoutCompose)
    api(Jetpack.Core)
    api(Jetpack.CoreSplashScreen)
    api(Jetpack.DataStoreCore)
    api(Jetpack.DataStorePreferences)
    api(Jetpack.DataStorePreferencesCore)
    api(Jetpack.Fragment)
    api(Jetpack.HiltNavigationCompose)
    api(Jetpack.HiltNavigationFragment)
    api(Jetpack.HiltWork)
    api(Jetpack.LifecycleCommon)
    api(Jetpack.LifecycleLivedata)
    api(Jetpack.LifecycleRuntime)
    api(Jetpack.LifecycleViewModel)
    api(Jetpack.LifecycleViewModelSavedState)
    api(Jetpack.NavigationCompose)
    api(Jetpack.NavigationDynamic)
    api(Jetpack.NavigationFragment)
    api(Jetpack.NavigationUi)
    api(Jetpack.PagingRuntime)
    api(Jetpack.PagingCompose)
    api(Jetpack.RecyclerView)
    api(Jetpack.ResourceInspection)
    api(Jetpack.Room)
    api(Jetpack.RoomPaging)
    api(Jetpack.RoomRuntime)
    api(Jetpack.Startup)
    api(Jetpack.ViewPager2)
    api(Jetpack.Window)
    api(Jetpack.WindowTesting)
    kapt(Jetpack.LifecycleCommon)
    kapt(Jetpack.RoomCompiler)
    debugApi(Jetpack.ComposeUiTestManifest)
    testApi(Jetpack.RoomTesting)
    testApi(Jetpack.TestCore)
    androidTestApi(Jetpack.ArchCoreTesting)
    androidTestApi(Jetpack.ComposeUiTest)
    androidTestApi(Jetpack.NavigationTesting)
    androidTestApi(Jetpack.TestExtJunit)
    androidTestImplementation(Jetpack.TestEspressoCore)
    androidTestApi(Jetpack.TestCore)
    androidTestApi(Jetpack.TestRunner)
    androidTestApi(Jetpack.TestExtTruth)
    androidTestApi(Jetpack.TestEspressoAccessibility)
    androidTestApi(Jetpack.TestEspressoContrib)
    androidTestApi(Jetpack.TestEspressoIntents)
    androidTestApi(Jetpack.TestUiAutomator)
    androidTestApi(Jetpack.TestRules)
}

fun DependencyHandler.apiGoogleDependencies() {
    api(Google.Material)
    api(Google.MaterialComposeThemeAdapter)
    api(Google.PlayCore)

    api(Google.Ads)
    api(Google.Auth)
    api(Google.Base)
}

fun DependencyHandler.apiFirebaseDependencies() {
    api(Firebase.FirebaseAbt)
    api(Firebase.FirebaseAnalytics)
    api(Firebase.FirebaseCommon)
    api(Firebase.FirebaseConfig)
    api(Firebase.FirebaseCore)
    api(Firebase.FirebaseCrashlytics)
}

fun DependencyHandler.apiTestDependencies() {
    testApi(Testing.Junit)
    testApi(Testing.Mockk)
    testApi(Testing.Mockito)
    testApi(Testing.Robolectric)
    androidTestApi(Testing.Truth)
}

/**
 * Adds all the tests dependencies to android specific configuration.
 */
fun DependencyHandler.implementationTestDependencies() {
    testImplementation(Testing.Junit)
    androidTestImplementation(Jetpack.TestCore)
    androidTestImplementation(Jetpack.TestExtJunit)
    androidTestImplementation(Jetpack.TestEspressoCore)
    androidTestImplementation(Jetpack.ComposeUiTest)
    androidTestImplementation(Jetpack.NavigationTesting)
    implementation(Jetpack.ComposeUiTestManifest)
}