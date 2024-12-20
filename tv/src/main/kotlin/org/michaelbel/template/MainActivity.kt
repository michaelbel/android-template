package org.michaelbel.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.tv.material3.Surface
import org.michaelbel.template.ui.AppTheme
import org.michaelbel.template.ui.MainActivityContent

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RectangleShape
            ) {
                AppTheme {
                    MainActivityContent()
                }
            }
        }
    }
}