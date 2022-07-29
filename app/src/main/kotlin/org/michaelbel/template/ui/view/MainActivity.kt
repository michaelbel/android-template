package org.michaelbel.template.ui.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.databinding.ActivityMainBinding
import org.michaelbel.template.receiver.AirplaneModeReceiver
import org.michaelbel.template.receiver.BatteryReceiver
import org.michaelbel.template.receiver.BootReceiver
import org.michaelbel.template.receiver.CustomReceiver

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    private val customReceiver: CustomReceiver = CustomReceiver()
    private val airplaneModeReceiver: AirplaneModeReceiver = AirplaneModeReceiver()
    private val batteryReceiver: BatteryReceiver = BatteryReceiver()
    private val bootReceiver: BootReceiver = BootReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(org.michaelbel.core.R.style.Theme_App)
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            AndroidViewBinding(ActivityMainBinding::inflate)
        }

        /*fun sendBroadcast() {
            val intent = Intent(CustomReceiver.TEMPLATE_ACTION)
            intent.setPackage("org.michaelbel.template")
            sendBroadcast(intent)
        }*/
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(customReceiver, customReceiver.intentFilter)
        registerReceiver(airplaneModeReceiver, airplaneModeReceiver.intentFilter)
        registerReceiver(batteryReceiver, batteryReceiver.intentFilter)
        registerReceiver(bootReceiver, bootReceiver.intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(batteryReceiver)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(customReceiver)
        unregisterReceiver(airplaneModeReceiver)
        unregisterReceiver(bootReceiver)
    }
}