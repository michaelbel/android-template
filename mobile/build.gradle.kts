import org.apache.commons.io.output.ByteArrayOutputStream
import java.io.FileInputStream
import java.nio.charset.Charset
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
}

private val gitCommitsCount: Int by lazy {
    when {
        System.getProperty("os.name").contains("Windows", ignoreCase = true) -> 1
        else -> {
            val stdout = ByteArrayOutputStream()
            exec {
                commandLine("git", "rev-list", "--count", "HEAD")
                standardOutput = stdout
            }
            stdout.toString(Charset.defaultCharset()).trim().toInt()
        }
    }
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

android {
    namespace = "org.michaelbel.template" // Replace with your own namespace
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "org.michaelbel.template" // Replace with your own applicationId
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = gitCommitsCount
        versionName = "1.0.0"
    }

    signingConfigs {
        val keystoreProperties = Properties()
        val keystorePropertiesFile: File = rootProject.file("config/keystore.properties")
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
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = if (signingConfigs.findByName("release") != null) signingConfigs.getByName("release") else null
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            applicationIdSuffix = ".debug"
        }
    }

    flavorDimensions += "version"

    productFlavors {
        create("free") {
            dimension = "version"
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
    archivesName.set("Mobile-Template-v${android.defaultConfig.versionName}(${android.defaultConfig.versionCode})") // Replace with your own app's name
}

dependencies {
    implementation(projects.core)
    api(libs.androidx.room.ktx)
    implementation(libs.androidx.compose.material3.windowsize)
    ksp(libs.androidx.room.compiler)
}

tasks.register("printVersionName") {
    doLast {
        println(android.defaultConfig.versionName)
    }
}

tasks.register("printVersionCode") {
    doLast {
        println(android.defaultConfig.versionCode.toString())
    }
}