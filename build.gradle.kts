plugins {
    id(org.michaelbel.template.ThirdParty.Detekt).version(org.michaelbel.template.ThirdParty.DetektVersion)
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

tasks.register("clean").configure {
    delete("build")
}

detekt {
    config = files("$rootDir/config/detekt/detekt.yml")
}