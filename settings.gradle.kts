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
    ":features:constraintlayout",
    ":features:fonts",
    ":features:ime",
    ":features:intents",
    ":features:location",
    ":features:storage",
    ":features:toast"
)
rootProject.name = "android-app-template"