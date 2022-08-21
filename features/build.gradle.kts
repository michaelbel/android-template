import org.michaelbel.template.CompileSdk

plugins {
    id("com.android.library")
}

android {
    compileSdk = CompileSdk
}

dependencies {
    api(project(":features:ads"))
    api(project(":features:auth"))
    api(project(":features:clipboard"))
    api(project(":features:constraintlayout"))
    api(project(":features:downloadfile"))
    api(project(":features:fonts"))
    api(project(":features:getcontent"))
    api(project(":features:ime"))
    api(project(":features:inappreview"))
    api(project(":features:inappupdate"))
    api(project(":features:intents"))
    api(project(":features:location"))
    api(project(":features:phonecalls"))
    api(project(":features:receiver"))
    api(project(":features:remoteconfig"))
    api(project(":features:service"))
    api(project(":features:storage"))
    api(project(":features:toast"))
}