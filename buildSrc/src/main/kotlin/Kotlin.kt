package org.michaelbel.template

/**
 * Kotlin
 *
 * https://github.com/JetBrains/kotlin/releases
 * https://github.com/Kotlin/kotlinx.coroutines/releases
 * https://github.com/Kotlin/kotlinx.serialization/releases
 * https://github.com/Kotlin/kotlinx-datetime/releases
 */
object Kotlin {
    private const val KotlinVersion = "1.6.10"
    private const val KotlinCoroutinesVersion = "1.6.0"
    private const val KotlinSerializationVersion = "1.3.2"
    private const val KotlinDatetimeVersion = "0.3.2"

    const val KotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KotlinVersion"
    const val KotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:$KotlinVersion"

    const val KotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$KotlinCoroutinesVersion"
    const val KotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$KotlinCoroutinesVersion"
    const val KotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$KotlinCoroutinesVersion"
    const val KotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$KotlinSerializationVersion"
    const val KotlinDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:$KotlinDatetimeVersion"

    object Options {
        const val OptExperimentalMaterial3Api = "-Xopt-in=androidx.compose.material3.ExperimentalMaterial3Api"
        const val OptExperimentalFoundationApi = "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi"
        const val OptExperimentalSerializationApi = "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi"
    }
}