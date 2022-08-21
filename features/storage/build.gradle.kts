@file:Suppress("UnstableApiUsage")

import org.michaelbel.template.CompileSdk
import org.michaelbel.template.dependencies.KotlinCompilerExtensionVersion
import org.michaelbel.template.dependencies.implementationHiltDependencies
import org.michaelbel.template.dependencies.implementationNavigationDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
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
    implementationNavigationDependencies()
}