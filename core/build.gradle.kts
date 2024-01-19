@file:Suppress("UnstableApiUsage")

import org.michaelbel.template.dependencies.KotlinCompilerExtensionVersion
import org.michaelbel.template.dependencies.TestRunner
import org.michaelbel.template.dependencies.apiAccompanistDependencies
import org.michaelbel.template.dependencies.apiAppcompatDependencies
import org.michaelbel.template.dependencies.apiBrowserDependencies
import org.michaelbel.template.dependencies.apiChuckerDependencies
import org.michaelbel.template.dependencies.apiCoilDependencies
import org.michaelbel.template.dependencies.apiComposeDependencies
import org.michaelbel.template.dependencies.apiConstraintLayoutDependencies
import org.michaelbel.template.dependencies.apiCoreDependencies
import org.michaelbel.template.dependencies.apiDataStoreDependencies
import org.michaelbel.template.dependencies.apiFirebaseDependencies
import org.michaelbel.template.dependencies.apiGooglePlayServicesDependencies
import org.michaelbel.template.dependencies.apiJetpackTestDependencies
import org.michaelbel.template.dependencies.apiKotlinDependencies
import org.michaelbel.template.dependencies.apiLifecycleDependencies
import org.michaelbel.template.dependencies.apiMaterialDependencies
import org.michaelbel.template.dependencies.apiNavigationDependencies
import org.michaelbel.template.dependencies.apiPagingDependencies
import org.michaelbel.template.dependencies.apiRecyclerViewDependencies
import org.michaelbel.template.dependencies.apiRetrofitDependencies
import org.michaelbel.template.dependencies.apiRoomDependencies
import org.michaelbel.template.dependencies.apiStartupDependencies
import org.michaelbel.template.dependencies.apiTestDependencies
import org.michaelbel.template.dependencies.apiTimberDependencies
import org.michaelbel.template.dependencies.apiViewBindingPropertyDelegateDependencies
import org.michaelbel.template.dependencies.apiViewPager2Dependencies
import org.michaelbel.template.dependencies.apiWindowDependencies
import org.michaelbel.template.dependencies.implementationHiltDependencies

plugins {
    id("com.android.library")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
    kotlin("android")
    kotlin("kapt")
    id("com.google.devtools.ksp") version "1.9.22-1.0.17"
}

android {
    namespace = "org.michaelbel.core"

    defaultConfig {
        compileSdk = libs.versions.compile.sdk.get().toInt()
        minSdk = libs.versions.min.sdk.get().toInt()
        testInstrumentationRunner = TestRunner
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = KotlinCompilerExtensionVersion
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    implementationHiltDependencies()
    apiKotlinDependencies()
    apiWindowDependencies()
    apiDataStoreDependencies()
    apiComposeDependencies()
    apiLifecycleDependencies()
    apiPagingDependencies()
    apiRoomDependencies()
    apiGooglePlayServicesDependencies()
    apiMaterialDependencies()
    apiAccompanistDependencies()
    apiFirebaseDependencies()
    apiRetrofitDependencies()
    apiCoilDependencies()
    apiTimberDependencies()
    apiChuckerDependencies()
    apiTestDependencies()
    apiViewBindingPropertyDelegateDependencies()
    apiStartupDependencies()
    apiNavigationDependencies()
    apiAppcompatDependencies()
    apiBrowserDependencies()
    apiConstraintLayoutDependencies()
    apiCoreDependencies()
    apiRecyclerViewDependencies()
    apiJetpackTestDependencies()
    apiViewPager2Dependencies()
}