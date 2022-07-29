@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * VectorDrawable
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/vectordrawable">VectorDrawable</a>
 */

private const val VectorDrawableVersion = "1.1.0"
private const val VectorDrawableSeekableVersion = "1.0.0-beta01"

private const val VectorDrawable = "androidx.vectordrawable:vectordrawable:$VectorDrawableVersion"
private const val VectorDrawableAnimated = "androidx.vectordrawable:vectordrawable-animated:$VectorDrawableVersion"
private const val VectorDrawableSeekable = "androidx.vectordrawable:vectordrawable-seekable:$VectorDrawableSeekableVersion"

fun DependencyHandler.implementationVectorDrawableDependencies() {
    implementation(VectorDrawable)
    implementation(VectorDrawableAnimated)
    implementation(VectorDrawableSeekable)
}