@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * DragAndDrop
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/draganddrop">DragAndDrop</a>
 */

private const val DragAndDropVersion = "1.0.0"

private const val DragAndDrop = "androidx.draganddrop:draganddrop:$DragAndDropVersion"

fun DependencyHandler.implementationDragAndDropDependencies() {
    implementation(DragAndDrop)
}