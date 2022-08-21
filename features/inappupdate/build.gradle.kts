@file:Suppress("UnstableApiUsage")

import org.michaelbel.template.CompileSdk
import org.michaelbel.template.dependencies.KotlinCompilerExtensionVersion
import org.michaelbel.template.dependencies.implementationHiltDependencies
import org.michaelbel.template.dependencies.implementationPlayCoreDependency

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
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
    implementationPlayCoreDependency()
}