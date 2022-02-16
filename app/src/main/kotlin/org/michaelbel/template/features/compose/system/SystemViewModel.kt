package org.michaelbel.template.features.compose.system

import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import org.michaelbel.core.googleapi.GoogleApi
import org.michaelbel.core.system.Connectivity

@HiltViewModel
class SystemViewModel @Inject constructor(
    private val vibrator: Vibrator,
    googleApi: GoogleApi,
    connectivity: Connectivity
): ViewModel() {

    var isPlayAvailable: Boolean by mutableStateOf(googleApi.isPlayServicesAvailable)
    var isOnline: Boolean by mutableStateOf(connectivity.isOnline)
    var isConnectedWifi: Boolean by mutableStateOf(connectivity.isConnectedWifi)
    var isBluetoothEnabled: Boolean by mutableStateOf(connectivity.isBluetoothEnabled)
    var isBatteryCharging: Boolean by mutableStateOf(connectivity.isBatteryCharging)
    var batteryLevel: Int by mutableStateOf(connectivity.batteryLevel)

    fun vibrate() {
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(150L, 10))
        } else {
            @Suppress("Deprecation")
            vibrator.vibrate(150L)
        }
    }
}