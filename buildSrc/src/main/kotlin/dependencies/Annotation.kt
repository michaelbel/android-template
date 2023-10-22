@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Annotation
 *
 * Updated September 21, 2022
 * @see <a href="https://d.android.com/jetpack/androidx/releases/annotation">Annotation</a>
 */

private const val AnnotationVersion = "1.5.0"
private const val AnnotationExperimentalVersion = "1.3.0"

private const val Annotation = "androidx.annotation:annotation:$AnnotationVersion"
private const val AnnotationExperimental = "androidx.annotation:annotation-experimental:$AnnotationExperimentalVersion"

fun DependencyHandler.implementationAnnotationDependencies() {
    implementation(Annotation)
    implementation(AnnotationExperimental)
}