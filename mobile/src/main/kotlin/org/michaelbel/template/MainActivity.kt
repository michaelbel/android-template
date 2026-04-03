package org.michaelbel.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.medium.MediumApp
import org.michaelbel.template.ui.AppTheme

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = koinViewModel()
            val state by viewModel.stateFlow.collectAsStateWithLifecycle()
            AppTheme(
                dynamicColors = state.dynamicColorsEnabled
            ) {
                //MainActivityContent()
                //CompactApp()
                MediumApp()
            }
        }
    }
}
