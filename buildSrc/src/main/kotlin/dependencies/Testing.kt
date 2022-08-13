@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestApi
import org.michaelbel.template.extensions.testApi
import org.michaelbel.template.extensions.testImplementation

/**
 * Testing
 *
 * @see <a href="https://junit.org/junit5">JUnit</a>
 * @see <a href="https://mockk.io">Mockk</a>
 * @see <a href="https://github.com/mockito/mockito">Mockito</a>
 * @see <a href="https://github.com/cashapp/turbine">Turbine</a>
 * @see <a href="https://github.com/robolectric/robolectric">Robolectric</a>
 * @see <a href="https://github.com/KasperskyLab/Kaspresso">Kaspresso</a>
 */

private const val JunitVersion = "4.13.2"
private const val MockkVersion = "1.12.2"
private const val MockitoVersion = "4.3.1"
private const val RobolectricVersion = "4.7.3"
private const val TruthVersion = "1.1.3"
private const val TurbineVersion = "0.7.0"
private const val KaspressoVersion = "1.4.0"

private const val Junit = "junit:junit:$JunitVersion"
private const val Mockk = "io.mockk:mockk:$MockkVersion"
private const val Mockito = "org.mockito:mockito-core:$MockitoVersion"
private const val Robolectric = "org.robolectric:robolectric:$RobolectricVersion"
private const val Truth = "com.google.truth:truth:$TruthVersion"
private const val Turbine = "app.cash.turbine:turbine:$TurbineVersion"
private const val Kaspresso = "com.kaspersky.android-components:kaspresso:$KaspressoVersion"
private const val KaspressoAllure = "com.kaspersky.android-components:kaspresso-allure-support:$KaspressoVersion"
private const val KaspressoCompose = "com.kaspersky.android-components:kaspresso-compose-support:$KaspressoVersion"

const val TestRunner = "androidx.test.runner.AndroidJUnitRunner"
const val BenchmarkRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"

fun DependencyHandler.implementationTestDependencies() {
    testImplementation(Junit)
}

fun DependencyHandler.apiTestDependencies() {
    testApi(Junit)
    testApi(Mockk)
    testApi(Mockito)
    testApi(Robolectric)
    androidTestApi(Truth)
}