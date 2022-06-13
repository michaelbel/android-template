package org.michaelbel.template.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.provider.Settings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AirplaneModeReceiver: BroadcastReceiver() {

    val intentFilter: IntentFilter
        get() = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            val isEnabled: Boolean = Settings.System.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON, 0
            ) != 0
        }
    }
}