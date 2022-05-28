@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.debugImplementation

/**
 * LeakCanary
 *
 * @see <a href="https://github.com/square/leakcanary">LeakCanary</a>
 */

private const val LeakCanaryVersion = "2.9.1"

private const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:$LeakCanaryVersion"

fun DependencyHandler.implementationLeakCanaryDependencies() {
    debugImplementation(LeakCanary)
}