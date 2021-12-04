package org.michaelbel.template.features.settingspanel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.features.settingspanel.ui.SettingsPanelScreen

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
        setContent {
            ProvideWindowInsets {
                SettingsPanelScreen(::onNavigationBackClick)
            }
        }
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }
}