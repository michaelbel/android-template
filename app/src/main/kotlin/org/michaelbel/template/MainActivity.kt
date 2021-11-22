package org.michaelbel.template

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        resolveIntent()
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