package org.michaelbel.core.system

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.net.NetworkRequest
import android.os.BatteryManager
import android.os.Build
import javax.inject.Inject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class Connectivity @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val bluetoothManager: BluetoothManager,
    private val batteryManager: BatteryManager
) {

    val isOnline: Boolean
        get() {
            return if (Build.VERSION.SDK_INT >= 23) {
                val networkCapabilities: NetworkCapabilities = connectivityManager.getNetworkCapabilities(
                    connectivityManager.activeNetwork
                ) ?: return false

                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                        networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            } else {
                @Suppress("Deprecation")
                connectivityManager.activeNetworkInfo?.isConnected ?: false
            }
        }

    val isConnectedWifi: Boolean
        get() {
            @Suppress("Deprecation")
            return if (Build.VERSION.SDK_INT >= 29) {
                val networkCapabilities: NetworkCapabilities = connectivityManager.getNetworkCapabilities(
                    connectivityManager.activeNetwork
                ) ?: return false
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            } else {
                val networkInfo: NetworkInfo? = connectivityManager.getNetworkInfo(
                    ConnectivityManager.TYPE_WIFI
                )
                networkInfo?.isConnected ?: false
            }
        }

    val status: Flow<NetworkStatus> = callbackFlow {
        val networkCallback = object: ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(NetworkStatus.Available)
            }

            override fun onLost(network: Network) {
                trySend(NetworkStatus.Unavailable)
            }

            override fun onUnavailable() {
                trySend(NetworkStatus.Unavailable)
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(request, networkCallback)

        awaitClose {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }

    val isBluetoothEnabled: Boolean
        get() {
            val bluetoothAdapter: BluetoothAdapter = bluetoothManager.adapter
            return bluetoothAdapter.isEnabled
        }

    val isBatteryCharging: Boolean
        get() {
            return if (Build.VERSION.SDK_INT >= 23) {
                batteryManager.isCharging
            } else {
                false
            }
        }

    val batteryLevel: Int
        get() = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
}