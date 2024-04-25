private typealias Ktlint = org.jlleitschuh.gradle.ktlint.KtlintExtension
private typealias Spotless = com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    id(org.michaelbel.template.dependencies.Ktlint) version org.michaelbel.template.dependencies.KtlintVersion apply false
    id(org.michaelbel.template.dependencies.Spotless) version org.michaelbel.template.dependencies.SpotlessVersion apply false
    id("org.jetbrains.kotlin.jvm") version org.michaelbel.template.dependencies.KotlinVersion apply false
    id("com.android.library") version org.michaelbel.template.dependencies.GradleVersion apply false
    id("org.jetbrains.kotlin.android") version org.michaelbel.template.dependencies.KotlinVersion apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(org.michaelbel.template.dependencies.Gradle)
        classpath(org.michaelbel.template.dependencies.KotlinPlugin)
        classpath(org.michaelbel.template.dependencies.KotlinSerializationPlugin)
        classpath(org.michaelbel.template.dependencies.GoogleServicesPlugin)
        classpath(org.michaelbel.template.dependencies.HiltPlugin)
        classpath(org.michaelbel.template.dependencies.FirebaseCrashlyticsPlugin)
        classpath(org.michaelbel.template.dependencies.FirebaseAppDistributionPlugin)
        classpath(org.michaelbel.template.dependencies.NavigationSafeArgsPlugin)
        classpath(org.michaelbel.template.dependencies.KtlintGradle)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()

        maven("https://androidx.dev/snapshots/builds/7850066/artifacts/repository") // preview material
    }
}

tasks.register("clean").configure {
    delete("build")
}