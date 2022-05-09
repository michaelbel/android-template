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
    ":features:ime",
    ":features:toast",
    ":features:location"
)
rootProject.name = "android-app-template"