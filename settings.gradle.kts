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

    ":feature:auth",
    ":feature:clipboard",
    ":feature:constraintlayout",
    ":feature:downloadfile",
    ":feature:fonts",
    ":feature:getcontent",
    ":feature:ime",
    ":feature:inappreview",
    ":feature:intents",
    ":feature:location",
    ":feature:phonecalls",
    ":feature:receiver",
    ":feature:remoteconfig",
    ":feature:service",
    ":feature:storage",
    ":feature:toast"
)

rootProject.name = "android-app-template"