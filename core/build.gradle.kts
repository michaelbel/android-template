
import org.michaelbel.template.App
import org.michaelbel.template.Dependencies
import org.michaelbel.template.Firebase
import org.michaelbel.template.KotlinOptions

plugins {
    id("com.android.library")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
    kotlin("android")
    kotlin("kapt")
}

apply("$rootDir/spotless.gradle")

android {
    compileSdk = App.CompileSdk
    buildToolsVersion = App.BuildTools

    defaultConfig {
        minSdk = App.MinSdk
        targetSdk = App.TargetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + KotlinOptions.all
    }

    sourceSets.getByName("main") {
        java.srcDir("src/main/kotlin")
    }
}

dependencies {
    api(Dependencies.KotlinCoroutinesCore)
    api(Dependencies.KotlinCoroutinesAndroid)
    api(Dependencies.KotlinSerialization)

    api(Dependencies.Activity)
    api(Dependencies.AppCompat)
    api(Dependencies.Core)
    api(Dependencies.CoreSplashScreen)
    api(Dependencies.Fragment)
    api(Dependencies.LifecycleRuntime)
    api(Dependencies.LifecycleViewmodel)
    api(Dependencies.PagingRuntime)
    api(Dependencies.PagingCompose)
    api(Dependencies.RoomPaging)

    api(Dependencies.Material)
    api(Dependencies.HiltAndroid)
    kapt(Dependencies.HiltCompiler)
    api(Firebase.Abt)
    api(Firebase.Analytics)
    api(Firebase.Common)
    api(Firebase.Config)
    api(Firebase.Core)
    api(Firebase.Crashlytics)
    api(Dependencies.PlayCore)

    api(Dependencies.Retrofit)
    api(Dependencies.RetrofitConverterGson)
    api(Dependencies.RetrofitConverterMoshi)
    api(Dependencies.RetrofitConverterSerialization)
    api(Dependencies.LoggingInterceptor)
    api(Dependencies.Timber)
    api(Dependencies.GanderPersistence)
    api(Dependencies.GanderImdb)

    testApi(Dependencies.Junit)
    testApi(Dependencies.KotlinCoroutinesTest)
    androidTestApi(Dependencies.KotlinCoroutinesTest)
    androidTestApi(Dependencies.TestJunit)
    androidTestApi(Dependencies.TestEspresso)
}