@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * Browser
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/browser">Browser</a>
 */

private const val BrowserVersion = "1.4.0"

private const val Browser = "androidx.browser:browser:$BrowserVersion"

fun DependencyHandler.implementationBrowserDependencies() {
    implementation(Browser)
}

fun DependencyHandler.apiBrowserDependencies() {
    api(Browser)
}