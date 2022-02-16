package org.michaelbel.template

/**
 * Firebase
 *
 * @property FirebaseAbt — https://mvnrepository.com/artifact/com.google.firebase/firebase-abt
 * @property FirebaseAnalytics — https://mvnrepository.com/artifact/com.google.firebase/firebase-analytics-ktx
 * @property FirebaseAppDistributionPlugin — https://firebase.google.com/docs/app-distribution/android/distribute-gradle
 * @property FirebaseCore — https://mvnrepository.com/artifact/com.google.firebase/firebase-core
 * @property FirebaseCrashlytics — https://mvnrepository.com/artifact/com.google.firebase/firebase-crashlytics-ktx
 * @property FirebaseCommon —
 * @property FirebaseConfig — https://mvnrepository.com/artifact/com.google.firebase/firebase-config
 */
object Firebase {
    private const val FirebaseAbtVersion = "21.0.0"
    private const val FirebaseAnalyticsVersion = "20.0.2"
    private const val FirebaseAppDistributionVersion = "3.0.0"
    private const val FirebaseCommonVersion = "20.0.0"
    private const val FirebaseConfigVersion = "21.0.1"
    private const val FirebaseCoreVersion = "20.0.2"
    private const val FirebaseCrashlyticsPluginVersion = "2.8.1"
    private const val FirebaseCrashlyticsVersion = "18.2.6"

    const val FirebaseAppDistributionPlugin = "com.google.firebase:firebase-appdistribution-gradle:$FirebaseAppDistributionVersion"
    const val FirebaseCrashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:$FirebaseCrashlyticsPluginVersion"

    const val FirebaseAbt = "com.google.firebase:firebase-abt:$FirebaseAbtVersion"
    const val FirebaseAnalytics = "com.google.firebase:firebase-analytics-ktx:$FirebaseAnalyticsVersion"
    const val FirebaseCommon = "com.google.firebase:firebase-common-ktx:$FirebaseCommonVersion"
    const val FirebaseConfig = "com.google.firebase:firebase-config-ktx:$FirebaseConfigVersion"
    const val FirebaseCore = "com.google.firebase:firebase-core:$FirebaseCoreVersion"
    const val FirebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx:$FirebaseCrashlyticsVersion"

    const val MobileSdkAppId = "1:770317857182:android:876190afbc53df31"
    const val ArtifactType = "APK"
    const val Testers = "michaelbel24865@gmail.com"
    const val Groups = "qa"
    const val ReleaseNotes = "Release ${App.VersionName}"
}