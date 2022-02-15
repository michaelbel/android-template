plugins {
    id("io.gitlab.arturbosch.detekt").version("1.19.0")
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1" apply false
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
}

tasks.register("clean").configure {
    delete("build")
}