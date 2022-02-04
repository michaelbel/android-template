package org.michaelbel.template

/**
 * Android for Cars
 * Develop driving-friendly applications for an Android-powered car.
 *
 * https://android.com/auto
 * https://d.android.com/cars
 *
 * https://d.android.com/jetpack/androidx/releases/car
 * https://d.android.com/jetpack/androidx/releases/car-app
 */
object AndroidAuto {
    private const val CarVersion = "1.0.0"
    private const val CarAppVersion = "1.1.0"
    private const val CarAppTestingVersion = "1.2.0-alpha02"

    const val Car = "androidx.car:car:$CarVersion"
    const val CarApp = "androidx.car.app:app:$CarAppVersion"
    const val CarAppTesting = "androidx.car.app:app-testing:$CarAppTestingVersion"
}