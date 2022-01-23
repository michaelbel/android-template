package org.michaelbel.template

object App {
    const val VersionCode = 1
    const val VersionName = "1.0.0"

    const val MinSdk = 21
    const val TargetSdk = 31
    const val CompileSdk = 31
    const val BuildTools = "31.0.0"

    const val ApplicationId = "org.michaelbel.template"
}

object Plugin {
    const val Gradle = "7.0.4"
    const val Kotlin = "1.6.10"
    const val Navigation = "2.3.5"
    const val Dagger = "2.40.5"
    const val Google = "4.3.10"
    const val Crashlytics = "2.8.1"
    const val Appdistribution = "3.0.0"
}

/**
 * Plugins
 * @property Detekt — https://github.com/detekt/detekt/releases
 * @property Spotless — https://github.com/diffplug/spotless/blob/main/plugin-gradle/CHANGES.md
 *
 * Kotlin
 * @property Kotlin — https://github.com/JetBrains/kotlin/releases
 * @property Coroutines — https://github.com/Kotlin/kotlinx.coroutines/releases
 * @property Serialization — https://github.com/Kotlin/kotlinx.serialization/releases
 *
 * AndroidX
 * @property Activity — https://d.android.com/jetpack/androidx/releases/activity
 */
object Version {
    const val Detekt = "1.19.0"
    const val Spotless = "6.2.0"

    const val Kotlin = "1.6.0"
    const val Coroutines = "1.6.0"
    const val Serialization = "1.3.2"

    const val Activity = "1.4.0"
    const val AdsIdentifier = "1.0.0-alpha04"        // https://d.android.com/jetpack/androidx/releases/ads
    const val Annotation = "1.3.0"                   // https://d.android.com/jetpack/androidx/releases/annotation
    const val AnnotationExperimental = "1.2.0"       // https://d.android.com/jetpack/androidx/releases/annotation
    const val AppCompat = "1.4.1"                    // https://d.android.com/jetpack/androidx/releases/appcompat
    const val AppSearch = "1.0.0-alpha04"            // https://d.android.com/jetpack/androidx/releases/appsearch
    const val AsyncLayoutInflater = "1.0.0"          // https://d.android.com/jetpack/androidx/releases/asynclayoutinflater
    const val AutoFill = "1.1.0"                     // https://d.android.com/jetpack/androidx/releases/autofill
    const val BenchmarkPlugin = "1.0.0"              // https://d.android.com/jetpack/androidx/releases/benchmark
    const val Biometric = "1.2.0-alpha04"
    const val Browser = "1.4.0"                      // https://d.android.com/jetpack/androidx/releases/browser
    const val Camera = "1.0.2"
    const val CameraVideo = "1.1.0-alpha12"
    const val CameraView = "1.0.0-alpha32"
    const val CameraExtensions = "1.0.0-alpha32"
    const val CardView = "1.0.0"                     // https://d.android.com/jetpack/androidx/releases/cardview
    const val Collection = "1.2.0"                   // https://d.android.com/jetpack/androidx/releases/collection
    const val Concurrent = "1.1.0"
    const val ContentPager = "1.0.0"
    const val constraintlayoutVersion = "2.1.3"             // https://d.android.com/jetpack/androidx/releases/constraintlayout
    const val constraintlayoutComposeVersion = "1.0.0"      // https://d.android.com/jetpack/compose/layouts/constraintlayout
    const val composeVersion = "1.1.0-rc01"                 // https://d.android.google.cn/jetpack/androidx/releases/compose
    const val composeCompilerVersion = "1.1.0-rc02"         // https://d.android.google.cn/jetpack/androidx/releases/compose
    const val coordinatorlayoutVersion = "1.2.0"
    const val Core = "1.7.0"                         // https://d.android.com/jetpack/androidx/releases/core
    const val coreroleVersion = "1.0.0"                     // https://d.android.com/jetpack/androidx/releases/core
    const val CoreSplashScreen = "1.0.0-beta01"      // https://d.android.com/jetpack/androidx/releases/core
    const val cursoradapterVersion = "1.0.0"
    const val customviewVersion = "1.1.0"
    const val datastoreVersion = "1.0.0"                    // https://d.android.com/jetpack/androidx/releases/datastore
    const val documentfileVersion = "1.0.1"
    const val draganddropVersion = "1.0.0-alpha02"          // https://d.android.com/jetpack/androidx/releases/draganddrop
    const val drawerlayoutVersion = "1.1.1"
    const val dynamicanimationVersion = "1.1.0-alpha03"
    const val emojiVersion = "1.2.0-alpha03"
    const val emoji2Version = "1.1.0-alpha01"
    const val exifinterfaceVersion = "1.3.3"
    const val glanceVersion = "1.0.0-alpha01"               // https://d.android.com/jetpack/androidx/releases/glance
    const val gridlayoutVersion = "1.0.0"
    const val Fragment = "1.4.0"                     // https://d.android.com/jetpack/androidx/releases/fragment
    const val healthVersion = "1.0.0-alpha03"
    const val heifwriterVersion = "1.1.0-alpha01"
    const val hiltNavigationFragmentVersion = "1.0.0"       // https://d.android.com/jetpack/androidx/releases/hilt
    const val hiltWorkVersion = "1.0.0"                     // https://d.android.com/jetpack/androidx/releases/hilt
    const val interpolatorVersion = "1.0.0"
    const val leanbackVersion = "1.2.0-alpha02"             // https://d.android.com/jetpack/androidx/releases/leanback
    const val leanbackPagingVersion = "1.1.0-alpha09"
    const val leanbackTabVersion = "1.1.0-beta01"
    const val Lifecycle = "2.4.0"                    // https://d.android.com/jetpack/androidx/releases/lifecycle
    const val loaderVersion = "1.1.0"
    const val material3Version = "1.0.0-SNAPSHOT"           // https://d.android.google.cn/jetpack/androidx/releases/compose-material3
    const val materialIconsVersion = "1.1.0-SNAPSHOT"       // https://mvnrepository.com/artifact/androidx.compose.material/material-icons-extended
    const val mediaVersion = "1.4.3"
    const val media2Version = "1.2.0"
    const val media3Version = "1.0.0-alpha01"               // https://d.android.com/jetpack/androidx/releases/media3
    const val mediarouterVersion = "1.2.5"
    const val navigationVersion = "2.3.5"                   // https://d.android.com/jetpack/androidx/releases/navigation
    const val navigationComposeVersion = "2.4.0-rc01"
    const val Paging = "3.1.0"                       // https://d.android.com/jetpack/androidx/releases/paging
    const val PagingCompose = "1.0.0-alpha14"        // https://d.android.com/jetpack/androidx/releases/paging
    const val paletteVersion = "1.0.0"
    const val preferenceVersion = "1.1.1"
    const val printVersion = "1.0.0"
    const val profileinstallerVersion = "1.2.0-alpha01"
    const val recommendationVersion = "1.0.0"
    const val recyclerviewVersion = "1.2.1"                 // https://d.android.com/jetpack/androidx/releases/recyclerview
    const val recyclerviewSelectionVersion = "1.1.0"        // https://d.android.com/jetpack/androidx/releases/recyclerview
    const val remotecallbackVersion = "1.0.0-alpha02"
    const val resourceinspectionVersion = "1.0.0"
    const val Room = "2.4.1"                         // https://d.android.com/jetpack/androidx/releases/room
    const val savedstateVersion = "1.1.0"                   // https://d.android.com/jetpack/androidx/releases/savedstate
    const val securityCryptoVersion = "1.0.0"
    const val securityIdentityCredentialVersion = "1.0.0-alpha03"
    const val securityAppAuthenticatorVersion = "1.0.0-alpha02"
    const val sliceVersion = "1.1.0-alpha02"
    const val sharetargetVersion = "1.2.0-rc01"             // https://d.android.com/jetpack/androidx/releases/sharetarget
    const val slidingpanelayoutVersion = "1.2.0-rc01"
    const val startupVersion = "1.1.0"
    const val sqliteVersion = "2.2.0"
    const val swiperefreshlayoutVersion = "1.1.0"           // https://d.android.com/jetpack/androidx/releases/swiperefreshlayout
    const val textclassifierVersion = "1.0.0-alpha03"
    const val tracingVersion = "1.1.0-beta01"
    const val transitionVersion = "1.4.1"
    const val tvproviderVersion = "1.1.0-alpha01"
    const val vectordrawableVersion = "1.1.0"
    const val vectordrawableSeekableVersion = "1.0.0-alpha02"
    const val versionedparcelableVersion = "1.1.1"
    const val viewpager2Version = "1.0.0"                   // https://d.android.com/jetpack/androidx/releases/viewpager2
    const val wearVersion = "1.2.0"
    const val wearComposeVersion = "1.0.0-alpha14"
    const val wearInputVersion = "1.1.0"
    const val wearOngoingVersion = "1.0.0"
    const val wearPhoneInteractionsVersion = "1.1.0-alpha02"
    const val wearRemoteInteractionsVersion = "1.0.0"
    const val wearTilesVersion = "1.0.0"
    const val wearWatchfaceVersion = "1.1.0-alpha02"
    const val webkitVersion = "1.4.0"
    const val windowVersion = "1.0.0-rc01"
    const val workVersion = "2.7.1"                         // https://d.android.com/jetpack/androidx/releases/work

    // Android
    const val installreferrerVersion = "2.2" // https://d.android.com/google/play/installreferrer/library

    // Google
    const val accompanistAppcompatThemeVersion = "0.20.3"      // https://google.github.io/accompanist/appcompat-theme
    const val accompanistDrawablePainterVersion = "0.20.3"     // https://google.github.io/accompanist/drawablepainter
    const val accompanistInsetsVersion = "0.20.3"              // https://google.github.io/accompanist/insets
    const val accompanistFlowlayoutVersion = "0.20.3"          // https://google.github.io/accompanist/flowlayout
    const val accompanistNavigationAnimationVersion = "0.20.3" // https://google.github.io/accompanist/navigation-animation
    const val accompanistNavigationMaterialVersion = "0.20.3"  // https://google.github.io/accompanist/navigation-material
    const val accompanistPagerVersion = "0.20.3"               // https://google.github.io/accompanist/pager
    const val accompanistPermissionsVersion = "0.20.3"         // https://google.github.io/accompanist/permissions
    const val accompanistPlaceholderVersion = "0.20.3"         // https://google.github.io/accompanist/placeholder
    const val accompanistSystemuicontrollerVersion = "0.20.3"  // https://google.github.io/accompanist/systemuicontroller
    const val accompanistSwiperefreshVersion = "0.20.3"        // https://google.github.io/accompanist/swiperefresh
    const val crashlyticsPluginVersion = "2.8.1"               // https://firebase.google.com/docs/crashlytics/get-started?platform=android
    const val Dagger = "2.40.5"                         // https://github.com/google/dagger/releases
    const val exoplayerVersion = "2.16.1"                      // https://github.com/google/ExoPlayer/releases
    const val FirebaseAbt = "21.0.0"                    // https://mvnrepository.com/artifact/com.google.firebase/firebase-abt
    const val FirebaseAppDistribution = "3.0.0"                // https://firebase.google.com/docs/app-distribution/android/distribute-gradle
    const val FirebaseAnalytics = "20.0.2"                     // https://mvnrepository.com/artifact/com.google.firebase/firebase-analytics-ktx
    const val FirebaseCommon = "20.0.0"
    const val FirebaseCore = "20.0.2"                   // https://mvnrepository.com/artifact/com.google.firebase/firebase-core
    const val FirebaseCrashlytics = "18.2.6"            // https://mvnrepository.com/artifact/com.google.firebase/firebase-crashlytics-ktx
    const val FirebaseConfig = "21.0.1"                 // https://mvnrepository.com/artifact/com.google.firebase/firebase-config
    const val Material = "1.6.0-alpha02"                // https://github.com/material-components/material-components-android/releases & https://mvnrepository.com/artifact/com.google.android.material/material
    const val MaterialComposeThemeAdapter = "1.1.3"     // https://mvnrepository.com/artifact/com.google.android.material/compose-theme-adapter
    const val PlayCore = "1.8.1"                        // https://d.android.com/reference/com/google/android/play/core/release-notes

    // Gms
    const val gmsGoogleServicesVersion = "4.3.10"            // https://developers.google.com/android/guides/google-services-plugin
    const val gmsOssLicensesPluginVersion = "0.10.4"         // https://developers.google.com/android/guides/setup
    const val gmsStrictVersionMatcherPluginVersion = "1.2.2" // https://developers.google.com/android/guides/setup

    const val gmsAdsVersion = "20.5.0"                            // https://developers.google.com/admob/android/quick-start
    const val gmsAdsIdentifierVersion = "18.0.1"                  // https://developers.google.com/android/guides/setup
    const val gmsAdsLiteVersion = "20.5.0"                        // https://developers.google.com/android/guides/setup
    const val gmsAfsNativeVersion = "19.0.3"                      // https://developers.google.com/android/guides/setup
    const val gmsAnalyticsVersion = "18.0.1"                      // https://developers.google.com/android/guides/setup
    const val gmsAppsetVersion = "16.0.2"                         // https://developers.google.com/android/guides/setup
    const val gmsAuthVersion = "20.0.1"                           // https://developers.google.com/identity/sign-in/android/start-integrating
    const val gmsAuthApiPhoneVersion = "18.0.1"                   // https://developers.google.com/android/guides/setup
    const val gmsAuthBlockstoreVersion = "16.1.0"                 // https://developers.google.com/android/guides/setup
    const val gmsAwarenessVersion = "19.0.1"                      // https://developers.google.com/android/guides/setup
    const val gmsBaseVersion = "18.0.1"                           // https://developers.google.com/android/guides/setup
    const val gmsBasementVersion = "18.0.0"                       // https://developers.google.com/android/guides/setup
    const val gmsCastVersion = "21.0.1"                           // https://developers.google.com/android/guides/setup
    const val gmsCastFrameworkVersion = "21.0.1"                  // https://developers.google.com/android/guides/setup
    const val gmsCronetVersion = "18.0.1"                         // https://developers.google.com/android/guides/setup
    const val gmsFidoVersion = "19.0.0-beta"                      // https://developers.google.com/android/guides/setup
    const val gmsFitnessVersion = "21.0.1"                        // https://developers.google.com/android/guides/setup
    const val gmsGamesVersion = "22.0.1"                          // https://developers.google.com/android/guides/setup
    const val gmsInstantappsVersion = "18.0.1"                    // https://developers.google.com/android/guides/setup
    const val gmsLocationVersion = "19.0.1"                       // https://developers.google.com/android/guides/setup
    const val gmsMapsVersion = "18.0.2"                           // https://developers.google.com/android/guides/setup
    const val gmsMlkitBarcodeScanningVersion = "17.0.0"           // https://developers.google.com/android/guides/setup
    const val gmsMlkitFaceDetectionVersion = "16.2.1"             // https://developers.google.com/android/guides/setup
    const val gmsMlkitImageLabelingVersion = "16.0.6"             // https://developers.google.com/android/guides/setup
    const val gmsMlkitImageLabelingCustomVersion = "16.0.0-beta2" // https://developers.google.com/android/guides/setup
    const val gmsMlkitLanguageIdVersion = "16.0.0-beta2"          // https://developers.google.com/android/guides/setup
    const val gmsMlkitTextRecognitionVersion = "17.0.1"           // https://developers.google.com/android/guides/setup
    const val gmsNearbyVersion = "18.0.2"                         // https://developers.google.com/android/guides/setup
    const val gmsOssLicensesVersion = "17.0.0"                    // https://developers.google.com/android/guides/setup
    const val gmsPasswordComplexityVersion = "18.0.1"             // https://developers.google.com/android/guides/setup
    const val gmsPayVersion = "16.0.3"                            // https://developers.google.com/android/guides/setup
    const val gmsRecaptchaVersion = "17.0.1"                      // https://developers.google.com/android/guides/setup
    const val gmsSafetynetVersion = "18.0.1"                      // https://developers.google.com/android/guides/setup
    const val gmsTagmanagerVersion = "18.0.1"                     // https://developers.google.com/android/guides/setup
    const val gmsTasksVersion = "18.0.1"                          // https://developers.google.com/android/guides/setup
    const val gmsVisionVersion = "20.1.3"                         // https://developers.google.com/android/guides/setup
    const val gmsWalletVersion = "19.1.0"                         // https://developers.google.com/android/guides/setup
    const val gmsWearableVersion = "17.1.0"                       // https://developers.google.com/android/guides/setup

    // Other
    const val Coil = "1.4.0"                        // https://github.com/coil-kt/coil/releases
    const val Retrofit = "2.9.0"                    // https://github.com/square/retrofit
    const val RetrofitConverterSerialization = "0.8.0"      // https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter
    const val LoggingInterceptor = "4.9.3"    // https://github.com/square/okhttp
    const val Picasso = "2.71828"                   // https://github.com/square/picasso
    const val Timber = "5.0.1"                      // https://github.com/JakeWharton/timber/releases
    const val Gander = "3.1.0"                      // https://github.com/Ashok-Varma/Gander/releases
    const val ViewBindingPropertyDelegate = "1.5.6" // https://github.com/androidbroadcast/ViewBindingPropertyDelegate/releases
    const val StrictMode = "30.2.0"                 // https://github.com/androidbroadcast/StrictModeCompat
    const val Vk = "3.4.1"                          // http://github.com/VKCOM/vk-android-sdk
    const val Moshi = "1.12.0"                      // https://github.com/square/moshi/blob/master/CHANGELOG.md

    // Test
    const val coreTestingVersion = "2.1.0"    // https://mvnrepository.com/artifact/androidx.arch.core/core-testing
    const val Junit = "4.13.2"         // https://mvnrepository.com/artifact/junit/junit
    const val TestEspresso = "3.4.0"   // https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
    const val TestJunit = "1.1.3"      // https://mvnrepository.com/artifact/androidx.test.ext/junit
    const val TestRules = "1.4.0"      // https://mvnrepository.com/artifact/androidx.test/rules
    const val testUianimatorVersion = "2.2.0" // https://mvnrepository.com/artifact/androidx.test.uiautomator/uiautomator
    const val truthVersion = "1.1.3"          // https://mvnrepository.com/artifact/com.google.truth/truth
    const val mockkVersion = "1.12.2"         // https://mvnrepository.com/artifact/io.mockk/mockk
    const val mockitoVersion = "4.2.0"        // https://mvnrepository.com/artifact/org.mockito/mockito-core
    const val robolectricVersion = "4.7.3"    // https://mvnrepository.com/artifact/org.robolectric/robolectric
    const val androidxTestCore = "1.4.0"      // https://mvnrepository.com/artifact/androidx.test/core
    const val orchestratorVersion = "1.4.1"
    const val benchmarkMacroVersion = "1.1.0-beta01"
}

object Dependencies {
    const val KotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
    const val KotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"
    const val KotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.Serialization}"

    const val Activity = "androidx.activity:activity-ktx:${Version.Activity}"
    const val AppCompat = "androidx.appcompat:appcompat:${Version.AppCompat}"
    const val Core = "androidx.core:core-ktx:${Version.Core}"
    const val CoreSplashScreen = "androidx.core:core-splashscreen:${Version.CoreSplashScreen}"
    const val Fragment = "androidx.fragment:fragment-ktx:${Version.Fragment}"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle}"
    const val LifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Lifecycle}"
    const val PagingRuntime = "androidx.paging:paging-runtime-ktx:${Version.Paging}"
    const val PagingCompose = "androidx.paging:paging-compose:${Version.PagingCompose}"
    const val RoomPaging = "androidx.room:room-paging:${Version.Room}"

    const val Material = "com.google.android.material:material:${Version.Material}"
    const val HiltAndroid = "com.google.dagger:hilt-android:${Version.Dagger}"
    const val HiltCompiler = "com.google.dagger:hilt-compiler:${Version.Dagger}"
    const val FirebaseAbt = "com.google.firebase:firebase-abt:${Version.FirebaseAbt}"
    const val FirebaseAnalytics = "com.google.firebase:firebase-analytics-ktx:${Version.FirebaseAnalytics}"
    const val FirebaseCore = "com.google.firebase:firebase-core:${Version.FirebaseCore}"
    const val FirebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx:${Version.FirebaseCrashlytics}"
    const val FirebaseCommon = "com.google.firebase:firebase-common-ktx:${Version.FirebaseCommon}"
    const val FirebaseConfig = "com.google.firebase:firebase-config-ktx:${Version.FirebaseConfig}"
    const val PlayCore = "com.google.android.play:core-ktx:${Version.PlayCore}"

    const val Retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"
    const val RetrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Version.Retrofit}"
    const val RetrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:${Version.Retrofit}"
    const val LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.LoggingInterceptor}"
    const val Timber = "com.jakewharton.timber:timber:${Version.Timber}"
    const val RetrofitConverterSerialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.RetrofitConverterSerialization}"
    const val GanderPersistence = "com.ashokvarma.android:gander-persistence:${Version.Gander}"
    const val GanderImdb = "com.ashokvarma.android:gander-imdb:${Version.Gander}"

    const val Junit = "junit:junit:${Version.Junit}"
    const val TestJunit = "androidx.test.ext:junit:${Version.TestJunit}"
    const val TestEspresso = "androidx.test.espresso:espresso-core:${Version.TestEspresso}"
}