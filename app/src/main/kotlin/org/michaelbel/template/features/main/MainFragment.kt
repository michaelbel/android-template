package org.michaelbel.template.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.LocalBackPressedDispatcher
import org.michaelbel.template.Screen
import org.michaelbel.template.features.main.ui.MainScreen
import org.michaelbel.template.navigate
import org.michaelbel.template.ui.theme.AppTheme

@AndroidEntryPoint
class MainFragment: Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val windowInsets = ViewWindowInsetObserver(this)
            .start(windowInsetsAnimationsEnabled = true)
        setContent {
            CompositionLocalProvider(
                LocalBackPressedDispatcher provides requireActivity().onBackPressedDispatcher,
                LocalWindowInsets provides windowInsets,
            ) {
                AppTheme {
                    MainScreen(::onAppUpdateClick, ::navigate)
                }
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