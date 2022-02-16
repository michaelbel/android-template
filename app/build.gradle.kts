
import java.io.FileInputStream
import java.util.Properties
import org.apache.commons.io.output.ByteArrayOutputStream
import org.michaelbel.template.App
import org.michaelbel.template.Kotlin
import org.michaelbel.template.Testing
import org.michaelbel.template.ThirdParty
import org.michaelbel.template.extensions.addTestsDependencies

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
    compileSdk = App.CompileSdk
    buildToolsVersion = App.BuildTools

    defaultConfig {
        applicationId = App.ApplicationId
        minSdk = App.MinSdk
        targetSdk = App.TargetSdk
        versionCode = gitVersion
        versionName = App.VersionName
        testInstrumentationRunner = Testing.TestRunner
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            firebaseAppDistribution {
                appId = "1:33042426453:android:f766db4a18b6b79e9102dc" // google-services.json mobilesdk_app_id
                artifactType = "APK"
                testers = "michaelbel24865@gmail.com"
                releaseNotes = "Release Build"
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

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalMaterial3Api
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalFoundationApi
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalSerializationApi
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalPagingApi
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalComposeUiApi
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalMaterialApi
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalCoilApi
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha02"
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }
}

dependencies {
    implementation(project(":core"))

    implementation(ThirdParty.HiltAndroid)
    kapt(ThirdParty.HiltCompiler)
    implementation(ThirdParty.VK)
    implementation(ThirdParty.FacebookLogin)
    implementation(ThirdParty.ViewBindingPropertyDelegate)
    implementation(ThirdParty.StrictMode)

    addTestsDependencies()
}