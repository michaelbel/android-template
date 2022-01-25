package org.michaelbel.template

/**
 * Android Wear
 * Build apps for the wrist with Wear OS
 *
 * https://wearos.google.com
 * https://d.android.com/wear
 *
 * https://d.android.com/jetpack/androidx/releases/wear
 * https://d.android.com/jetpack/androidx/releases/wear-compose
 * https://d.android.com/jetpack/androidx/releases/wear-tiles
 * https://d.android.com/jetpack/androidx/releases/wear-watchface
 */
object AndroidWear {
    private const val WearVersion = "1.2.0"
    private const val WearInputVersion = "1.1.0"
    private const val WearOngoingVersion = "1.0.0"
    private const val WearPhoneInteractionsVersion = "1.0.1"
    private const val WearRemoteInteractionsVersion = "1.0.0"
    private const val WearComposeVersion = "1.0.0-alpha14"
    private const val WearTilesVersion = "1.0.0"
    private const val WearWatchfaceVersion = "1.1.0-alpha02"

    const val Wear = "androidx.wear:wear:$WearVersion"
    const val WearInput = "androidx.wear:wear-input:$WearInputVersion"
    const val WearInputTesting = "androidx.wear:wear-input-testing:$WearInputVersion"
    const val WearOngoing = "androidx.wear:wear-ongoing:$WearOngoingVersion"
    const val WearPhoneInteractions = "androidx.wear:wear-phone-interactions:$WearPhoneInteractionsVersion"
    const val WearRemoteInteractions = "androidx.wear:wear-remote-interactions:$WearRemoteInteractionsVersion"
    const val WearComposeFoundation = "androidx.wear.compose:compose-foundation:$WearComposeVersion"
    const val WearComposeMaterial = "androidx.wear.compose:compose-material:$WearComposeVersion"
    const val WearComposeNavigation = "androidx.wear.compose:compose-navigation:$WearComposeVersion"
    const val WearTiles = "androidx.wear.tiles:tiles:$WearTilesVersion"
    const val WearTilesRenderer = "androidx.wear.tiles:tiles-renderer:$WearTilesVersion"
    const val WearTilesTesting = "androidx.wear.tiles:tiles-testing:$WearTilesVersion"
    const val WearWatchface = "androidx.wear.watchface:watchface:$WearWatchfaceVersion"
    const val WearWatchfaceComplications = "androidx.wear.watchface:watchface-complications-data-source-ktx:$WearWatchfaceVersion"
    const val WearWatchfaceEditor = "androidx.wear.watchface:watchface-editor:$WearWatchfaceVersion"
}