@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation
import org.michaelbel.template.extensions.testImplementation

/**
 * Koin
 *
 * @see <a href="https://github.com/InsertKoinIO/koin">Koin</a>
 */

private const val KoinVersion = "3.2.0"

private const val KoinAndroid = "io.insert-koin:koin-android:$KoinVersion"
private const val KoinTest = "io.insert-koin:koin-test:$KoinVersion"
private const val KoinTestJunit = "io.insert-koin:koin-test-junit4:$KoinVersion"

fun DependencyHandler.implementationKoinDependencies() {
    implementation(KoinAndroid)
    testImplementation(KoinTest)
    testImplementation(KoinTestJunit)
}