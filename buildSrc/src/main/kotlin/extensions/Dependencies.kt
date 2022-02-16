package org.michaelbel.template.extensions

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.Jetpack
import org.michaelbel.template.Testing

/**
 * Adds all the tests dependencies to android specific configuration.
 */
fun DependencyHandler.addTestsDependencies() {
    testImplementation(Testing.Junit)
    androidTestImplementation(Jetpack.TestCore)
    androidTestImplementation(Jetpack.TestExtJunit)
    androidTestImplementation(Jetpack.TestEspressoCore)
}