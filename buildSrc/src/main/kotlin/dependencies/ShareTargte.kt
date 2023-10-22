@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * ShareTarget
 *
 * @see <a href="https://d.android.com/jetpack/androidx/releases/sharetarget">ShareTarget</a>
 */

private const val ShareTargetVersion = "1.2.0"

private const val ShareTarget = "androidx.sharetarget:sharetarget:$ShareTargetVersion"

fun DependencyHandler.implementationShareTargetDependencies() {
    implementation(ShareTarget)
}