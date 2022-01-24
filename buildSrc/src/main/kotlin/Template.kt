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
 * AndroidX — https://d.android.com/jetpack/androidx/releases
 *
 * Android
 * @property InstallReferrer — https://d.android.com/google/play/installreferrer/library
 *
 * Google
 * @property Dagger —
 * @property ExoPlayer —
 * @property Material —
 */
object Version {
    const val Detekt = "1.19.0"
    const val Spotless = "6.2.0"

    const val Kotlin = "1.6.0"
    const val Coroutines = "1.6.0"
    const val Serialization = "1.3.2"

    const val Activity = "1.4.0"
    const val AdsIdentifier = "1.0.0-alpha04"
    const val Annotation = "1.3.0"
    const val AnnotationExperimental = "1.2.0"
    const val AppCompat = "1.4.1"
    const val AppSearch = "1.0.0-alpha04"
    const val AsyncLayoutInflater = "1.0.0"
    const val AutoFill = "1.1.0"
    const val BenchmarkPlugin = "1.0.0"
    const val Biometric = "1.2.0-alpha04"
    const val Browser = "1.4.0"
    const val Camera = "1.0.2"
    const val CameraVideo = "1.1.0-alpha12"
    const val CameraView = "1.0.0-alpha32"
    const val CameraExtensions = "1.0.0-alpha32"
    const val CardView = "1.0.0"
    const val Collection = "1.2.0"
    const val Concurrent = "1.1.0"
    const val ContentPager = "1.0.0"
    const val ConstraintLayout = "2.1.3"
    const val ConstraintLayoutCompose = "1.0.0"
    const val Compose = "1.1.0-rc01"
    const val ComposeCompiler = "1.1.0-rc02"
    const val CoordinatorLayout = "1.2.0"
    const val Core = "1.7.0"
    const val CoreRole = "1.0.0"
    const val CoreSplashScreen = "1.0.0-beta01"
    const val CursorAdapter = "1.0.0"
    const val CustomView = "1.1.0"
    const val DataStore = "1.0.0"
    const val DocumentFile = "1.0.1"
    const val DragAndDrop = "1.0.0-alpha02"
    const val DrawerLayout = "1.1.1"
    const val DynamicAnimation = "1.1.0-alpha03"
    const val Emoji = "1.2.0-alpha03"
    const val Emoji2 = "1.1.0-alpha01"
    const val Exifinterface = "1.3.3"
    const val Glance = "1.0.0-alpha01"
    const val GridLayout = "1.0.0"
    const val Fragment = "1.4.0"
    const val Health = "1.0.0-alpha03"
    const val HeifWriter = "1.1.0-alpha01"
    const val HiltNavigationFragment = "1.0.0"
    const val HiltWork = "1.0.0"
    const val Interpolator = "1.0.0"
    const val Leanback = "1.2.0-alpha02"
    const val LeanbackPagingersion = "1.1.0-alpha09"
    const val LeanbackTab = "1.1.0-beta01"
    const val Lifecycle = "2.4.0"
    const val Loader = "1.1.0"
    const val Material3 = "1.0.0-SNAPSHOT"
    const val MaterialIcons = "1.1.0-SNAPSHOT"
    const val Media = "1.4.3"
    const val Media2 = "1.2.0"
    const val Media3 = "1.0.0-alpha01"
    const val MediaRouter = "1.2.5"
    const val Navigation = "2.3.5"
    const val NavigationCompose = "2.4.0-rc01"
    const val Paging = "3.1.0"
    const val PagingCompose = "1.0.0-alpha14"
    const val Palette = "1.0.0"
    const val Preference = "1.1.1"
    const val Print = "1.0.0"
    const val ProfileInstaller = "1.2.0-alpha01"
    const val Recommendation = "1.0.0"
    const val RecyclerView = "1.2.1"
    const val RecyclerviewSelection = "1.1.0"
    const val RemoteCallback = "1.0.0-alpha02"
    const val ResourceInspection = "1.0.0"
    const val Room = "2.4.1"
    const val SavedState = "1.1.0"
    const val SecurityCrypto = "1.0.0"
    const val SecurityIdentityCredential = "1.0.0-alpha03"
    const val SecurityAppAuthenticator = "1.0.0-alpha02"
    const val Slice = "1.1.0-alpha02"
    const val ShareTarget = "1.2.0-rc01"
    const val SlidingPanelLayout = "1.2.0-rc01"
    const val Startup = "1.1.0"
    const val Sqlite = "2.2.0"
    const val SwipeRefreshLayout = "1.1.0"
    const val TextClassifier = "1.0.0-alpha03"
    const val Tracing = "1.1.0-beta01"
    const val Transition = "1.4.1"
    const val Tvprovider = "1.1.0-alpha01"
    const val VectorDrawable = "1.1.0"
    const val VectorDrawableSeekable = "1.0.0-alpha02"
    const val VersionedParcelable = "1.1.1"
    const val ViewPager2 = "1.0.0"
    const val Wear = "1.2.0"
    const val WearCompose = "1.0.0-alpha14"
    const val WearInput = "1.1.0"
    const val WearOngoing = "1.0.0"
    const val WearPhoneInteractions = "1.1.0-alpha02"
    const val WearRemoteInteractions = "1.0.0"
    const val WearTiles = "1.0.0"
    const val WearWatchface = "1.1.0-alpha02"
    const val Webkit = "1.4.0"
    const val Window = "1.0.0-rc01"
    const val Work = "2.7.1"

    const val InstallReferrer = "2.2"

    const val CrashlyticsPlugin = "2.8.1"               // https://firebase.google.com/docs/crashlytics/get-started?platform=android
    const val Dagger = "2.40.5"                         // https://github.com/google/dagger/releases
    const val ExoPlayer = "2.16.1"                      // https://github.com/google/ExoPlayer/releases
    const val Material = "1.6.0-alpha02"                // https://github.com/material-components/material-components-android/releases & https://mvnrepository.com/artifact/com.google.android.material/material
    const val MaterialComposeThemeAdapter = "1.1.3"     // https://mvnrepository.com/artifact/com.google.android.material/compose-theme-adapter
    const val PlayCore = "1.8.1"                        // https://d.android.com/reference/com/google/android/play/core/release-notes

    // Gms
    const val GmsGoogleServices = "4.3.10"            // https://developers.google.com/android/guides/google-services-plugin
    const val GmsOssLicensesPlugin = "0.10.4"         // https://developers.google.com/android/guides/setup
    const val GmsStrictVersionMatcherPlugin = "1.2.2" // https://developers.google.com/android/guides/setup

    const val GmsAds = "20.5.0"                            // https://developers.google.com/admob/android/quick-start
    const val GmsAdsIdentifier = "18.0.1"                  // https://developers.google.com/android/guides/setup
    const val GmsAdsLite = "20.5.0"                        // https://developers.google.com/android/guides/setup
    const val GmsAfsNative = "19.0.3"                      // https://developers.google.com/android/guides/setup
    const val GmsAnalytics = "18.0.1"                      // https://developers.google.com/android/guides/setup
    const val GmsAppset = "16.0.2"                         // https://developers.google.com/android/guides/setup
    const val GmsAuth = "20.0.1"                           // https://developers.google.com/identity/sign-in/android/start-integrating
    const val GmsAuthApiPhone = "18.0.1"                   // https://developers.google.com/android/guides/setup
    const val GmsAuthBlockstore = "16.1.0"                 // https://developers.google.com/android/guides/setup
    const val GmsAwareness = "19.0.1"                      // https://developers.google.com/android/guides/setup
    const val GmsBase = "18.0.1"                           // https://developers.google.com/android/guides/setup
    const val GmsBasement = "18.0.0"                       // https://developers.google.com/android/guides/setup
    const val GmsCast = "21.0.1"                           // https://developers.google.com/android/guides/setup
    const val GmsCastFramework = "21.0.1"                  // https://developers.google.com/android/guides/setup
    const val GmsCronet = "18.0.1"                         // https://developers.google.com/android/guides/setup
    const val GmsFido = "19.0.0-beta"                      // https://developers.google.com/android/guides/setup
    const val GmsFitness = "21.0.1"                        // https://developers.google.com/android/guides/setup
    const val GmsGames = "22.0.1"                          // https://developers.google.com/android/guides/setup
    const val GmsInstantapps = "18.0.1"                    // https://developers.google.com/android/guides/setup
    const val GmsLocation = "19.0.1"                       // https://developers.google.com/android/guides/setup
    const val GmsMaps = "18.0.2"                           // https://developers.google.com/android/guides/setup
    const val GmsMlkitBarcodeScanning = "17.0.0"           // https://developers.google.com/android/guides/setup
    const val GmsMlkitFaceDetection = "16.2.1"             // https://developers.google.com/android/guides/setup
    const val GmsMlkitImageLabeling = "16.0.6"             // https://developers.google.com/android/guides/setup
    const val GmsMlkitImageLabelingCustom = "16.0.0-beta2" // https://developers.google.com/android/guides/setup
    const val GmsMlkitLanguageId = "16.0.0-beta2"          // https://developers.google.com/android/guides/setup
    const val GmsMlkitTextRecognition = "17.0.1"           // https://developers.google.com/android/guides/setup
    const val GmsNearby = "18.0.2"                         // https://developers.google.com/android/guides/setup
    const val GmsOssLicenses = "17.0.0"                    // https://developers.google.com/android/guides/setup
    const val GmsPasswordComplexity = "18.0.1"             // https://developers.google.com/android/guides/setup
    const val GmsPay = "16.0.3"                            // https://developers.google.com/android/guides/setup
    const val GmsRecaptcha = "17.0.1"                      // https://developers.google.com/android/guides/setup
    const val GmsSafetynet = "18.0.1"                      // https://developers.google.com/android/guides/setup
    const val GmsTagManager = "18.0.1"                     // https://developers.google.com/android/guides/setup
    const val GmsTasks = "18.0.1"                          // https://developers.google.com/android/guides/setup
    const val GmsVision = "20.1.3"                         // https://developers.google.com/android/guides/setup
    const val GmsWallet = "19.1.0"                         // https://developers.google.com/android/guides/setup
    const val GmsWearable = "17.1.0"                       // https://developers.google.com/android/guides/setup

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
    const val CoreTesting = "2.1.0"    // https://mvnrepository.com/artifact/androidx.arch.core/core-testing
    const val Junit = "4.13.2"         // https://mvnrepository.com/artifact/junit/junit
    const val TestEspresso = "3.4.0"   // https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
    const val TestJunit = "1.1.3"      // https://mvnrepository.com/artifact/androidx.test.ext/junit
    const val TestRules = "1.4.0"      // https://mvnrepository.com/artifact/androidx.test/rules
    const val TestUiAnimator = "2.2.0" // https://mvnrepository.com/artifact/androidx.test.uiautomator/uiautomator
    const val Truth = "1.1.3"          // https://mvnrepository.com/artifact/com.google.truth/truth
    const val Mockk = "1.12.2"         // https://mvnrepository.com/artifact/io.mockk/mockk
    const val Mockito = "4.2.0"        // https://mvnrepository.com/artifact/org.mockito/mockito-core
    const val Robolectric = "4.7.3"    // https://mvnrepository.com/artifact/org.robolectric/robolectric
    const val AndroidxTestCore = "1.4.0"      // https://mvnrepository.com/artifact/androidx.test/core
    const val Orchestrator = "1.4.1"
    const val BenchmarkMacro = "1.1.0-beta01"
}

object Dependencies {
    const val KotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
    const val KotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"
    const val KotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.Coroutines}"
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
    const val ViewPager2 = "androidx.viewpager2:viewpager2:${Version.ViewPager2}"

    const val InstallReferrer = "com.android.installreferrer:installreferrer:${Version.InstallReferrer}"

    const val Material = "com.google.android.material:material:${Version.Material}"
    const val HiltAndroid = "com.google.dagger:hilt-android:${Version.Dagger}"
    const val HiltCompiler = "com.google.dagger:hilt-compiler:${Version.Dagger}"
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