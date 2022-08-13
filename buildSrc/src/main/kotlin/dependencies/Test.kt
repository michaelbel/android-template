@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestApi
import org.michaelbel.template.extensions.androidTestImplementation
import org.michaelbel.template.extensions.testApi

/**
 * Test
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/test">Test</a>
 */

private const val TestCoreVersion = "1.4.0"
private const val TestEspressoVersion = "3.4.0"
private const val TestExtJunitVersion = "1.1.3"
private const val TestExtTruthVersion = "1.4.0"
private const val TestJunitVersion = "1.1.3"
private const val TestOrchestratorVersion = "1.4.1"
private const val TestRulesVersion = "1.4.0"
private const val TestRunnerVersion = "1.4.0"
private const val TestUiAutomatorVersion = "2.2.0"

private const val TestCore = "androidx.test:core-ktx:$TestCoreVersion"
private const val TestEspressoAccessibility = "androidx.test.espresso:espresso-accessibility:$TestEspressoVersion"
private const val TestEspressoContrib = "androidx.test.espresso:espresso-contrib:$TestEspressoVersion"
private const val TestEspressoCore = "androidx.test.espresso:espresso-core:$TestEspressoVersion"
private const val TestEspressoIntents = "androidx.test.espresso:espresso-intents:$TestEspressoVersion"
private const val TestExtJunit = "androidx.test.ext:junit-ktx:$TestExtJunitVersion"
private const val TestExtTruth = "androidx.test.ext:truth:$TestExtTruthVersion"
private const val TestOrchestrator = "androidx.test:orchestrator:$TestOrchestratorVersion"
private const val TestRules = "androidx.test:rules:$TestRulesVersion"
private const val AndroidxTestRunner = "androidx.test:runner:$TestRunnerVersion"
private const val TestUiAutomator = "androidx.test.uiautomator:uiautomator:$TestUiAutomatorVersion"

fun DependencyHandler.implementationJetpackTestDependencies() {
    androidTestImplementation(TestCore)
    androidTestImplementation(TestExtJunit)
    androidTestImplementation(TestEspressoCore)
}

fun DependencyHandler.apiJetpackTestDependencies() {
    testApi(TestCore)
    androidTestApi(TestExtJunit)
    androidTestApi(TestEspressoCore)
    androidTestApi(TestCore)
    androidTestApi(AndroidxTestRunner)
    androidTestApi(TestExtTruth)
    androidTestApi(TestEspressoAccessibility)
    androidTestApi(TestEspressoContrib)
    androidTestApi(TestEspressoIntents)
    androidTestApi(TestUiAutomator)
    androidTestApi(TestRules)
}