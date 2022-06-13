@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * ExoPlayer
 *
 * @see <a href="https://github.com/google/ExoPlayer">ExoPlayer</a>
 */

private const val ExoPlayerVersion = "2.17.1"

private const val ExoPlayer = "com.google.android.exoplayer:exoplayer:$ExoPlayerVersion"
private const val ExoPlayerCore = "com.google.android.exoplayer:exoplayer-core:$ExoPlayerVersion"
private const val ExoPlayerDash = "com.google.android.exoplayer:exoplayer-dash:$ExoPlayerVersion"
private const val ExoPlayerUi = "com.google.android.exoplayer:exoplayer-ui:$ExoPlayerVersion"

fun DependencyHandler.implementationExoPlayerDependencies() {
    implementation(ExoPlayer)
}