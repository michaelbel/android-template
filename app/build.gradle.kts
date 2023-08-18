@file:Suppress("UnstableApiUsage")

import org.apache.commons.io.output.ByteArrayOutputStream
import org.michaelbel.template.dependencies.FirebaseAppDistribution
import org.michaelbel.template.dependencies.TestRunner
import org.michaelbel.template.dependencies.implementationComposeTestDependencies
import org.michaelbel.template.dependencies.implementationHiltDependencies
import org.michaelbel.template.dependencies.implementationJetpackTestDependencies
import org.michaelbel.template.dependencies.implementationLeakCanaryDependencies
import org.michaelbel.template.dependencies.implementationNavigationDependencies
import org.michaelbel.template.dependencies.implementationRxDependencies
import org.michaelbel.template.dependencies.implementationStrictModeCompatDependencies
import org.michaelbel.template.dependencies.implementationTestDependencies
import java.io.FileInputStream
import java.util.Properties

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
    namespace = "org.michaelbel.template"
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "org.michaelbel.template"
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = gitVersion
        versionName = "1.0.0"
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
                releaseNotesFile="$rootProject.rootDir/releaseNotes.txt"
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
        kotlinCompilerExtensionVersion = libs.versions.kotlin.compiler.extension.get()
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
    implementation(project(":feature:auth"))
    implementation(project(":feature:clipboard"))
    implementation(project(":feature:constraintlayout"))
    implementation(project(":feature:downloadfile"))
    implementation(project(":feature:fonts"))
    implementation(project(":feature:getcontent"))
    implementation(project(":feature:ime"))
    implementation(project(":feature:inappreview"))
    implementation(project(":feature:inappupdate"))
    implementation(project(":feature:intents"))
    implementation(project(":feature:location"))
    implementation(project(":feature:phonecalls"))
    implementation(project(":feature:receiver"))
    implementation(project(":feature:remoteconfig"))
    implementation(project(":feature:service"))
    implementation(project(":feature:storage"))
    implementation(project(":feature:toast"))
    implementationHiltDependencies()
    implementationStrictModeCompatDependencies()
    implementationTestDependencies()
    implementationJetpackTestDependencies()
    implementationComposeTestDependencies()
    implementationRxDependencies()
    implementationLeakCanaryDependencies()
    implementationNavigationDependencies()
}