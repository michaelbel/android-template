package org.michaelbel.template.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BootReceiver: BroadcastReceiver() {

    val intentFilter: IntentFilter
        get() = IntentFilter(Intent.ACTION_BOOT_COMPLETED)

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            // do something
        }
    }
}