plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    compilerOptions {
        jvmToolchain(libs.versions.jdk.get().toInt())
    }
}

android {
    namespace = "org.michaelbel.template.core" // Replace with your own namespace
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()
    }

    buildFeatures {
        resValues = true
        shaders = false
        aidl = false
        renderScript = false
        buildConfig = true
        compose = true
    }

    kotlinOptions {
        allWarningsAsErrors = false
    }
}

dependencies {
    api(libs.kotlinx.serialization.json)
    api(libs.google.material)
    api(libs.androidx.activity.compose)
    api(libs.androidx.appcompat)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.adaptive)
    api(libs.androidx.compose.material3.adaptive.layout)
    api(libs.androidx.compose.material3.adaptive.navigation)
    api(libs.androidx.compose.material3.adaptive.navigation.suite)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling)
    api(libs.androidx.core.ktx)
    api(libs.androidx.core.splashscreen)
    api(libs.androidx.datastore.preferences)
    api(libs.androidx.lifecycle.viewmodel.compose)
    api(libs.androidx.navigation.compose)
    api(libs.androidx.paging.compose)
    api(libs.androidx.window)
    api(libs.koin.androidx.compose)
    api(libs.ktor.client.okhttp)
    api(libs.ktor.serialization.kotlinx.json)
    api(libs.ktor.client.content.negotiation)
    api(libs.okhttp.logging.interceptor)
    api(libs.coil.compose)
    debugApi(libs.chucker.library)
    releaseApi(libs.chucker.library.no.op)
}