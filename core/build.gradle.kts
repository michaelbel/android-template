
import org.michaelbel.template.Accompanist
import org.michaelbel.template.App
import org.michaelbel.template.Firebase
import org.michaelbel.template.GooglePlayServices
import org.michaelbel.template.Jetpack
import org.michaelbel.template.Kotlin
import org.michaelbel.template.Testing
import org.michaelbel.template.ThirdParty

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
        testInstrumentationRunner = Testing.TestRunner
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
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalMaterial3Api
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalFoundationApi
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.OptExperimentalSerializationApi
    }

    sourceSets.getByName("main") {
        java.srcDir("src/main/kotlin")
    }
}

dependencies {
    // Kotlin
    api(Kotlin.KotlinCoroutinesCore)
    api(Kotlin.KotlinCoroutinesAndroid)
    api(Kotlin.KotlinSerialization)
    testApi(Kotlin.KotlinCoroutinesTest)
    androidTestApi(Kotlin.KotlinCoroutinesTest)

    // Jetpack
    api(Jetpack.Activity)
    api(Jetpack.ActivityCompose)
    api(Jetpack.AppCompat)
    api(Jetpack.Browser)
    api(Jetpack.ComposeCompiler)
    api(Jetpack.ComposeFoundation)
    api(Jetpack.ComposeFoundationLayout)
    api(Jetpack.ComposeMaterialIconsCore)
    api(Jetpack.ComposeMaterialIconsExtended)
    api(Jetpack.ComposeMaterial3)
    api(Jetpack.ComposeMaterial3Samples)
    api(Jetpack.ComposeRuntime)
    api(Jetpack.ComposeRuntimeLivedata)
    api(Jetpack.ComposeUi)
    api(Jetpack.ComposeUiTooling)
    api(Jetpack.ComposeUiViewBinding)
    api(Jetpack.ConstraintLayoutCompose)
    api(Jetpack.Core)
    api(Jetpack.CoreSplashScreen)
    api(Jetpack.DataStoreCore)
    api(Jetpack.DataStorePreferences)
    api(Jetpack.DataStorePreferencesCore)
    api(Jetpack.Fragment)
    api(Jetpack.HiltNavigationCompose)
    api(Jetpack.HiltNavigationFragment)
    api(Jetpack.HiltWork)
    api(Jetpack.LifecycleCommon)
    api(Jetpack.LifecycleLivedata)
    api(Jetpack.LifecycleRuntime)
    api(Jetpack.LifecycleViewModel)
    api(Jetpack.LifecycleViewModelSavedState)
    api(Jetpack.NavigationCompose)
    api(Jetpack.NavigationDynamic)
    api(Jetpack.NavigationFragment)
    api(Jetpack.NavigationUi)
    api(Jetpack.PagingRuntime)
    api(Jetpack.PagingCompose)
    api(Jetpack.RecyclerView)
    api(Jetpack.ResourceInspection)
    api(Jetpack.Room)
    api(Jetpack.RoomPaging)
    api(Jetpack.RoomRuntime)
    api(Jetpack.Startup)
    api(Jetpack.ViewPager2)
    api(Jetpack.Window)
    api(Jetpack.WindowTesting)
    kapt(Jetpack.LifecycleCommon)
    kapt(Jetpack.RoomCompiler)
    debugApi(Jetpack.ComposeUiTestManifest)
    testApi(Jetpack.RoomTesting)
    testApi(Jetpack.TestCore)
    androidTestApi(Jetpack.ArchCoreTesting)
    androidTestApi(Jetpack.ComposeUiTest)
    androidTestApi(Jetpack.NavigationTesting)
    androidTestApi(Jetpack.TestExtJunit)
    androidTestApi(Jetpack.TestEspressoCore)
    androidTestApi(Jetpack.TestCore)
    androidTestApi(Jetpack.TestRunner)
    androidTestApi(Jetpack.TestExtTruth)
    androidTestApi(Jetpack.TestEspressoAccessibility)
    androidTestApi(Jetpack.TestEspressoContrib)
    androidTestApi(Jetpack.TestEspressoIntents)
    androidTestApi(Jetpack.TestUiAutomator)
    androidTestApi(Jetpack.TestRules)

    // GooglePlayServices
    api(GooglePlayServices.Ads)
    api(GooglePlayServices.Auth)
    api(GooglePlayServices.Base)

    // Accompanist
    api(Accompanist.AppCompat)
    api(Accompanist.DrawablePainter)
    api(Accompanist.Insets)
    api(Accompanist.InsetsUi)

    // Firebase
    api(Firebase.FirebaseAbt)
    api(Firebase.FirebaseAnalytics)
    api(Firebase.FirebaseCommon)
    api(Firebase.FirebaseConfig)
    api(Firebase.FirebaseCore)
    api(Firebase.FirebaseCrashlytics)

    // Testing
    testApi(Testing.Junit)
    testApi(Testing.Mockk)
    testApi(Testing.Mockito)
    testApi(Testing.Robolectric)
    androidTestApi(Testing.Truth)

    // ThirdParty
    api(ThirdParty.Material)
    api(ThirdParty.MaterialComposeThemeAdapter)
    api(ThirdParty.PlayCore)
    api(ThirdParty.HiltAndroid)
    api(ThirdParty.Coil)
    api(ThirdParty.CoilCompose)
    api(ThirdParty.Timber)
    api(ThirdParty.GanderImdb)
    api(ThirdParty.GanderPersistence)
    api(ThirdParty.Retrofit)
    api(ThirdParty.RetrofitConverterGson)
    api(ThirdParty.RetrofitConverterMoshi)
    api(ThirdParty.RetrofitConverterSerialization)
    kapt(ThirdParty.HiltCompiler)

    api("com.squareup.okhttp3:logging-interceptor:4.9.3")
}