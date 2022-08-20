@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * Okio
 *
 * @see <a href="https://github.com/square/okio">Okio</a>
 */

private const val OkioVersion = "3.2.0"

private const val Okio = "com.squareup.okio:okio:$OkioVersion"

fun DependencyHandler.implementationOkioDependencies() {
    implementation(Okio)
}