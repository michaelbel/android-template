import Build_gradle.Ktlint
import Build_gradle.Spotless

private typealias Ktlint = org.jlleitschuh.gradle.ktlint.KtlintExtension
private typealias Spotless = com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    id(org.michaelbel.template.dependencies.Ktlint) version org.michaelbel.template.dependencies.KtlintVersion apply false
    id(org.michaelbel.template.dependencies.Detekt) version org.michaelbel.template.dependencies.DetektVersion apply true
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

subprojects {
    apply {
        plugin(org.michaelbel.template.dependencies.Ktlint)
        plugin(org.michaelbel.template.dependencies.Detekt)
        plugin(org.michaelbel.template.dependencies.Spotless)
    }

    configure<Ktlint> {
        debug.set(true)
        verbose.set(true)
        android.set(true)
        outputToConsole.set(true)
        ignoreFailures.set(true)
        enableExperimentalRules.set(false)
        disabledRules.set(setOf("final-newline", "comment-spacing"))
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }

    detekt {
        config = rootProject.files("config/detekt/detekt.yml")
    }

    configure<Spotless> {
        java {
            target("**/*.java")
            googleJavaFormat().aosp()
            removeUnusedImports()
            indentWithSpaces()
            trimTrailingWhitespace()
        }
        kotlin {
            target("**/*.kt")
            indentWithSpaces()
            trimTrailingWhitespace()
        }
        format("misc") {
            target("**/*.gradle", "**/*.md", "**/.gitignore")
            indentWithSpaces()
            trimTrailingWhitespace()
        }
        kotlinGradle {
            target("*.gradle.kts")
        }
        format("xml") {
            target("**/*.xml")
            indentWithSpaces()
            trimTrailingWhitespace()
        }
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).configureEach {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalMaterial3Api
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalAnimationApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalCoroutinesApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalSerializationApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalComposeUiApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalFoundationApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalMaterialApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptContextReceivers
        }
    }
}

tasks.register("clean").configure {
    delete("build")
}