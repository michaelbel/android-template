plugins {
    id(org.michaelbel.template.plugins.Plugins.Ktlint) version org.michaelbel.template.plugins.Plugins.KtlintVersion apply false
    id(org.michaelbel.template.plugins.Plugins.Detekt) version org.michaelbel.template.plugins.Plugins.DetektVersion apply true
    id(org.michaelbel.template.plugins.Plugins.Spotless) version org.michaelbel.template.plugins.Plugins.SpotlessVersion apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath(org.michaelbel.template.App.GradlePlugin)
        classpath(org.michaelbel.template.dependencies.KotlinPlugin)
        classpath(org.michaelbel.template.dependencies.KotlinSerializationPlugin)
        classpath(org.michaelbel.template.Google.GoogleServicesPlugin)
        classpath(org.michaelbel.template.Google.HiltPlugin)
        classpath(org.michaelbel.template.Firebase.FirebaseCrashlyticsPlugin)
        classpath(org.michaelbel.template.Firebase.FirebaseAppDistributionPlugin)
        classpath(org.michaelbel.template.Jetpack.NavigationSafeArgsPlugin)
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.2.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://androidx.dev/snapshots/builds/7850066/artifacts/repository")
        maven("https://plugins.gradle.org/m2/")
    }
}

subprojects {
    apply {
        plugin(org.michaelbel.template.plugins.Plugins.Ktlint)
        plugin(org.michaelbel.template.plugins.Plugins.Detekt)
        plugin(org.michaelbel.template.plugins.Plugins.Spotless)
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
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

    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
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
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.Options.OptExperimentalMaterial3Api
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.Options.OptExperimentalFoundationApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalSerializationApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.Options.OptExperimentalPagingApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.Options.OptExperimentalComposeUiApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.Options.OptExperimentalMaterialApi
            freeCompilerArgs = freeCompilerArgs + org.michaelbel.template.dependencies.OptExperimentalCoilApi
        }
    }
}

tasks.register("clean").configure {
    delete("build")
}