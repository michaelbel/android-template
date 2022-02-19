@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestApi
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.testApi

/**
 * Kotlin
 *
 * @see <a href="https://github.com/JetBrains/kotlin/releases">Kotlin</a>
 * @see <a href="https://github.com/Kotlin/kotlinx.coroutines/releases">Coroutines</a>
 * @see <a href="https://github.com/Kotlin/kotlinx.serialization/releases">Serialization</a>
 * @see <a href="https://github.com/Kotlin/kotlinx-datetime/releases">Datetime</a>
 */

private const val KotlinVersion = "1.6.10"
private const val KotlinCoroutinesVersion = "1.6.0"
private const val KotlinSerializationVersion = "1.3.2"
private const val KotlinDatetimeVersion = "0.3.2"

const val KotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KotlinVersion"
const val KotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:$KotlinVersion"

private const val KotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$KotlinCoroutinesVersion"
private const val KotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$KotlinCoroutinesVersion"
private const val KotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$KotlinCoroutinesVersion"
private const val KotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$KotlinSerializationVersion"
private const val KotlinDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:$KotlinDatetimeVersion"

const val OptExperimentalSerializationApi = "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi"
const val RequiresOptIn = "-Xopt-in=kotlin.RequiresOptIn"

fun DependencyHandler.apiKotlinDependencies() {
    api(KotlinCoroutinesCore)
    api(KotlinCoroutinesAndroid)
    api(KotlinSerialization)

    testApi(KotlinCoroutinesTest)

    androidTestApi(KotlinCoroutinesTest)
}