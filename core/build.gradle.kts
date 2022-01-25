
import org.michaelbel.template.Accompanist
import org.michaelbel.template.App
import org.michaelbel.template.Dependencies
import org.michaelbel.template.Firebase
import org.michaelbel.template.KotlinOptions
import org.michaelbel.template.Version

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
    api("androidx.activity:activity-compose:${Version.Activity}")
    api(Dependencies.AppCompat)
    api("androidx.ads:ads-identifier:${Version.AdsIdentifier}")
    api("androidx.annotation:annotation:${Version.Annotation}")
    api("androidx.annotation:annotation-experimental:${Version.AnnotationExperimental}")
    api("androidx.appsearch:appsearch:${Version.AppSearch}")
    kapt("androidx.appsearch:appsearch-compiler:${Version.AppSearch}")
    api("androidx.appsearch:appsearch-local-storage:${Version.AppSearch}")
    api("androidx.appsearch:appsearch-platform-storage:${Version.AppSearch}")
    api("androidx.asynclayoutinflater:asynclayoutinflater:${Version.AsyncLayoutInflater}")
    api("androidx.autofill:autofill:${Version.AutoFill}")
    api("androidx.biometric:biometric-ktx:${Version.Biometric}")
    api("androidx.browser:browser:${Version.Browser}")
    api("androidx.constraintlayout:constraintlayout:${Version.ConstraintLayout}")
    api("androidx.constraintlayout:constraintlayout-compose:${Version.ConstraintLayoutCompose}")
    api(Dependencies.Core)
    api(Dependencies.CoreSplashScreen)
    api("androidx.datastore:datastore-core:${Version.DataStore}")
    api("androidx.datastore:datastore-preferences:${Version.DataStore}")
    api("androidx.datastore:datastore-preferences-core:${Version.DataStore}")
    api(Dependencies.Fragment)
    api(Dependencies.HiltNavigationCompose)
    api("androidx.hilt:hilt-navigation-fragment:${Version.HiltNavigationFragment}")
    api("androidx.hilt:hilt-work:${Version.HiltWork}")
    api("androidx.interpolator:interpolator:${Version.Interpolator}")
    api(Dependencies.LifecycleRuntime)
    api(Dependencies.LifecycleViewmodel)
    api(Dependencies.PagingRuntime)
    api(Dependencies.PagingCompose)
    api(Dependencies.RoomPaging)
    api(Dependencies.ViewPager2)

    api(Dependencies.InstallReferrer)

    api(Dependencies.Material)
    api("com.google.android.exoplayer:exoplayer:${Version.ExoPlayer}")
    api("com.google.android.exoplayer:exoplayer-core:${Version.ExoPlayer}")
    api("com.google.android.exoplayer:exoplayer-dash:${Version.ExoPlayer}")
    api("com.google.android.exoplayer:exoplayer-ui:${Version.ExoPlayer}")
    api("com.google.android.material:compose-theme-adapter:${Version.MaterialComposeThemeAdapter}")
    api(Dependencies.HiltAndroid)
    kapt(Dependencies.HiltCompiler)
    api(Dependencies.PlayCore)

    api("com.google.android.gms:play-services-ads:${Version.GmsAds}")
    api("com.google.android.gms:play-services-ads-identifier:${Version.GmsAdsIdentifier}")
    api("com.google.android.gms:play-services-ads-lite:${Version.GmsAdsLite}")
    api("com.google.android.gms:play-services-afs-native:${Version.GmsAfsNative}")
    api("com.google.android.gms:play-services-analytics:${Version.GmsAnalytics}")
    api("com.google.android.gms:play-services-appset:${Version.GmsAppset}")
    api("com.google.android.gms:play-services-auth:${Version.GmsAuth}")
    api("com.google.android.gms:play-services-auth-api-phone:${Version.GmsAuthApiPhone}")
    api("com.google.android.gms:play-services-auth-blockstore:${Version.GmsAuthBlockstore}")
    api("com.google.android.gms:play-services-awareness:${Version.GmsAwareness}")
    api("com.google.android.gms:play-services-base:${Version.GmsBase}")
    api("com.google.android.gms:play-services-basement:${Version.GmsBasement}")
    api("com.google.android.gms:play-services-cast:${Version.GmsCast}")
    api("com.google.android.gms:play-services-cast-framework:${Version.GmsCastFramework}")
    api("com.google.android.gms:play-services-cronet:${Version.GmsCronet}")
    api("com.google.android.gms:play-services-fido:${Version.GmsFido}")
    api("com.google.android.gms:play-services-fitness:${Version.GmsFitness}")
    api("com.google.android.gms:play-services-games:${Version.GmsGames}")
    api("com.google.android.gms:play-services-instantapps:${Version.GmsInstantapps}")
    api("com.google.android.gms:play-services-location:${Version.GmsLocation}")
    api("com.google.android.gms:play-services-maps:${Version.GmsMaps}")
    api("com.google.android.gms:play-services-mlkit-barcode-scanning:${Version.GmsMlkitBarcodeScanning}")
    api("com.google.android.gms:play-services-mlkit-face-detection:${Version.GmsMlkitFaceDetection}")
    api("com.google.android.gms:play-services-mlkit-image-labeling:${Version.GmsMlkitImageLabeling}")
    api("com.google.android.gms:play-services-mlkit-image-labeling-custom:${Version.GmsMlkitImageLabelingCustom}")
    api("com.google.android.gms:play-services-mlkit-language-id:${Version.GmsMlkitLanguageId}")
    api("com.google.android.gms:play-services-mlkit-text-recognition:${Version.GmsMlkitTextRecognition}")
    api("com.google.android.gms:play-services-nearby:${Version.GmsNearby}")
    api("com.google.android.gms:play-services-oss-licenses:${Version.GmsOssLicenses}")
    api("com.google.android.gms:play-services-password-complexity:${Version.GmsPasswordComplexity}")
    api("com.google.android.gms:play-services-pay:${Version.GmsPay}")
    api("com.google.android.gms:play-services-recaptcha:${Version.GmsRecaptcha}")
    api("com.google.android.gms:play-services-safetynet:${Version.GmsSafetynet}")
    api("com.google.android.gms:play-services-tagmanager:${Version.GmsTagManager}")
    api("com.google.android.gms:play-services-tasks:${Version.GmsTasks}")
    api("com.google.android.gms:play-services-vision:${Version.GmsVision}")
    api("com.google.android.gms:play-services-wallet:${Version.GmsWallet}")
    api("com.google.android.gms:play-services-wearable:${Version.GmsWearable}")

    api(Accompanist.AppCompat)
    api(Accompanist.DrawablePainter)
    api(Accompanist.Insets)
    api(Accompanist.InsetsUi)
    api(Accompanist.FlowLayout)
    api(Accompanist.NavigationAnimation)
    api(Accompanist.NavigationMaterial)
    api(Accompanist.Pager)
    api(Accompanist.PagerIndicators)
    api(Accompanist.Permissions)
    api(Accompanist.Placeholder)
    api(Accompanist.PlaceholderMaterial)
    api(Accompanist.SystemUiController)
    api(Accompanist.SwipeRefresh)

    api(Firebase.Abt)
    api(Firebase.Analytics)
    api(Firebase.Common)
    api(Firebase.Config)
    api(Firebase.Core)
    api(Firebase.Crashlytics)

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