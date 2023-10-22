package org.michaelbel.template.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.ui.TemplateTheme

@AndroidEntryPoint
class ComposeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(org.michaelbel.core.R.style.Theme_App)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TemplateTheme {
                ComposeActivityContent(
                    onNavigateBack = ::finish
                )
            }
        }
    }
}