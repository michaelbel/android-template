package org.michaelbel.template.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.ui.AppTheme
import org.michaelbel.template.ui.view.ui.MainScreen

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