package org.michaelbel.template

/**
 * Testing
 *
 * JUnit — https://junit.org/junit5
 * Mockk — https://mockk.io
 * Turbine — https://github.com/cashapp/turbine
 * Robolectric — https://github.com/robolectric/robolectric
 * Kaspresso — https://github.com/KasperskyLab/Kaspresso
 */
object Testing {
    private const val JunitVersion = "4.13.2"
    private const val MockkVersion = "1.12.2"
    private const val MockitoVersion = "4.3.1"
    private const val RobolectricVersion = "4.7.3"
    private const val TruthVersion = "1.1.3"
    private const val TurbineVersion = "0.7.0"
    private const val KaspressoVersion = "1.4.0"

    const val Junit = "junit:junit:$JunitVersion"
    const val Mockk = "io.mockk:mockk:$MockkVersion"
    const val Mockito = "org.mockito:mockito-core:$MockitoVersion"
    const val Robolectric = "org.robolectric:robolectric:$RobolectricVersion"
    const val Truth = "com.google.truth:truth:$TruthVersion"
    const val Turbine = "app.cash.turbine:turbine:$TurbineVersion"
    const val Kaspresso = "com.kaspersky.android-components:kaspresso:$KaspressoVersion"
    const val KaspressoAllure = "com.kaspersky.android-components:kaspresso-allure-support:$KaspressoVersion"
    const val KaspressoCompose = "com.kaspersky.android-components:kaspresso-compose-support:$KaspressoVersion"

    const val TestRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val BenchmarkRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
}