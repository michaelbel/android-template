@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Glance
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/glance">Glance</a>
 */

private const val GlanceVersion = "1.0.0-alpha03"

private const val Glance = "androidx.glance:glance:$GlanceVersion"
private const val GlanceAppWidget = "androidx.glance:glance-appwidget:$GlanceVersion"

fun DependencyHandler.implementationGlanceDependencies() {
    implementation(Glance)
    implementation(GlanceAppWidget)
}