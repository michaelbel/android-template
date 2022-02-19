@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template

/**
 * Google Play services
 *
 * @see <a href="https://developers.google.com/android/guides/setup">Set up Google Play services</a>
 *
 *
 * Material — https://github.com/material-components/material-components-android/releases
 * PlayCore — https://d.android.com/reference/com/google/android/play/core/release-notes
 * Hilt — https://github.com/google/dagger/releases
 */
object Google {
    private const val MaterialVersion = "1.6.0-alpha02"
    private const val MaterialComposeThemeAdapterVersion = "1.1.3"
    private const val PlayCoreVersion = "1.8.1"
    private const val DaggerVersion = "2.40.5"

    private const val GoogleServicesPluginVersion = "4.3.10"
    private const val OssLicensesPluginVersion = "0.10.4"
    private const val StrictPluginVersion = "1.2.2"

    private const val GmsAds = "20.5.0"
    private const val GmsAdsIdentifier = "18.0.1"
    private const val GmsAdsLite = "20.5.0"
    private const val GmsAfsNative = "19.0.3"
    private const val GmsAnalytics = "18.0.1"
    private const val GmsAppset = "16.0.2"
    private const val GmsAuth = "20.0.1"
    private const val GmsAuthApiPhone = "18.0.1"
    private const val GmsAuthBlockstore = "16.1.0"
    private const val GmsAwareness = "19.0.1"
    private const val GmsBase = "18.0.1"
    private const val GmsBasement = "18.0.0"
    private const val GmsCast = "21.0.1"
    private const val GmsCastFramework = "21.0.1"
    private const val GmsCronet = "18.0.1"
    private const val GmsFido = "19.0.0-beta"
    private const val GmsFitness = "21.0.1"
    private const val GmsGames = "22.0.1"
    private const val GmsInstantapps = "18.0.1"
    private const val GmsLocation = "19.0.1"
    private const val GmsMaps = "18.0.2"
    private const val GmsMlkitBarcodeScanning = "17.0.0"
    private const val GmsMlkitFaceDetection = "16.2.1"
    private const val GmsMlkitImageLabeling = "16.0.6"
    private const val GmsMlkitImageLabelingCustom = "16.0.0-beta2"
    private const val GmsMlkitLanguageId = "16.0.0-beta2"
    private const val GmsMlkitTextRecognition = "17.0.1"
    private const val GmsNearby = "18.0.2"
    private const val GmsOssLicenses = "17.0.0"
    private const val GmsPasswordComplexity = "18.0.1"
    private const val GmsPay = "16.0.3"
    private const val GmsRecaptcha = "17.0.1"
    private const val GmsSafetynet = "18.0.1"
    private const val GmsTagManager = "18.0.1"
    private const val GmsTasks = "18.0.1"
    private const val GmsVision = "20.1.3"
    private const val GmsWallet = "19.1.0"
    private const val GmsWearable = "17.1.0"

    const val Material = "com.google.android.material:material:$MaterialVersion"
    const val MaterialComposeThemeAdapter = "com.google.android.material:compose-theme-adapter:$MaterialComposeThemeAdapterVersion"
    const val PlayCore = "com.google.android.play:core-ktx:$PlayCoreVersion"
    const val HiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$DaggerVersion"
    const val HiltAndroid = "com.google.dagger:hilt-android:$DaggerVersion"
    const val HiltCompiler = "com.google.dagger:hilt-compiler:$DaggerVersion"

    const val GoogleServicesPlugin = "com.google.gms:google-services:$GoogleServicesPluginVersion"
    const val OssLicensesPlugin = "com.google.android.gms:oss-licenses-plugin:$OssLicensesPluginVersion"
    const val StrictPlugin = "com.google.android.gms:strict-version-matcher-plugin:$StrictPluginVersion"

    const val Ads = "com.google.android.gms:play-services-ads:$GmsAds"
    const val AdsIdentifier = "com.google.android.gms:play-services-ads-identifier:$GmsAdsIdentifier"
    const val AdsLite = "com.google.android.gms:play-services-ads-lite:$GmsAdsLite"
    const val AfsNative = "com.google.android.gms:play-services-afs-native:$GmsAfsNative"
    const val Analytics = "com.google.android.gms:play-services-analytics:$GmsAnalytics"
    const val Appset = "com.google.android.gms:play-services-appset:$GmsAppset"
    const val Auth = "com.google.android.gms:play-services-auth:$GmsAuth"
    const val AuthApiPhone = "com.google.android.gms:play-services-auth-api-phone:$GmsAuthApiPhone"
    const val AuthBlockstore = "com.google.android.gms:play-services-auth-blockstore:$GmsAuthBlockstore"
    const val Awareness = "com.google.android.gms:play-services-awareness:$GmsAwareness"
    const val Base = "com.google.android.gms:play-services-base:$GmsBase"
    const val Basement = "com.google.android.gms:play-services-basement:$GmsBasement"
    const val Cast = "com.google.android.gms:play-services-cast:$GmsCast"
    const val CastFramework = "com.google.android.gms:play-services-cast-framework:$GmsCastFramework"
    const val Cronet = "com.google.android.gms:play-services-cronet:$GmsCronet"
    const val Fido = "com.google.android.gms:play-services-fido:$GmsFido"
    const val Fitness = "com.google.android.gms:play-services-fitness:$GmsFitness"
    const val Games = "com.google.android.gms:play-services-games:$GmsGames"
    const val InstantApps = "com.google.android.gms:play-services-instantapps:$GmsInstantapps"
    const val Location = "com.google.android.gms:play-services-location:$GmsLocation"
    const val Maps = "com.google.android.gms:play-services-maps:$GmsMaps"
    const val MlkitBarcodeScanning = "com.google.android.gms:play-services-mlkit-barcode-scanning:$GmsMlkitBarcodeScanning"
    const val MlkitFaceDetection = "com.google.android.gms:play-services-mlkit-face-detection:$GmsMlkitFaceDetection"
    const val MlkitImageLabelling = "com.google.android.gms:play-services-mlkit-image-labeling:$GmsMlkitImageLabeling"
    const val MlkitImageLabellingCustom = "com.google.android.gms:play-services-mlkit-image-labeling-custom:$GmsMlkitImageLabelingCustom"
    const val MlkitLanguageId = "com.google.android.gms:play-services-mlkit-language-id:$GmsMlkitLanguageId"
    const val MlkitTextRecognition = "com.google.android.gms:play-services-mlkit-text-recognition:$GmsMlkitTextRecognition"
    const val Nearby = "com.google.android.gms:play-services-nearby:$GmsNearby"
    const val OssLicenses = "com.google.android.gms:play-services-oss-licenses:$GmsOssLicenses"
    const val PasswordComplexity = "com.google.android.gms:play-services-password-complexity:$GmsPasswordComplexity"
    const val Pay = "com.google.android.gms:play-services-pay:$GmsPay"
    const val Recaptcha = "com.google.android.gms:play-services-recaptcha:$GmsRecaptcha"
    const val Safetynet = "com.google.android.gms:play-services-safetynet:$GmsSafetynet"
    const val Tagmanager = "com.google.android.gms:play-services-tagmanager:$GmsTagManager"
    const val Tasks = "com.google.android.gms:play-services-tasks:$GmsTasks"
    const val Vision = "com.google.android.gms:play-services-vision:$GmsVision"
    const val Wallet = "com.google.android.gms:play-services-wallet:$GmsWallet"
    const val Wearable = "com.google.android.gms:play-services-wearable:$GmsWearable"
}

object Options {
    const val OptExperimentalMaterial3Api = "-Xopt-in=androidx.compose.material3.ExperimentalMaterial3Api"
    const val OptExperimentalFoundationApi = "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi"
    const val OptExperimentalPagingApi = "-Xopt-in=androidx.paging.ExperimentalPagingApi"
    const val OptExperimentalComposeUiApi = "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi"
    const val OptExperimentalMaterialApi = "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi"
}