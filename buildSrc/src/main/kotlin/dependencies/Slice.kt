@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Slice
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/slice">Slice</a>
 */

private const val SliceVersion = "1.1.0-alpha02"

private const val SliceBuilders = "androidx.slice:slice-builders-ktx:$SliceVersion"
private const val SliceCore = "androidx.slice:slice-core:$SliceVersion"
private const val SliceView = "androidx.slice:slice-view:$SliceVersion"

fun DependencyHandler.implementationSliceDependencies() {
    implementation(SliceBuilders)
    implementation(SliceCore)
    implementation(SliceView)
}