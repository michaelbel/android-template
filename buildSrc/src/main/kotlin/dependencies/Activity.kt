@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api

/**
 * Activity
 *
 * Updated September 21, 2022
 * @see <a href="https://d.android.com/jetpack/androidx/releases/activity">Activity</a>
 */

private const val ActivityVersion = "1.6.0"

private const val Activity = "androidx.activity:activity-ktx:$ActivityVersion"
private const val ActivityCompose = "androidx.activity:activity-compose:$ActivityVersion"

fun DependencyHandler.apiActivityDependencies() {
    api(Activity)
    api(ActivityCompose)
}