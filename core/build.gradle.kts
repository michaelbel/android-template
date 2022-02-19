import org.michaelbel.template.App
import org.michaelbel.template.Testing
import org.michaelbel.template.dependencies.apiAccompanistDependencies
import org.michaelbel.template.dependencies.apiChuckerDependencies
import org.michaelbel.template.dependencies.apiCoilDependencies
import org.michaelbel.template.dependencies.apiRetrofitDependencies
import org.michaelbel.template.dependencies.apiTimberDependencies
import org.michaelbel.template.extensions.apiFirebaseDependencies
import org.michaelbel.template.extensions.apiGoogleDependencies
import org.michaelbel.template.extensions.apiJetpackDependencies
import org.michaelbel.template.dependencies.apiKotlinDependencies
import org.michaelbel.template.extensions.apiTestDependencies
import org.michaelbel.template.extensions.implementationHiltDependencies

plugins {
    id("com.android.library")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = App.CompileSdk
    buildToolsVersion = App.BuildTools

    defaultConfig {
        minSdk = App.MinSdk
        targetSdk = App.TargetSdk
        testInstrumentationRunner = Testing.TestRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    apiKotlinDependencies()
    apiJetpackDependencies()
    apiGoogleDependencies()
    apiAccompanistDependencies()
    apiFirebaseDependencies()
    apiRetrofitDependencies()
    apiCoilDependencies()
    apiTimberDependencies()
    implementationHiltDependencies()
    apiChuckerDependencies()
    apiTestDependencies()
}