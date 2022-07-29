@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestImplementation
import org.michaelbel.template.extensions.implementation

/**
 * Arch Core
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/arch-core">Arch Core</a>
 */

private const val ArchCoreVersion = "2.1.0"

private const val ArchCoreCommon = "androidx.arch.core:core-common:$ArchCoreVersion"
private const val ArchCoreRuntime = "androidx.arch.core:core-runtime:$ArchCoreVersion"
private const val ArchCoreTesting = "androidx.arch.core:core-testing:$ArchCoreVersion"

fun DependencyHandler.implementationArchCoreDependencies() {
    implementation(ArchCoreCommon)
    implementation(ArchCoreRuntime)
    androidTestImplementation(ArchCoreTesting)
}