@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestApi
import org.michaelbel.template.extensions.androidTestImplementation
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.kapt
import org.michaelbel.template.extensions.testApi

/**
 * Jetpack & AndroidX
 *
 * @see <a href="https://d.android.com/jetpack/androidx/releases">AndroidX releases</a>
 * @see <a href="https://d.android.com/google/play/installreferrer/library">Play Install Referrer Library</a>
 */

private const val ActivityVersion = "1.4.0"
private const val AdsIdentifierVersion = "1.0.0-alpha04"
private const val AnnotationVersion = "1.3.0"
private const val AnnotationExperimentalVersion = "1.2.0"
private const val AppCompatVersion = "1.4.1"
private const val AppSearchVersion = "1.0.0-alpha04"
private const val ArchCoreVersion = "2.1.0"
private const val AsyncLayoutInflaterVersion = "1.0.0"
private const val AutoFillVersion = "1.1.0"
private const val BenchmarkVersion = "1.0.0"
private const val BenchmarkMacroVersion = "1.1.0-beta01"
private const val BiometricVersion = "1.2.0-alpha04"
private const val BrowserVersion = "1.4.0"
private const val CameraVersion = "1.0.2"
private const val CameraVideoVersion = "1.1.0-alpha12"
private const val CameraViewVersion = "1.0.0-alpha32"
private const val CameraExtensionsVersion = "1.0.0-alpha32"
private const val CardViewVersion = "1.0.0"
private const val CollectionVersion = "1.2.0"
private const val ConcurrentVersion = "1.1.0"
private const val ConstraintLayoutVersion = "2.1.3"
private const val ConstraintLayoutComposeVersion = "1.0.0"
private const val ContentPagerVersion = "1.0.0"
private const val CoordinatorLayoutVersion = "1.2.0"
private const val CoreVersion = "1.7.0"
private const val CoreAnimationVersion = "1.0.0-alpha02"
private const val CoreGoogleShortcutsVersion = "1.0.0"
private const val CoreRemoteViewsVersion = "1.0.0-alpha01"
private const val CoreRoleVersion = "1.0.0"
private const val CoreSplashScreenVersion = "1.0.0-beta01"
private const val CursorAdapterVersion = "1.0.0"
private const val CustomViewVersion = "1.1.0"
private const val DataStoreVersion = "1.0.0"
private const val DocumentFileVersion = "1.0.1"
private const val DragAndDropVersion = "1.0.0-alpha02"
private const val DrawerLayoutVersion = "1.1.1"
private const val DynamicAnimationVersion = "1.1.0-alpha03"
private const val EmojiVersion = "1.2.0-alpha03"
private const val Emoji2Version = "1.1.0-alpha01"
private const val EnterpriseVersion = "1.1.0"
private const val ExifinterfaceVersion = "1.3.3"
private const val FragmentVersion = "1.4.0"
private const val GlanceVersion = "1.0.0-alpha01"
private const val GridLayoutVersion = "1.0.0"
private const val HealthVersion = "1.0.0-alpha03"
private const val HeifWriterVersion = "1.1.0-alpha01"
private const val HiltNavigationComposeVersion = "1.0.0-rc01"
private const val HiltNavigationFragmentVersion = "1.0.0"
private const val HiltWorkVersion = "1.0.0"
private const val InterpolatorVersion = "1.0.0"
private const val LifecycleVersion = "2.4.0"
private const val LoaderVersion = "1.1.0"
private const val MediaVersion = "1.4.3"
private const val Media2Version = "1.2.0"
private const val Media3Version = "1.0.0-alpha01"
private const val MediaRouterVersion = "1.2.5"
private const val MetricsVersion = "1.0.0-alpha01"
private const val NavigationVersion = "2.3.5"
private const val NavigationSafeArgsPluginVersion = "2.5.0-alpha01"
private const val NavigationComposeVersion = "2.4.0-rc01"
private const val PagingVersion = "3.1.0"
private const val PagingComposeVersion = "1.0.0-alpha14"
private const val PaletteVersion = "1.0.0"
private const val PreferenceVersion = "1.1.1"
private const val PrintVersion = "1.0.0"
private const val ProfileInstallerVersion = "1.2.0-alpha01"
private const val RecommendationVersion = "1.0.0"
private const val RecyclerViewVersion = "1.2.1"
private const val RecyclerviewSelectionVersion = "1.1.0"
private const val RemoteCallbackVersion = "1.0.0-alpha02"
private const val ResourceInspectionVersion = "1.0.0"
private const val SavedStateVersion = "1.1.0"
private const val SecurityCryptoVersion = "1.0.0"
private const val SecurityIdentityCredentialVersion = "1.0.0-alpha03"
private const val SecurityAppAuthenticatorVersion = "1.0.0-alpha02"
private const val ShareTargetVersion = "1.2.0-rc01"
private const val SliceVersion = "1.1.0-alpha02"
private const val SlidingPanelLayoutVersion = "1.2.0-rc01"
private const val StartupVersion = "1.1.0"
private const val SwipeRefreshLayoutVersion = "1.1.0"
private const val TestCoreVersion = "1.4.0"
private const val TestEspressoVersion = "3.4.0"
private const val TestExtJunitVersion = "1.1.3"
private const val TestExtTruthVersion = "1.4.0"
private const val TestJunitVersion = "1.1.3"
private const val TestOrchestratorVersion = "1.4.1"
private const val TestRulesVersion = "1.4.0"
private const val TestRunnerVersion = "1.4.0"
private const val TestUiAutomatorVersion = "2.2.0"
private const val TextClassifierVersion = "1.0.0-alpha03"
private const val TracingVersion = "1.1.0-beta01"
private const val TransitionVersion = "1.4.1"
private const val VectorDrawableVersion = "1.1.0"
private const val VectorDrawableSeekableVersion = "1.0.0-alpha02"
private const val VersionedParcelableVersion = "1.1.1"
private const val ViewPager2Version = "1.0.0"
private const val WebkitVersion = "1.4.0"
private const val WindowVersion = "1.0.0-rc01"
private const val WorkVersion = "2.7.1"

private const val Activity = "androidx.activity:activity-ktx:$ActivityVersion"
private const val ActivityCompose = "androidx.activity:activity-compose:$ActivityVersion"
private const val AdsIdentifier = "androidx.ads:ads-identifier:$AdsIdentifierVersion"
private const val Annotation = "androidx.annotation:annotation:$AnnotationVersion"
private const val AnnotationExperimental = "androidx.annotation:annotation-experimental:$AnnotationExperimentalVersion"
private const val AppCompat = "androidx.appcompat:appcompat:$AppCompatVersion"
private const val AppCompatResources = "androidx.appcompat:appcompat-resources:$AppCompatVersion"
private const val AppSearch = "androidx.appsearch:appsearch:$AppSearchVersion"
private const val AppSearchCompiler = "androidx.appsearch:appsearch-compiler:$AppSearchVersion"
private const val AppSearchLocalStorage = "androidx.appsearch:appsearch-local-storage:$AppSearchVersion"
private const val AppSearchPlatformStorage = "androidx.appsearch:appsearch-platform-storage:$AppSearchVersion"
private const val ArchCoreCommon = "androidx.arch.core:core-common:$ArchCoreVersion"
private const val ArchCoreRuntime = "androidx.arch.core:core-runtime:$ArchCoreVersion"
private const val ArchCoreTesting = "androidx.arch.core:core-testing:$ArchCoreVersion"
private const val AsyncLayoutInflater = "androidx.asynclayoutinflater:asynclayoutinflater:$AsyncLayoutInflaterVersion"
private const val AutoFill = "androidx.autofill:autofill:$AutoFillVersion"
private const val BenchmarkPlugin = "androidx.benchmark:benchmark-gradle-plugin:$BenchmarkVersion"
private const val BenchmarkJunit = "androidx.benchmark:benchmark-junit4:$BenchmarkVersion"
private const val BenchmarkMacro = "androidx.benchmark:benchmark-macro-junit4:$BenchmarkMacroVersion"
private const val Biometric = "androidx.biometric:biometric-ktx:$BiometricVersion"
private const val Browser = "androidx.browser:browser:$BrowserVersion"
private const val CameraCore = "androidx.camera:camera-core:$CameraVersion"
private const val CameraCamera2 = "androidx.camera:camera-camera2:$CameraVersion"
private const val CameraLifecycle = "androidx.camera:camera-lifecycle:$CameraVersion"
private const val CameraVideo = "androidx.camera:camera-video:$CameraVideoVersion"
private const val CameraView = "androidx.camera:camera-view:$CameraViewVersion"
private const val CameraExtensions = "androidx.camera:camera-extensions:$CameraExtensionsVersion"
private const val CardView = "androidx.cardview:cardview:$CardViewVersion"
private const val Collection = "androidx.collection:collection-ktx:$CollectionVersion"
private const val Concurrent = "androidx.concurrent:concurrent-futures-ktx:$ConcurrentVersion"
private const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:$ConstraintLayoutVersion"
private const val ConstraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:$ConstraintLayoutComposeVersion"
private const val ContentPager = "androidx.contentpager:contentpager:$ContentPagerVersion"
private const val CoordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:$CoordinatorLayoutVersion"
private const val Core = "androidx.core:core-ktx:$CoreVersion"
private const val CoreAnimation = "androidx.core:core-animation:$CoreAnimationVersion"
private const val CoreAnimationTesting = "androidx.core:core-animation-testing:$CoreAnimationVersion"
private const val CoreGoogleShortcuts = "androidx.core:core-google-shortcuts:$CoreGoogleShortcutsVersion"
private const val CoreRemoteViews = "androidx.core:core-remoteviews:$CoreRemoteViewsVersion"
private const val CoreRole = "androidx.core:core-role:$CoreRoleVersion"
private const val CoreSplashScreen = "androidx.core:core-splashscreen:$CoreSplashScreenVersion"
private const val CursorAdapter = "androidx.cursoradapter:cursoradapter:$CursorAdapterVersion"
private const val CustomView = "androidx.customview:customview:$CustomViewVersion"
private const val DataStoreCore = "androidx.datastore:datastore-core:$DataStoreVersion"
private const val DataStorePreferences = "androidx.datastore:datastore-preferences:$DataStoreVersion"
private const val DataStorePreferencesCore = "androidx.datastore:datastore-preferences-core:$DataStoreVersion"
private const val DocumentFile = "androidx.documentfile:documentfile:$DocumentFileVersion"
private const val DragAndDrop = "androidx.draganddrop:draganddrop:$DragAndDropVersion"
private const val DrawerLayout = "androidx.drawerlayout:drawerlayout:$DrawerLayoutVersion"
private const val DynamicAnimation = "androidx.dynamicanimation:dynamicanimation-ktx:$DynamicAnimationVersion"
private const val Emoji = "androidx.emoji:emoji:$EmojiVersion"
private const val EmojiAppcompat = "androidx.emoji:emoji-appcompat:$EmojiVersion"
private const val EmojiBundled = "androidx.emoji:emoji-bundled:$EmojiVersion"
private const val Emoji2 = "androidx.emoji2:emoji2:$Emoji2Version"
private const val Emoji2Views = "androidx.emoji2:emoji2-views:$Emoji2Version"
private const val Emoji2ViewsHelper = "androidx.emoji2:emoji2-views-helper:$Emoji2Version"
private const val EnterpriseFeedback = "androidx.enterprise:enterprise-feedback:$EnterpriseVersion"
private const val EnterpriseFeedbackTesting = "androidx.enterprise:enterprise-feedback-testing:$EnterpriseVersion"
private const val Exifinterface = "androidx.exifinterface:exifinterface:$ExifinterfaceVersion"
private const val Fragment = "androidx.fragment:fragment-ktx:$FragmentVersion"
private const val FragmentTesting = "androidx.fragment:fragment-testing:$FragmentVersion"
private const val Glance = "androidx.glance:glance:$GlanceVersion"
private const val GlanceAppWidget = "androidx.glance:glance-appwidget:$GlanceVersion"
private const val GridLayout = "androidx.gridlayout:gridlayout:$GridLayoutVersion"
private const val Health = "androidx.health:health-services-client:$HealthVersion"
private const val Heifwriter = "androidx.heifwriter:heifwriter:$HeifWriterVersion"
private const val HiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$HiltNavigationComposeVersion"
private const val HiltNavigationFragment = "androidx.hilt:hilt-navigation-fragment:$HiltNavigationFragmentVersion"
private const val HiltWork = "androidx.hilt:hilt-work:$HiltWorkVersion"
private const val Interpolator = "androidx.interpolator:interpolator:$InterpolatorVersion"
private const val LifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:$LifecycleVersion"
private const val LifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:$LifecycleVersion"
private const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$LifecycleVersion"
private const val LifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LifecycleVersion"
private const val LifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$LifecycleVersion"
private const val LifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$LifecycleVersion"
private const val Loader = "androidx.loader:loader:$LoaderVersion"
private const val Media = "androidx.media:media:$MediaVersion"
private const val Media2Player = "androidx.media2:media2-player:$Media2Version"
private const val Media2Session = "androidx.media2:media2-session:$Media2Version"
private const val Media2Widget = "androidx.media2:media2-widget:$Media2Version"
private const val Media3Exoplayer = "androidx.media3:media3-exoplayer:$Media3Version"
private const val Media3ExoplayerDash = "androidx.media3:media3-exoplayer-dash:$Media3Version"
private const val Media3ExoplayerHls = "androidx.media3:media3-exoplayer-hls:$Media3Version"
private const val Media3ExoplayerRtsp = "androidx.media3:media3-exoplayer-rtsp:$Media3Version"
private const val Media3ExoplayerIma = "androidx.media3:media3-exoplayer-ima:$Media3Version"
private const val Media3DatasourceCronet = "androidx.media3:media3-datasource-cronet:$Media3Version"
private const val Media3DatasourceOkhttp = "androidx.media3:media3-datasource-okhttp:$Media3Version"
private const val Media3DatasourceRtmp = "androidx.media3:media3-datasource-rtmp:$Media3Version"
private const val Media3Ui = "androidx.media3:media3-ui:$Media3Version"
private const val Media3UiLeanback = "androidx.media3:media3-ui-leanback:$Media3Version"
private const val Media3Session = "androidx.media3:media3-session:$Media3Version"
private const val Media3Extractor = "androidx.media3:media3-extractor:$Media3Version"
private const val Media3Cast = "androidx.media3:media3-cast:$Media3Version"
private const val Media3ExoplayerWorkmanager = "androidx.media3:media3-exoplayer-workmanager:$Media3Version"
private const val Media3Transformer = "androidx.media3:media3-transformer:$Media3Version"
private const val Media3Utils = "androidx.media3:media3-test-utils:$Media3Version"
private const val Media3UtilsRobolectric = "androidx.media3:media3-test-utils-robolectric:$Media3Version"
private const val Media3Datastore = "androidx.media3:media3-database:$Media3Version"
private const val Media3Decoder = "androidx.media3:media3-decoder:$Media3Version"
private const val Media3Datasource = "androidx.media3:media3-datasource:$Media3Version"
private const val Media3Common = "androidx.media3:media3-common:$Media3Version"
private const val MediaRouter = "androidx.mediarouter:mediarouter:$MediaRouterVersion"
private const val Metrics = "androidx.metrics:metrics-performance:$MetricsVersion"
const val NavigationSafeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$NavigationSafeArgsPluginVersion"
private const val NavigationCompose = "androidx.navigation:navigation-compose:$NavigationComposeVersion"
private const val NavigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:$NavigationVersion"
private const val NavigationFragment = "androidx.navigation:navigation-fragment-ktx:$NavigationVersion"
private const val NavigationTesting = "androidx.navigation:navigation-testing:$NavigationVersion"
private const val NavigationUi = "androidx.navigation:navigation-ui-ktx:$NavigationVersion"
private const val PagingRuntime = "androidx.paging:paging-runtime-ktx:$PagingVersion"
private const val PagingCompose = "androidx.paging:paging-compose:$PagingComposeVersion"
private const val Palette = "androidx.palette:palette-ktx:$PaletteVersion"
private const val Preference = "androidx.preference:preference-ktx:$PreferenceVersion"
private const val Print = "androidx.print:print:$PrintVersion"
private const val ProfileInstaller = "androidx.profileinstaller:profileinstaller:$ProfileInstallerVersion"
private const val Recommendation = "androidx.recommendation:recommendation:$RecommendationVersion"
private const val RecyclerView = "androidx.recyclerview:recyclerview:$RecyclerViewVersion"
private const val RecyclerViewSelection = "androidx.recyclerview:recyclerview-selection:$RecyclerviewSelectionVersion"
private const val RemoteCallback = "androidx.remotecallback:remotecallback:$RemoteCallbackVersion"
private const val RemoteCallbackProcessor = "androidx.remotecallback:remotecallback-processor:$RemoteCallbackVersion"
private const val ResourceInspection = "androidx.resourceinspection:resourceinspection-annotation:$ResourceInspectionVersion"
private const val SavedState = "androidx.savedstate:savedstate-ktx:$SavedStateVersion"
private const val SecurityCrypto = "androidx.security:security-crypto:$SecurityCryptoVersion"
private const val SecurityIdentityCredential = "androidx.security:security-identity-credential:$SecurityIdentityCredentialVersion"
private const val SecurityAppAuthenticator = "androidx.security:security-app-authenticator:$SecurityAppAuthenticatorVersion"
private const val ShareTarget = "androidx.sharetarget:sharetarget:$ShareTargetVersion"
private const val SliceBuilders = "androidx.slice:slice-builders-ktx:$SliceVersion"
private const val SliceCore = "androidx.slice:slice-core:$SliceVersion"
private const val SliceView = "androidx.slice:slice-view:$SliceVersion"
private const val SlidingPanelLayout = "androidx.slidingpanelayout:slidingpanelayout:$SlidingPanelLayoutVersion"
private const val Startup = "androidx.startup:startup-runtime:$StartupVersion"
private const val SwipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:$SwipeRefreshLayoutVersion"
private const val TestCore = "androidx.test:core-ktx:$TestCoreVersion"
private const val TestEspressoAccessibility = "androidx.test.espresso:espresso-accessibility:$TestEspressoVersion"
private const val TestEspressoContrib = "androidx.test.espresso:espresso-contrib:$TestEspressoVersion"
private const val TestEspressoCore = "androidx.test.espresso:espresso-core:$TestEspressoVersion"
private const val TestEspressoIntents = "androidx.test.espresso:espresso-intents:$TestEspressoVersion"
private const val TestExtJunit = "androidx.test.ext:junit-ktx:$TestExtJunitVersion"
private const val TestExtTruth = "androidx.test.ext:truth:$TestExtTruthVersion"
private const val TestOrchestrator = "androidx.test:orchestrator:$TestOrchestratorVersion"
private const val TestRules = "androidx.test:rules:$TestRulesVersion"
private const val AndroidxTestRunner = "androidx.test:runner:$TestRunnerVersion"
private const val TestUiAutomator = "androidx.test.uiautomator:uiautomator:$TestUiAutomatorVersion"
private const val TextClassifier = "androidx.textclassifier:textclassifier:$TextClassifierVersion"
private const val Tracing = "androidx.tracing:tracing-ktx:$TracingVersion"
private const val Transition = "androidx.transition:transition-ktx:$TransitionVersion"
private const val VectorDrawable = "androidx.vectordrawable:vectordrawable:$VectorDrawableVersion"
private const val VectorDrawableAnimated = "androidx.vectordrawable:vectordrawable-animated:$VectorDrawableVersion"
private const val VectorDrawableSeekable = "androidx.vectordrawable:vectordrawable-seekable:$VectorDrawableSeekableVersion"
private const val VersionedParcelable = "androidx.versionedparcelable:versionedparcelable:$VersionedParcelableVersion"
private const val ViewPager2 = "androidx.viewpager2:viewpager2:$ViewPager2Version"
private const val Webkit = "androidx.webkit:webkit:$WebkitVersion"
private const val Window = "androidx.window:window:$WindowVersion"
private const val WindowTesting = "androidx.window:window-testing:$WindowVersion"
private const val WorkRuntime = "androidx.work:work-runtime-ktx:$WorkVersion"
private const val WorkGcm = "androidx.work:work-gcm:$WorkVersion"
private const val WorkMultiprocess = "androidx.work:work-multiprocess:$WorkVersion"
private const val WorkTesting = "androidx.work:work-testing:$WorkVersion"

const val OptExperimentalPagingApi = "-Xopt-in=androidx.paging.ExperimentalPagingApi"

fun DependencyHandler.apiJetpackDependencies() {
    api(Activity)
    api(ActivityCompose)
    api(AppCompat)
    api(Browser)
    api(ConstraintLayoutCompose)
    api(Core)
    api(CoreSplashScreen)
    api(DataStoreCore)
    api(DataStorePreferences)
    api(DataStorePreferencesCore)
    api(Fragment)
    api(HiltNavigationCompose)
    api(HiltNavigationFragment)
    api(HiltWork)
    api(LifecycleCommon)
    api(LifecycleLivedata)
    api(LifecycleRuntime)
    api(LifecycleViewModel)
    api(LifecycleViewModelSavedState)
    api(NavigationCompose)
    api(NavigationDynamic)
    api(NavigationFragment)
    api(NavigationUi)
    api(PagingRuntime)
    api(PagingCompose)
    api(RecyclerView)
    api(ResourceInspection)
    api(Startup)
    api(ViewPager2)
    api(Window)
    api(WindowTesting)
    kapt(LifecycleCommon)
    testApi(TestCore)
    androidTestApi(ArchCoreTesting)
    androidTestApi(NavigationTesting)
    androidTestApi(TestExtJunit)
    androidTestImplementation(TestEspressoCore)
    androidTestApi(TestCore)
    androidTestApi(AndroidxTestRunner)
    androidTestApi(TestExtTruth)
    androidTestApi(TestEspressoAccessibility)
    androidTestApi(TestEspressoContrib)
    androidTestApi(TestEspressoIntents)
    androidTestApi(TestUiAutomator)
    androidTestApi(TestRules)
}

fun DependencyHandler.implementationJetpackTestDependencies() {
    androidTestImplementation(TestCore)
    androidTestImplementation(TestExtJunit)
    androidTestImplementation(TestEspressoCore)
    androidTestImplementation(NavigationTesting)
}