import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
}

private val gitCommitsCount: Int by lazy {
    ProcessBuilder("git", "rev-list", "--count", "HEAD")
        .redirectErrorStream(true)
        .start().inputStream.bufferedReader().readLine().trim().toInt()
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

android {
    namespace = "org.michaelbel.template" // fixme Replace with your own namespace
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "org.michaelbel.template" // fixme Replace with your own applicationId
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = gitCommitsCount
        versionName = "1.0.0"
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "template"
            keyPassword = "password"
            storeFile = rootProject.file(".github/debug-key.jks")
            storePassword = "password"
        }

        val keystoreProperties = Properties()
        val keystorePropertiesFile: File = rootProject.file(".github/keystore.properties")
        if (keystorePropertiesFile.exists()) {
            keystoreProperties.load(FileInputStream(keystorePropertiesFile))

            create("release") {
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
                storeFile = file(keystoreProperties["storeFile"] as String)
                storePassword = keystoreProperties["storePassword"] as String
            }
        } else {
            val keystoreAlias = System.getenv("KEYSTORE_KEY_ALIAS").orEmpty()
            val keystorePassword = System.getenv("KEYSTORE_KEY_PASSWORD").orEmpty()
            val keystoreStorePassword = System.getenv("KEYSTORE_STORE_PASSWORD").orEmpty()
            val keystoreFile = System.getenv("KEYSTORE_FILE").orEmpty()
            if (keystoreAlias.isNotEmpty()) {
                keystoreProperties["keyAlias"] = keystoreAlias
                keystoreProperties["keyPassword"] = keystorePassword
                keystoreProperties["storePassword"] = keystoreStorePassword
                keystoreProperties["storeFile"] = keystoreFile

                create("release") {
                    keyAlias = keystoreProperties["keyAlias"] as String
                    keyPassword = keystoreProperties["keyPassword"] as String
                    storeFile = file(keystoreProperties["storeFile"] as String)
                    storePassword = keystoreProperties["storePassword"] as String
                }
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = if (signingConfigs.findByName("release") != null) signingConfigs.getByName("release") else null
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            signingConfig = signingConfigs.getByName("debug")
            applicationIdSuffix = ".debug"
        }
    }

    flavorDimensions += "version"

    productFlavors {
        create("free") {
            dimension = "version"
            isDefault = true
        }
        create("paid") {
            dimension = "version"
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
}

base {
    archivesName.set("Mobile-Template-v${android.defaultConfig.versionName}(${android.defaultConfig.versionCode})") // fixme Replace with your own app's name
}

dependencies {
    implementation(projects.shared)
    implementation(libs.androidx.compose.material3.windowsize)
}

tasks.register("printVersion") {
    description = "Prints the current versionName and versionCode to stdout."
    doLast {
        println("VERSION_NAME=${android.defaultConfig.versionName}")
        println("VERSION_CODE=${android.defaultConfig.versionCode}")
    }
}
