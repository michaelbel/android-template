@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.androidTestApi
import org.michaelbel.template.extensions.androidTestImplementation
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.testApi

/**
 * Jetpack & AndroidX
 *
 * @see <a href="https://d.android.com/jetpack/androidx/releases">AndroidX releases</a>
 */

private const val BrowserVersion = "1.4.0"

private const val CameraVersion = "1.0.2"
private const val CameraVideoVersion = "1.1.0-alpha12"
private const val CameraViewVersion = "1.0.0-alpha32"
private const val CameraExtensionsVersion = "1.0.0-alpha32"

private const val CardViewVersion = "1.0.0"

private const val CollectionVersion = "1.2.0"

private const val ConstraintLayoutVersion = "2.1.3"
private const val ConstraintLayoutComposeVersion = "1.0.0"

private const val CoordinatorLayoutVersion = "1.2.0"

private const val CoreVersion = "1.7.0"
private const val CoreAnimationVersion = "1.0.0-alpha02"
private const val CoreGoogleShortcutsVersion = "1.0.0"
private const val CoreRemoteViewsVersion = "1.0.0-alpha01"
private const val CoreRoleVersion = "1.0.0"
private const val CoreSplashScreenVersion = "1.0.0-beta01"

private const val DrawerLayoutVersion = "1.1.1"

private const val DynamicAnimationVersion = "1.1.0-alpha03"

private const val EmojiVersion = "1.1.0"
private const val Emoji2Version = "1.1.0"

private const val ExifinterfaceVersion = "1.3.3"

private const val GlanceVersion = "1.0.0-alpha01"

private const val GridLayoutVersion = "1.0.0"

private const val MediaVersion = "1.4.3"
private const val Media2Version = "1.2.0"
private const val Media3Version = "1.0.0-alpha01"

private const val PaletteVersion = "1.0.0"

private const val PreferenceVersion = "1.1.1"

private const val RecyclerViewVersion = "1.2.1"
private const val RecyclerviewSelectionVersion = "1.1.0"

private const val SliceVersion = "1.1.0-alpha02"

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

private const val VectorDrawableVersion = "1.1.0"
private const val VectorDrawableSeekableVersion = "1.0.0-alpha02"

private const val ViewPager2Version = "1.0.0"

private const val WebkitVersion = "1.4.0"

private const val WindowVersion = "1.0.0-rc01"

private const val Browser = "androidx.browser:browser:$BrowserVersion"
private const val CameraCore = "androidx.camera:camera-core:$CameraVersion"
private const val CameraCamera2 = "androidx.camera:camera-camera2:$CameraVersion"
private const val CameraLifecycle = "androidx.camera:camera-lifecycle:$CameraVersion"
private const val CameraVideo = "androidx.camera:camera-video:$CameraVideoVersion"
private const val CameraView = "androidx.camera:camera-view:$CameraViewVersion"
private const val CameraExtensions = "androidx.camera:camera-extensions:$CameraExtensionsVersion"
private const val CardView = "androidx.cardview:cardview:$CardViewVersion"
private const val Collection = "androidx.collection:collection-ktx:$CollectionVersion"
private const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:$ConstraintLayoutVersion"
private const val ConstraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:$ConstraintLayoutComposeVersion"
private const val CoordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:$CoordinatorLayoutVersion"
private const val Core = "androidx.core:core-ktx:$CoreVersion"
private const val CoreAnimation = "androidx.core:core-animation:$CoreAnimationVersion"
private const val CoreAnimationTesting = "androidx.core:core-animation-testing:$CoreAnimationVersion"
private const val CoreGoogleShortcuts = "androidx.core:core-google-shortcuts:$CoreGoogleShortcutsVersion"
private const val CoreRemoteViews = "androidx.core:core-remoteviews:$CoreRemoteViewsVersion"
private const val CoreRole = "androidx.core:core-role:$CoreRoleVersion"
private const val CoreSplashScreen = "androidx.core:core-splashscreen:$CoreSplashScreenVersion"
private const val DrawerLayout = "androidx.drawerlayout:drawerlayout:$DrawerLayoutVersion"
private const val DynamicAnimation = "androidx.dynamicanimation:dynamicanimation-ktx:$DynamicAnimationVersion"
private const val Emoji = "androidx.emoji:emoji:$EmojiVersion"
private const val EmojiAppcompat = "androidx.emoji:emoji-appcompat:$EmojiVersion"
private const val EmojiBundled = "androidx.emoji:emoji-bundled:$EmojiVersion"
private const val Emoji2 = "androidx.emoji2:emoji2:$Emoji2Version"
private const val Emoji2Views = "androidx.emoji2:emoji2-views:$Emoji2Version"
private const val Emoji2ViewsHelper = "androidx.emoji2:emoji2-views-helper:$Emoji2Version"
private const val Exifinterface = "androidx.exifinterface:exifinterface:$ExifinterfaceVersion"
private const val Glance = "androidx.glance:glance:$GlanceVersion"
private const val GlanceAppWidget = "androidx.glance:glance-appwidget:$GlanceVersion"
private const val GridLayout = "androidx.gridlayout:gridlayout:$GridLayoutVersion"
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
private const val Palette = "androidx.palette:palette-ktx:$PaletteVersion"
private const val Preference = "androidx.preference:preference-ktx:$PreferenceVersion"
private const val RecyclerView = "androidx.recyclerview:recyclerview:$RecyclerViewVersion"
private const val RecyclerViewSelection = "androidx.recyclerview:recyclerview-selection:$RecyclerviewSelectionVersion"
private const val SliceBuilders = "androidx.slice:slice-builders-ktx:$SliceVersion"
private const val SliceCore = "androidx.slice:slice-core:$SliceVersion"
private const val SliceView = "androidx.slice:slice-view:$SliceVersion"
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
private const val VectorDrawable = "androidx.vectordrawable:vectordrawable:$VectorDrawableVersion"
private const val VectorDrawableAnimated = "androidx.vectordrawable:vectordrawable-animated:$VectorDrawableVersion"
private const val VectorDrawableSeekable = "androidx.vectordrawable:vectordrawable-seekable:$VectorDrawableSeekableVersion"
private const val ViewPager2 = "androidx.viewpager2:viewpager2:$ViewPager2Version"
private const val Webkit = "androidx.webkit:webkit:$WebkitVersion"
private const val Window = "androidx.window:window:$WindowVersion"
private const val WindowTesting = "androidx.window:window-testing:$WindowVersion"

fun DependencyHandler.apiJetpackDependencies() {
    api(Browser)
    api(ConstraintLayoutCompose)
    api(Core)
    api(CoreSplashScreen)
    api(RecyclerView)
    api(ViewPager2)
    api(Window)
    api(WindowTesting)
    testApi(TestCore)
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
}