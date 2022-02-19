@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * VK
 *
 * @see <a href="https://github.com/vkcom/vk-android-sdk">VK</a>
 */

private const val VkVersion = "3.5.0"

private const val Vk = "com.vk:android-sdk-core:$VkVersion"

fun DependencyHandler.implementationVkDependencies() {
    implementation(Vk)
}