@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Facebook
 *
 * @see <a href="https://github.com/facebook/facebook-android-sdk">Facebook</a>
 */

private const val FacebookLoginVersion = "12.3.0"

private const val FacebookLogin = "com.facebook.android:facebook-login:$FacebookLoginVersion"

fun DependencyHandler.implementationFacebookDependencies() {
    implementation(FacebookLogin)
}