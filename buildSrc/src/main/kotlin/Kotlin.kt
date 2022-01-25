package org.michaelbel.template

/**
 * Kotlin
 *
 * https://github.com/JetBrains/kotlin/releases
 * https://github.com/Kotlin/kotlinx.coroutines/releases
 * https://github.com/Kotlin/kotlinx.serialization/releases
 */
object Kotlin {
    private const val Version = "1.6.0"
    private const val CoroutinesVersion = "1.6.0"
    private const val SerializationVersion = "1.3.2"

    const val CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$CoroutinesVersion"
    const val CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$CoroutinesVersion"
    const val CoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$CoroutinesVersion"
    const val Serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$SerializationVersion"

    object Options {
        private const val ExperimentalCoroutinesApi = "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
        private const val ObsoleteCoroutinesApi = "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi"
        private const val ExperimentalPagingApi = "-Xuse-experimental=androidx.paging.ExperimentalPagingApi"
        private const val ExperimentalComposeUiApi = "-Xuse-experimental=androidx.compose.ui.ExperimentalComposeUiApi"
        private const val ExperimentalMaterialApi = "-Xuse-experimental=androidx.compose.material.ExperimentalMaterialApi"
        private const val ExperimentalMaterial3Api = "-Xuse-experimental=androidx.compose.material3.ExperimentalMaterial3Api"
        private const val ExperimentalCoilApi = "-Xuse-experimental=coil.annotation.ExperimentalCoilApi"
        private const val ExperimentalSerializationApi = "-Xuse-experimental=kotlinx.serialization.ExperimentalSerializationApi"
        private const val FlowPreview = "-Xopt-in=kotlinx.coroutines.FlowPreview"

        val all: String
            get() = ExperimentalCoroutinesApi +
                    ObsoleteCoroutinesApi +
                    ExperimentalPagingApi +
                    ExperimentalComposeUiApi +
                    ExperimentalMaterialApi +
                    ExperimentalMaterial3Api +
                    ExperimentalCoilApi +
                    ExperimentalSerializationApi +
                    FlowPreview
    }
}