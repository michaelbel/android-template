package org.michaelbel.template

/**
 * Firebase
 *
 * @property Abt — https://mvnrepository.com/artifact/com.google.firebase/firebase-abt
 * @property Analytics — https://mvnrepository.com/artifact/com.google.firebase/firebase-analytics-ktx
 * @property AppDistribution — https://firebase.google.com/docs/app-distribution/android/distribute-gradle
 * @property Core — https://mvnrepository.com/artifact/com.google.firebase/firebase-core
 * @property Crashlytics — https://mvnrepository.com/artifact/com.google.firebase/firebase-crashlytics-ktx
 * @property Common —
 * @property Config — https://mvnrepository.com/artifact/com.google.firebase/firebase-config
 */
object Firebase {
    private const val AbtVersion = "21.0.0"
    private const val AnalyticsVersion = "20.0.2"
    private const val AppDistributionVersion = "3.0.0"
    private const val CommonVersion = "20.0.0"
    private const val ConfigVersion = "21.0.1"
    private const val CoreVersion = "20.0.2"
    private const val CrashlyticsPluginVersion = "2.8.1"
    private const val CrashlyticsVersion = "18.2.6"

    const val Abt = "com.google.firebase:firebase-abt:$AbtVersion"
    const val Analytics = "com.google.firebase:firebase-analytics-ktx:$AnalyticsVersion"
    const val AppDistribution = "com.google.firebase:firebase-appdistribution-gradle:$AppDistributionVersion"
    const val Common = "com.google.firebase:firebase-common-ktx:$CommonVersion"
    const val Config = "com.google.firebase:firebase-config-ktx:$ConfigVersion"
    const val Core = "com.google.firebase:firebase-core:$CoreVersion"
    const val CrashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:$CrashlyticsPluginVersion"
    const val Crashlytics = "com.google.firebase:firebase-crashlytics-ktx:$CrashlyticsVersion"

    const val MobileSdkAppId = "1:770317857182:android:876190afbc53df31"
    const val ArtifactType = "APK"
    const val Testers = "michaelbel24865@gmail.com"
    const val Groups = "qa"
    const val ReleaseNotes = "Release ${App.VersionName} (${App.VersionCode})"
}