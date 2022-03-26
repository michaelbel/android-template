import org.michaelbel.template.CompileSdk

plugins {
    id("com.android.library")
}

android {
    compileSdk = CompileSdk
}

dependencies {
    api(project(":features:ime"))
    api(project(":features:toast"))
}