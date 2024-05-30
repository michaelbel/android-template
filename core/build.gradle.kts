@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "org.michaelbel.template.core"

    defaultConfig {
        compileSdk = libs.versions.compile.sdk.get().toInt()
        minSdk = libs.versions.min.sdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get().toInt())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get().toInt())
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    api(libs.androidx.activity.compose)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui)
    api(libs.androidx.constraintlayout.compose)
    api(libs.androidx.core.splashscreen)
    api(libs.androidx.fragment.compose)
    api(libs.androidx.lifecycle.runtime.compose)
    api(libs.androidx.paging.compose)
    api(libs.androidx.navigation.compose)
    api(libs.androidx.navigation.fragment.ktx)
    api(libs.google.material)
    api(libs.viewbindingpropertydelegate)
}