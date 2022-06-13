@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api

/**
 * Fragment
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/fragment">Fragment</a>
 */

private const val FragmentVersion = "1.4.1"

private const val Fragment = "androidx.fragment:fragment-ktx:$FragmentVersion"
private const val FragmentTesting = "androidx.fragment:fragment-testing:$FragmentVersion"

fun DependencyHandler.apiFragmentDependencies() {
    api(Fragment)
}