package org.michaelbel.template

/**
 * Android TV
 * Build apps that let users experience your app's immersive content on the big screen.
 * Users can discover your content recommendations on the home screen, and the leanback
 * library provides APIs to help you build a great use experience for a remote control.
 *
 * https://android.com/tv
 * https://d.android.com/tv
 *
 * https://d.android.com/jetpack/androidx/releases/leanback
 */
object AndroidTv {
    private const val LeanbackVersion = "1.2.0-alpha02"
    private const val LeanbackPagingVersion = "1.1.0-alpha09"
    private const val LeanbackTabVersion = "1.1.0-beta01"
    private const val LeanbackGridVersion = "1.0.0-alpha01"

    const val Leanback = "androidx.leanback:leanback:$LeanbackVersion"
    const val LeanbackPreference = "androidx.leanback:leanback-preference:$LeanbackVersion"
    const val LeanbackPaging = "androidx.leanback:leanback-paging:$LeanbackPagingVersion"
    const val LeanbackTab = "androidx.leanback:leanback-tab:$LeanbackTabVersion"
    const val LeanbackGrid = "androidx.leanback:leanback-grid:$LeanbackGridVersion"
}