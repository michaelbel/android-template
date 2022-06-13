package org.michaelbel.template.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomReceiver: BroadcastReceiver() {

    val intentFilter: IntentFilter
        get() = IntentFilter(TEMPLATE_ACTION)

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(TEMPLATE_ACTION)) {

        }
    }

    companion object {
        const val TEMPLATE_ACTION = "org.michaelbel.template.action.CUSTOM"
    }
}