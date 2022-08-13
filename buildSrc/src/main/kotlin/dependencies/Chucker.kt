@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.debugApi
import org.michaelbel.template.extensions.debugImplementation
import org.michaelbel.template.extensions.releaseApi
import org.michaelbel.template.extensions.releaseImplementation

/**
 * Chucker
 *
 * @see <a href="https://github.com/ChuckerTeam/chucker">Chucker</a>
 */

private const val ChuckerVersion = "3.5.2"

private const val Chucker = "com.github.chuckerteam.chucker:library:$ChuckerVersion"
private const val ChuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:$ChuckerVersion"

fun DependencyHandler.implementationChuckerDependencies() {
    debugImplementation(Chucker)
    releaseImplementation(ChuckerNoOp)
}

fun DependencyHandler.apiChuckerDependencies() {
    debugApi(Chucker)
    releaseApi(ChuckerNoOp)
}