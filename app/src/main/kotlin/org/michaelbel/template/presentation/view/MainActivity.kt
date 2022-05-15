package org.michaelbel.template.presentation.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
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
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AndroidViewBinding(ActivityMainBinding::inflate)
        }
        resolveIntent()

        fun send() {
            val intent = Intent(CustomReceiver.TEMPLATE_ACTION)
            intent.setPackage("org.michaelbel.template")
            sendBroadcast(intent)
        }
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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        resolveIntent()
    }

    private fun resolveIntent() {
        val action: String? = intent?.action
        val data: Uri? = intent?.data

        when (action) {
            Intent.ACTION_MAIN -> {}
            Intent.ACTION_SEND -> {
                when {
                    intent.type == "text/plain" -> {
                        handleSendText(intent)
                    }
                    intent.type?.startsWith("image/") == true -> {
                        handleSendImage(intent)
                    }
                }
            }
            Intent.ACTION_SEND_MULTIPLE -> {
                if (intent.type?.startsWith("image/") == true) {
                    handleSendMultipleImages(intent)
                }
            }
            Intent.ACTION_VIEW -> {

            }
            else -> {
                // Handle other intents, such as being started from the home screen
            }
        }
    }

    private fun handleSendMultipleImages(intent: Intent) {
        intent.getParcelableArrayListExtra<Parcelable>(Intent.EXTRA_STREAM)?.let {
            // Update UI to reflect multiple images being shared
        }
    }

    private fun handleSendImage(intent: Intent) {
        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
            // Update UI to reflect image being shared
        }
    }

    private fun handleSendText(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            // Update UI to reflect text being shared
            Toast.makeText(this, "text = $it", Toast.LENGTH_LONG).show()
        }
    }
}