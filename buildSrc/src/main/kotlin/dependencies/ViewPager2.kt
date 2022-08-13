@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * ViewPager2
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/viewpager2">ViewPager2</a>
 */

private const val ViewPager2Version = "1.0.0"

private const val ViewPager2 = "androidx.viewpager2:viewpager2:$ViewPager2Version"

fun DependencyHandler.implementationViewPager2Dependencies() {
    implementation(ViewPager2)
}

fun DependencyHandler.apiViewPager2Dependencies() {
    api(ViewPager2)
}