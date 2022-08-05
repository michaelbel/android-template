pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.namespace) {
                "com.android" -> {
                    useModule("com.android.tools.build:gradle:${requested.version}")
                }
            }
        }
    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

include(
    ":app",
    ":core",
    ":features",
    ":features:ads",
    ":features:auth",
    ":features:clipboard",
    ":features:constraintlayout",
    ":features:downloadfile",
    ":features:fonts",
    ":features:getcontent",
    ":features:ime",
    ":features:inappreview",
    ":features:inappupdate",
    ":features:intents",
    ":features:location",
    ":features:phonecalls",
    ":features:receiver",
    ":features:remoteconfig",
    ":features:service",
    ":features:storage",
    ":features:toast"
)
rootProject.name = "android-app-template"