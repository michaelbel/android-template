@file:Suppress("UnstableApiUsage")

import org.michaelbel.template.CompileSdk
import org.michaelbel.template.dependencies.KotlinCompilerExtensionVersion
import org.michaelbel.template.dependencies.implementationHiltDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "org.michaelbel.template.constraintlayout"
    compileSdk = CompileSdk

    composeOptions {
        kotlinCompilerExtensionVersion = KotlinCompilerExtensionVersion
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementationHiltDependencies()
}