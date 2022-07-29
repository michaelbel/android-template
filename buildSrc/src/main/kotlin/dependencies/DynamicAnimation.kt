@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * DynamicAnimation
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/dynamicanimation">DynamicAnimation</a>
 */

private const val DynamicAnimationVersion = "1.1.0-alpha03"

private const val DynamicAnimation = "androidx.dynamicanimation:dynamicanimation-ktx:$DynamicAnimationVersion"

fun DependencyHandler.implementationDynamicAnimationDependencies() {
    implementation(DynamicAnimation)
}