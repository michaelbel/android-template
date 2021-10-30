package org.michaelbel.template.features.settingspanel

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver
import com.google.accompanist.insets.WindowInsets
import dagger.hilt.android.AndroidEntryPoint

/**
 * Settings.Global.getString(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON)
 * 0 if false, 1 if true.
 */
@AndroidEntryPoint
class SettingsPanelFragment: Fragment() {

    @RequiresApi(29)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val windowInsets: WindowInsets = ViewWindowInsetObserver(this).start()
        setContent {
            CompositionLocalProvider(LocalWindowInsets provides windowInsets) {
                SettingsPanel(::openSettingsPanel)
            }
        }
    }

    private fun openSettingsPanel(panel: String) {
        startActivity(Intent(panel))
    }
}