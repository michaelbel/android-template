package org.michaelbel.template

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.core.app.NotificationManagerCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

@Suppress("DEPRECATION")
fun Context.checkIfOnline(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return if (Build.VERSION.SDK_INT >= 23) {
        val capabilities = cm.getNetworkCapabilities(cm.activeNetwork) ?: return false

        capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    } else {
        cm.activeNetworkInfo?.isConnectedOrConnecting == true
    }
}

fun Context.playServicesAvailable(): Boolean {
    val googleApiAvailability = GoogleApiAvailability.getInstance()
    val status = googleApiAvailability.isGooglePlayServicesAvailable(this)
    return status == ConnectionResult.SUCCESS
}

fun Context.areNotificationsEnabled(): Boolean {
    return NotificationManagerCompat.from(this).areNotificationsEnabled()
}