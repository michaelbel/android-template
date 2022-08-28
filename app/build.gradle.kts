@file:Suppress("UnstableApiUsage")

import java.io.FileInputStream
import java.util.Properties
import org.apache.commons.io.output.ByteArrayOutputStream
import org.michaelbel.template.ApplicationId
import org.michaelbel.template.BuildTools
import org.michaelbel.template.CompileSdk
import org.michaelbel.template.MinSdk
import org.michaelbel.template.TargetSdk
import org.michaelbel.template.VersionName
import org.michaelbel.template.dependencies.FirebaseAppDistribution
import org.michaelbel.template.dependencies.KotlinCompilerExtensionVersion
import org.michaelbel.template.dependencies.TestRunner
import org.michaelbel.template.dependencies.implementationComposeTestDependencies
import org.michaelbel.template.dependencies.implementationHiltDependencies
import org.michaelbel.template.dependencies.implementationJetpackTestDependencies
import org.michaelbel.template.dependencies.implementationLeakCanaryDependencies
import org.michaelbel.template.dependencies.implementationNavigationDependencies
import org.michaelbel.template.dependencies.implementationRxDependencies
import org.michaelbel.template.dependencies.implementationStrictModeCompatDependencies
import org.michaelbel.template.dependencies.implementationTestDependencies

plugins {
    // google-services before firebase
    // kotlin kapt before hilt and safeargs
    id("com.android.application")
    id("kotlin-parcelize")
    id("kotlinx-serialization")
    id("com.google.gms.google-services")
    id("com.google.firebase.appdistribution")
    id("com.google.firebase.crashlytics")
    id("io.gitlab.arturbosch.detekt")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

val gitVersion: Int by lazy {
    val stdout = ByteArrayOutputStream()
    rootProject.exec {
        commandLine("git", "rev-list", "--count", "HEAD")
        standardOutput = stdout
    }
    stdout.toString().trim().toInt()
}

android {
    compileSdk = CompileSdk
    buildToolsVersion = BuildTools

    defaultConfig {
        applicationId = ApplicationId
        minSdk = MinSdk
        targetSdk = TargetSdk
        versionCode = gitVersion
        versionName = VersionName
        testInstrumentationRunner = TestRunner
        setProperty("archivesBaseName", "template-v-$versionName($versionCode)")
    }

    signingConfigs {
        val keystoreProperties = Properties()
        val keystorePropertiesFile: File = rootProject.file("config/keystore.properties")
        if (keystorePropertiesFile.exists()) {
            keystoreProperties.load(FileInputStream(keystorePropertiesFile))
        } else {
            keystoreProperties["keyAlias"] = System.getenv("KEYSTORE_KEY_ALIAS").orEmpty()
            keystoreProperties["keyPassword"] = System.getenv("KEYSTORE_KEY_PASSWORD").orEmpty()
            keystoreProperties["storePassword"] = System.getenv("KEYSTORE_STORE_PASSWORD").orEmpty()
            keystoreProperties["storeFile"] = System.getenv("KEYSTORE_FILE").orEmpty()
        }

        create("release") {
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
            storeFile = file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
        }
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            firebaseAppDistribution {
                appId = FirebaseAppDistribution.MobileSdkAppId
                artifactType = FirebaseAppDistribution.ArtifactType
                testers = FirebaseAppDistribution.Testers
                releaseNotes = FirebaseAppDistribution.ReleaseNotes
            }
        }
        debug {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = KotlinCompilerExtensionVersion
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }
}

tasks.register("prepareReleaseNotes") {
    doLast {
        exec {
            workingDir(rootDir)
            executable("./scripts/gitlog.sh")
        }
    }
}

afterEvaluate {
    tasks.findByName("assembleDebug")?.finalizedBy("prepareReleaseNotes")
    tasks.findByName("assembleRelease")?.finalizedBy("prepareReleaseNotes")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":features"))
    implementationHiltDependencies()
    implementationStrictModeCompatDependencies()
    implementationTestDependencies()
    implementationJetpackTestDependencies()
    implementationComposeTestDependencies()
    implementationRxDependencies()
    implementationLeakCanaryDependencies()
    implementationNavigationDependencies()
}