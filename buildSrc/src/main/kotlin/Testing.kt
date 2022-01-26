package org.michaelbel.template

/**
 * Testing
 */
object Testing {
    private const val JunitVersion = "4.13.2"
    private const val MockkVersion = "1.12.2"
    private const val MockitoVersion = "4.2.0"
    private const val RobolectricVersion = "4.7.3"
    private const val TruthVersion = "1.1.3"

    const val Junit = "junit:junit:$JunitVersion"
    const val Mockk = "io.mockk:mockk:$MockkVersion"
    const val Mockito = "org.mockito:mockito-core:$MockitoVersion"
    const val Robolectric = "org.robolectric:robolectric:$RobolectricVersion"
    const val Truth = "com.google.truth:truth:$TruthVersion"

    const val TestRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val BenchmarkRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
}