package org.michaelbel.template

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.michaelbel.template.ui.AppTheme
import org.michaelbel.template.ui.MainActivityContent

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Отключить для десктопа
        setContent {
            AppTheme {
                MainActivityContent()
            }
        }
    }
}