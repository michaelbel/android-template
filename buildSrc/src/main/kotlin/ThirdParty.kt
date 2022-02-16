package org.michaelbel.template

/**
 * Third-party Dependencies
 *
 * Material — https://github.com/material-components/material-components-android/releases
 * PlayCore — https://d.android.com/reference/com/google/android/play/core/release-notes
 * Hilt — https://github.com/google/dagger/releases
 * Coil — https://github.com/coil-kt/coil/releases
 * Timber — https://github.com/JakeWharton/timber/releases
 * Gander — https://github.com/Ashok-Varma/Gander/releases
 * Retrofit — https://github.com/square/retrofit
 * Converter Serialization — https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter
 * Facebook - https://github.com/facebook/facebook-android-sdk
 * VK - https://github.com/VKCOM/vk-android-sdk
 *
 * @see [ViewBindingPropertyDelegate](https://github.com/androidbroadcast/ViewBindingPropertyDelegate)
 * @see [StrictMode](https://github.com/androidbroadcast/StrictModeCompat)
 * @see [NotificationDsl](https://github.com/androidbroadcast/Android-Notification-DSL)
 */
object ThirdParty {
    private const val MaterialVersion = "1.6.0-alpha02"
    private const val MaterialComposeThemeAdapterVersion = "1.1.3"
    private const val PlayCoreVersion = "1.8.1"
    private const val DaggerVersion = "2.40.5"
    private const val CoilVersion = "1.4.0"
    private const val TimberVersion = "5.0.1"
    private const val GanderVersion = "3.1.0"
    private const val RetrofitVersion = "2.9.0"
    private const val RetrofitConverterSerializationVersion = "0.8.0"
    private const val FacebookLoginVersion = "12.3.0"
    private const val VKVersion = "3.5.0"
    private const val ViewBindingPropertyDelegateVersion = "1.5.6"
    private const val StrictModeVersion = "30.2.0"
    private const val NotificationsDslVersion = "0.2.1"

    const val Material = "com.google.android.material:material:$MaterialVersion"
    const val MaterialComposeThemeAdapter = "com.google.android.material:compose-theme-adapter:$MaterialComposeThemeAdapterVersion"
    const val PlayCore = "com.google.android.play:core-ktx:$PlayCoreVersion"
    const val HiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$DaggerVersion"
    const val HiltAndroid = "com.google.dagger:hilt-android:$DaggerVersion"
    const val HiltCompiler = "com.google.dagger:hilt-compiler:$DaggerVersion"
    const val Coil = "io.coil-kt:coil:$CoilVersion"
    const val CoilCompose = "io.coil-kt:coil-compose:$CoilVersion"
    const val Timber = "com.jakewharton.timber:timber:$TimberVersion"
    const val GanderImdb = "com.ashokvarma.android:gander-imdb:$GanderVersion"
    const val GanderPersistence = "com.ashokvarma.android:gander-persistence:$GanderVersion"
    const val Retrofit = "com.squareup.retrofit2:retrofit:$RetrofitVersion"
    const val RetrofitConverterGson = "com.squareup.retrofit2:converter-gson:$RetrofitVersion"
    const val RetrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:$RetrofitVersion"
    const val RetrofitConverterSerialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$RetrofitConverterSerializationVersion"
    const val FacebookLogin = "com.facebook.android:facebook-login:$FacebookLoginVersion"
    const val VK = "com.vk:android-sdk-core:$VKVersion"
    const val ViewBindingPropertyDelegate = "com.github.kirich1409:viewbindingpropertydelegate:$ViewBindingPropertyDelegateVersion"
    const val StrictMode = "com.github.kirich1409:strict-mode-compat-ktx:$StrictModeVersion"
    const val NotificationsDslCore = "com.github.kirich1409:android-notification-dsl-core:$NotificationsDslVersion"
    const val NotificationsDslExtensions = "com.github.kirich1409:android-notification-dsl-extensions:$NotificationsDslVersion"
    const val NotificationsDslMedia = "com.github.kirich1409:android-notification-dsl-media:$NotificationsDslVersion"
}