package org.michaelbel.template.ui.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.databinding.ActivityViewBinding

@AndroidEntryPoint
class ViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(org.michaelbel.core.R.style.Theme_App)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AndroidViewBinding(ActivityViewBinding::inflate)
        }
    }
}