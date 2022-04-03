import org.michaelbel.template.CompileSdk
import org.michaelbel.template.MinSdk
import org.michaelbel.template.TargetSdk

plugins {
    id("com.android.library")
}

android {
    compileSdk = CompileSdk

    defaultConfig {
        minSdk = MinSdk
        targetSdk = TargetSdk
    }
}

dependencies {
    api(project(":features:ime"))
    api(project(":features:toast"))
}