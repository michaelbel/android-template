@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * Collection
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/collection">Collection</a>
 */

private const val CollectionVersion = "1.2.0"

private const val Collection = "androidx.collection:collection-ktx:$CollectionVersion"

fun DependencyHandler.implementationCollectionDependencies() {
    implementation(Collection)
}