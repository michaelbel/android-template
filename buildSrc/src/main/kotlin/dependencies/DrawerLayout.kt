@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * DrawerLayout
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/drawerlayout">DrawerLayout</a>
 */

private const val DrawerLayoutVersion = "1.1.1"

private const val DrawerLayout = "androidx.drawerlayout:drawerlayout:$DrawerLayoutVersion"

fun DependencyHandler.implementationDrawerLayoutDependencies() {
    implementation(DrawerLayout)
}