plugins {
    id("io.gitlab.arturbosch.detekt").version("1.19.0")
    id("org.jlleitschuh.gradle.ktlint").version("10.2.1")
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(org.michaelbel.template.App.GradlePlugin)
        classpath(org.michaelbel.template.Kotlin.KotlinPlugin)
        classpath(org.michaelbel.template.Kotlin.KotlinSerializationPlugin)
        classpath(org.michaelbel.template.GooglePlayServices.GoogleServicesPlugin)
        classpath(org.michaelbel.template.ThirdParty.HiltPlugin)
        classpath(org.michaelbel.template.Firebase.FirebaseCrashlyticsPlugin)
        classpath(org.michaelbel.template.Firebase.FirebaseAppDistributionPlugin)
        classpath(org.michaelbel.template.Jetpack.NavigationSafeArgsPlugin)
        classpath(org.michaelbel.template.ThirdParty.SpotlessPlugin)
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.2.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://androidx.dev/snapshots/builds/7850066/artifacts/repository")
    }
}

subprojects {
    apply {
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jlleitschuh.gradle.ktlint")
    }

    detekt {
        config = rootProject.files("config/detekt/detekt.yml")
    }

    ktlint {
        debug.set(false)
        version.set("10.2.1")
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

tasks.register("clean").configure {
    delete("build")
}