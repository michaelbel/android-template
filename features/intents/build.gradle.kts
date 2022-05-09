import org.michaelbel.template.CompileSdk
import org.michaelbel.template.MinSdk
import org.michaelbel.template.TargetSdk
import org.michaelbel.template.dependencies.KotlinCompilerExtensionVersion

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = CompileSdk

    defaultConfig {
        minSdk = MinSdk
        targetSdk = TargetSdk
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = KotlinCompilerExtensionVersion
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":core"))
}