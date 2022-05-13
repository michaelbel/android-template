package org.michaelbel.template.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.features.main.ui.MainScreen
import org.michaelbel.template.ui.Screen
import org.michaelbel.template.ui.navigate
import org.michaelbel.template.ui.theme.AppTheme

@AndroidEntryPoint
class MainFragment: Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            AppTheme {
                MainScreen(::onAppUpdateClick, ::navigate)
            }
        }
    }

    private fun onAppUpdateClick() {
        viewModel.startUpdateFlow(requireActivity())
    }

    private fun navigate(to: Screen, args: Bundle) {
        navigate(to, Screen.Main, args)
    }
}