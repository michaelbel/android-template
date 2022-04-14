@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * ViewBindingPropertyDelegate
 *
 * @see <a href="https://github.com/androidbroadcast/ViewBindingPropertyDelegate">ViewBindingPropertyDelegate</a>
 */

private const val ViewBindingPropertyDelegateVersion = "1.5.6"

private const val ViewBindingPropertyDelegate = "com.github.kirich1409:viewbindingpropertydelegate:$ViewBindingPropertyDelegateVersion"

fun DependencyHandler.implementationViewBindingPropertyDelegateDependencies() {
    implementation(ViewBindingPropertyDelegate)
}

fun DependencyHandler.apiViewBindingPropertyDelegateDependencies() {
    api(ViewBindingPropertyDelegate)
}