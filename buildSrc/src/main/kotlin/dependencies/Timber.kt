@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * Timber
 *
 * @see <a href="https://github.com/JakeWharton/timber/releases">Timber</a>
 */

private const val TimberVersion = "5.0.1"

private const val Timber = "com.jakewharton.timber:timber:$TimberVersion"

fun DependencyHandler.implementationTimberDependencies() {
    implementation(Timber)
}

fun DependencyHandler.apiTimberDependencies() {
    api(Timber)
}