@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Android Notification DSL
 *
 * @see <a href="https://github.com/androidbroadcast/Android-Notification-DSL">Android Notification DSL</a>
 */

private const val NotificationDslVersion = "0.2.1"

private const val NotificationDslCore = "com.github.kirich1409:android-notification-dsl-core:$NotificationDslVersion"
private const val NotificationDslExtensions = "com.github.kirich1409:android-notification-dsl-extensions:$NotificationDslVersion"
private const val NotificationDslMedia = "com.github.kirich1409:android-notification-dsl-media:$NotificationDslVersion"

fun DependencyHandler.implementationNotificationDslDependencies() {
    implementation(NotificationDslCore)
    implementation(NotificationDslExtensions)
    implementation(NotificationDslMedia)
}