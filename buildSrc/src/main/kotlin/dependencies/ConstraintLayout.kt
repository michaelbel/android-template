@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * ConstraintLayout
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/constraintlayout">ConstraintLayout</a>
 */

private const val ConstraintLayoutVersion = "2.1.4"
private const val ConstraintLayoutComposeVersion = "1.0.1"

private const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:$ConstraintLayoutVersion"
private const val ConstraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:$ConstraintLayoutComposeVersion"

fun DependencyHandler.implementationConstraintLayoutDependencies() {
    implementation(ConstraintLayout)
    implementation(ConstraintLayoutCompose)
}

fun DependencyHandler.apiConstraintLayoutDependencies() {
    api(ConstraintLayout)
    api(ConstraintLayoutCompose)
}