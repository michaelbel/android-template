
import org.michaelbel.template.Accompanist
import org.michaelbel.template.App
import org.michaelbel.template.Dependencies
import org.michaelbel.template.Firebase
import org.michaelbel.template.GooglePlayServices
import org.michaelbel.template.Kotlin
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
        freeCompilerArgs = freeCompilerArgs + Kotlin.Options.all
    }

    sourceSets.getByName("main") {
        java.srcDir("src/main/kotlin")
    }
}

dependencies {
    api(Kotlin.CoroutinesCore)
    api(Kotlin.CoroutinesAndroid)
    api(Kotlin.Serialization)

    //implementation("androidx.dynamicanimation:dynamicanimation-ktx:$dynamicanimationVersion") not found
    //implementation "androidx.media3:media3-exoplayer:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-exoplayer-dash:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-exoplayer-hls:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-exoplayer-rtsp:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-exoplayer-ima:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-datasource-cronet:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-datasource-okhttp:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-datasource-rtmp:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-ui:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-ui-leanback:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-session:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-extractor:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-cast:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-exoplayer-workmanager:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-transformer:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-test-utils:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-test-utils-robolectric:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-database:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-decoder:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-datasource:$media3Version" Manifest merger failed
    //implementation "androidx.media3:media3-common:$media3Version" Manifest merger failed
    //implementation("androidx.slice:slice-builders-ktx:$sliceVersion") not found

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
    api("androidx.camera:camera-core:${Version.Camera}")
    api("androidx.camera:camera-camera2:${Version.Camera}")
    api("androidx.camera:camera-lifecycle:${Version.Camera}")
    api("androidx.camera:camera-video:${Version.CameraVideo}")
    api("androidx.camera:camera-view:${Version.CameraView}")
    api("androidx.camera:camera-extensions:${Version.CameraExtensions}")
    api("androidx.cardview:cardview:${Version.CardView}")
    api("androidx.collection:collection-ktx:${Version.Collection}")
    api("androidx.compose.animation:animation:${Version.Compose}")
    api("androidx.compose.compiler:compiler:${Version.ComposeCompiler}")
    api("androidx.draganddrop:draganddrop:${Version.DragAndDrop}")
    api("androidx.compose.foundation:foundation:${Version.Compose}")
    api("androidx.compose.foundation:foundation-layout:${Version.Compose}")
    api("androidx.compose.material3:material3:${Version.Material3}")
    api("androidx.compose.material3:material3-samples:${Version.Material3}")
    api("androidx.compose.material:material-icons-core-samples:${Version.MaterialIcons}")
    api("androidx.compose.material:material-icons-extended:${Version.MaterialIcons}")
    api("androidx.compose.runtime:runtime:${Version.Compose}")
    api("androidx.compose.runtime:runtime-livedata:${Version.Compose}")
    api("androidx.compose.ui:ui:${Version.Compose}")
    api("androidx.compose.ui:ui-viewbinding:${Version.Compose}")
    api("androidx.compose.ui:ui-tooling:${Version.Compose}")
    api("androidx.constraintlayout:constraintlayout:${Version.ConstraintLayout}")
    api("androidx.constraintlayout:constraintlayout-compose:${Version.ConstraintLayoutCompose}")
    api(Dependencies.Core)
    api(Dependencies.CoreSplashScreen)
    api("androidx.concurrent:concurrent-futures-ktx:${Version.Concurrent}")
    api("androidx.contentpager:contentpager:${Version.ContentPager}")
    api("androidx.coordinatorlayout:coordinatorlayout:${Version.CoordinatorLayout}")
    api("androidx.core:core-role:${Version.CoreRole}")
    api("androidx.cursoradapter:cursoradapter:${Version.CursorAdapter}")
    api("androidx.customview:customview:${Version.CustomView}")
    api("androidx.datastore:datastore-core:${Version.DataStore}")
    api("androidx.datastore:datastore-preferences:${Version.DataStore}")
    api("androidx.datastore:datastore-preferences-core:${Version.DataStore}")
    api("androidx.documentfile:documentfile:${Version.DocumentFile}")
    api("androidx.draganddrop:draganddrop:${Version.DragAndDrop}")
    api("androidx.drawerlayout:drawerlayout:${Version.DrawerLayout}")
    api("androidx.emoji:emoji:${Version.Emoji}")
    api("androidx.emoji:emoji-appcompat:${Version.Emoji}")
    api("androidx.emoji:emoji-bundled:${Version.Emoji}")
    api("androidx.emoji2:emoji2:${Version.Emoji2}")
    api("androidx.emoji2:emoji2-views:${Version.Emoji2}")
    api("androidx.emoji2:emoji2-views-helper:${Version.Emoji2}")
    api("androidx.exifinterface:exifinterface:${Version.Exifinterface}")
    api("androidx.glance:glance:${Version.Glance}")
    api("androidx.gridlayout:gridlayout:${Version.GridLayout}")
    api(Dependencies.Fragment)
    api(Dependencies.HiltNavigationCompose)
    api("androidx.hilt:hilt-navigation-fragment:${Version.HiltNavigationFragment}")
    api("androidx.hilt:hilt-work:${Version.HiltWork}")
    api("androidx.health:health-services-client:${Version.Health}")
    api("androidx.heifwriter:heifwriter:${Version.HeifWriter}")
    api("androidx.interpolator:interpolator:${Version.Interpolator}")
    api(Dependencies.LifecycleRuntime)
    api(Dependencies.LifecycleViewmodel)
    api("androidx.lifecycle:lifecycle-common-java8:${Version.Lifecycle}")
    kapt("androidx.lifecycle:lifecycle-common-java8:${Version.Lifecycle}")
    api("androidx.lifecycle:lifecycle-livedata-ktx:${Version.Lifecycle}")
    api("androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.Lifecycle}")
    api("androidx.loader:loader:${Version.Loader}")
    api("androidx.media:media:${Version.Media}")
    api("androidx.media2:media2-session:${Version.Media2}")
    api("androidx.media2:media2-widget:${Version.Media2}")
    api("androidx.media2:media2-player:${Version.Media2}")
    api("androidx.mediarouter:mediarouter:${Version.MediaRouter}")
    api("androidx.navigation:navigation-fragment-ktx:${Version.Navigation}")
    api("androidx.navigation:navigation-ui-ktx:${Version.Navigation}")
    api("androidx.navigation:navigation-dynamic-features-fragment:${Version.Navigation}")
    api("androidx.navigation:navigation-compose:${Version.NavigationCompose}")
    api(Dependencies.PagingRuntime)
    api(Dependencies.PagingCompose)
    api("androidx.palette:palette-ktx:${Version.Palette}")
    api("androidx.preference:preference-ktx:${Version.Preference}")
    api("androidx.print:print:${Version.Print}")
    api("androidx.profileinstaller:profileinstaller:${Version.ProfileInstaller}")
    api(Dependencies.RoomPaging)
    api("androidx.recommendation:recommendation:${Version.Recommendation}")
    api("androidx.recyclerview:recyclerview:${Version.RecyclerView}")
    api("androidx.recyclerview:recyclerview-selection:${Version.RecyclerviewSelection}")
    api("androidx.remotecallback:remotecallback:${Version.RemoteCallback}")
    kapt("androidx.remotecallback:remotecallback-processor:${Version.RemoteCallback}")
    api("androidx.resourceinspection:resourceinspection-annotation:${Version.ResourceInspection}")
    api("androidx.room:room-runtime:${Version.Room}")
    kapt("androidx.room:room-compiler:${Version.Room}")
    api("androidx.room:room-ktx:${Version.Room}")
    api("androidx.savedstate:savedstate-ktx:${Version.SavedState}")
    api("androidx.security:security-crypto:${Version.SecurityCrypto}")
    api("androidx.security:security-identity-credential:${Version.SecurityIdentityCredential}")
    api("androidx.security:security-app-authenticator:${Version.SecurityAppAuthenticator}")
    api("androidx.sharetarget:sharetarget:${Version.ShareTarget}")
    api("androidx.slice:slice-core:${Version.Slice}")
    api("androidx.slice:slice-view:${Version.Slice}")
    api("androidx.slidingpanelayout:slidingpanelayout:${Version.SlidingPanelLayout}")
    api("androidx.sqlite:sqlite-ktx:${Version.Sqlite}")
    api("androidx.sqlite:sqlite-framework:${Version.Sqlite}")
    api("androidx.startup:startup-runtime:${Version.Startup}")
    api("androidx.swiperefreshlayout:swiperefreshlayout:${Version.SwipeRefreshLayout}")
    api("androidx.textclassifier:textclassifier:${Version.TextClassifier}")
    api("androidx.tracing:tracing-ktx:${Version.Tracing}")
    api("androidx.transition:transition-ktx:${Version.Transition}")
    api("androidx.tvprovider:tvprovider:${Version.Tvprovider}")
    api("androidx.vectordrawable:vectordrawable:${Version.VectorDrawable}")
    api("androidx.vectordrawable:vectordrawable-animated:${Version.VectorDrawable}")
    api("androidx.vectordrawable:vectordrawable-seekable:1.0.0-alpha02")
    api("androidx.versionedparcelable:versionedparcelable:${Version.VersionedParcelable}")
    api(Dependencies.ViewPager2)
    api("androidx.webkit:webkit:${Version.Webkit}")
    api("androidx.window:window:${Version.Window}")
    api("androidx.window:window-testing:${Version.Window}")
    api("androidx.work:work-runtime-ktx:${Version.Work}")
    api("androidx.work:work-gcm:${Version.Work}")
    api("androidx.work:work-multiprocess:${Version.Work}")

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

    api(GooglePlayServices.Ads)
    api(GooglePlayServices.Auth)
    api(GooglePlayServices.Base)

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
    api("io.coil-kt:coil:${Version.Coil}")
    api("io.coil-kt:coil-compose:${Version.Coil}")

    testApi(Dependencies.Junit)
    testApi(Kotlin.CoroutinesTest)
    testApi("io.mockk:mockk:${Version.Mockk}")
    testApi("org.mockito:mockito-core:${Version.Mockito}")
    testApi("org.robolectric:robolectric:${Version.Robolectric}")
    testApi("androidx.test:core:${Version.AndroidxTestCore}")
    testApi("androidx.room:room-testing:${Version.Room}")
    androidTestApi(Kotlin.CoroutinesTest)
    androidTestApi(Dependencies.TestJunit)
    androidTestApi(Dependencies.TestEspresso)
    androidTestApi("androidx.arch.core:core-testing:${Version.CoreTesting}")
    androidTestApi("androidx.benchmark:benchmark-junit4:${Version.BenchmarkPlugin}")
    androidTestApi("androidx.benchmark:benchmark-macro-junit4:${Version.BenchmarkMacro}")
    androidTestApi("androidx.compose.ui:ui-test-junit4:${Version.Compose}")
    androidTestApi("androidx.navigation:navigation-testing:${Version.Navigation}")
    androidTestApi("androidx.security:security-app-authenticator:${Version.SecurityAppAuthenticator}")
    androidTestApi("androidx.test:core-ktx:${Version.AndroidxTestCore}")
    androidTestApi("androidx.test.ext:junit-ktx:${Version.TestJunit}")
    androidTestApi("androidx.test:runner:${Version.AndroidxTestCore}")
    androidTestApi("androidx.test.ext:truth:${Version.AndroidxTestCore}")
    androidTestApi("androidx.test.espresso:espresso-accessibility:${Version.TestEspresso}")
    androidTestApi("androidx.test.espresso:espresso-contrib:${Version.TestEspresso}")
    androidTestApi("androidx.test.espresso:espresso-core:${Version.TestEspresso}")
    androidTestApi("androidx.test.espresso:espresso-intents:${Version.TestEspresso}")
    androidTestApi("androidx.test.uiautomator:uiautomator:${Version.TestUiAnimator}")
    androidTestApi("androidx.test:rules:${Version.TestRules}")
    androidTestApi("androidx.work:work-testing:${Version.Work}")
    androidTestApi("com.google.truth:truth:${Version.Truth}")

    //debugApi("androidx.fragment:fragment-testing:$fragmentVersion") — not uses exported in manifest
    //androidTestUtil("androidx.test:orchestrator:$orchestratorVersion")

    debugApi("androidx.compose.ui:ui-test-manifest:${Version.Compose}")
}