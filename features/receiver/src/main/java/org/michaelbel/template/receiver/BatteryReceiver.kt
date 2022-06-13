package org.michaelbel.template.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BatteryReceiver: BroadcastReceiver() {

    val intentFilter: IntentFilter
        get() {
            val intentFilter = IntentFilter(Intent.ACTION_POWER_CONNECTED)
            intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
            intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
            intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
            intentFilter.addAction(Intent.ACTION_BATTERY_OKAY)
            return intentFilter
        }

    override fun onReceive(context: Context?, intent: Intent?) {
        val level: Int = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale: Int = intent?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1
        val percent: Float = level * 100 / scale.toFloat()
        when {
            intent?.action.equals(Intent.ACTION_BATTERY_LOW) -> {}
            intent?.action.equals(Intent.ACTION_BATTERY_OKAY) -> {}
            intent?.action.equals(Intent.ACTION_BATTERY_CHANGED) -> {}
            intent?.action.equals(Intent.ACTION_POWER_CONNECTED) -> {}
            intent?.action.equals(Intent.ACTION_POWER_DISCONNECTED) -> {}
            else -> {}
        }
    }
}