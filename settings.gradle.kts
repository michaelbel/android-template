@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
include(
    ":mobile",
    ":wear",
    ":tv",
    ":auto",
    ":xr",
    ":core"
)
rootProject.name = "android-template" // todo Replace with your own app’s name

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")