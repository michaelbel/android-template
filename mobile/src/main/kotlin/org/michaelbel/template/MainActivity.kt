package org.michaelbel.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.step1_Scaffold_BottomBar.Step1App
import org.michaelbel.template.step2_NavigationSuiteScaffold_BottomBar.Step2App
import org.michaelbel.template.step3_NavigationSuiteScaffold_BottomBar.Step3App
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
                val index = 2
                when (index) {
                    0 -> Step1App()
                    1 -> Step2App()
                    2 -> Step3App()
                }
            }
        }
    }
}
