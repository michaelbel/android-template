@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestImplementation
import org.michaelbel.template.extensions.implementation

/**
 * WorkManager
 *
 * @see <a href="https://d.android.com/jetpack/androidx/releases/work">WorkManager</a>
 */

private const val WorkVersion = "2.7.1"

private const val WorkRuntime = "androidx.work:work-runtime-ktx:$WorkVersion"
private const val WorkGcm = "androidx.work:work-gcm:$WorkVersion"
private const val WorkMultiprocess = "androidx.work:work-multiprocess:$WorkVersion"
private const val WorkTesting = "androidx.work:work-testing:$WorkVersion"

fun DependencyHandler.implementationWorkDependencies() {
    implementation(WorkRuntime)
    androidTestImplementation(WorkTesting)
}