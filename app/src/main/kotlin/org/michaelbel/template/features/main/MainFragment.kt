package org.michaelbel.template.features.main

import android.content.Intent
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
import com.google.accompanist.insets.WindowInsets
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.ComposeActivity
import org.michaelbel.template.Screen
import org.michaelbel.template.navigate

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
        val windowInsets: WindowInsets = ViewWindowInsetObserver(this).start()
        setContent {
            CompositionLocalProvider(LocalWindowInsets provides windowInsets) {
                Main(
                    onUpdateAppClicked = { onAppUpdateClick() },
                    onButtonClick = { to: Screen, args: Bundle -> navigate(to, Screen.Main, args) },
                    onFabClick = { startComposeActivity() }
                )
            }
        }
    }

    private fun onAppUpdateClick() {
        viewModel.startUpdateFlow(requireActivity())
    }

    private fun startComposeActivity() {
        startActivity(Intent(requireActivity(), ComposeActivity::class.java))
    }
}