package org.michaelbel.template.features.clipboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.features.clipboard.ui.ClipboardScreen

@AndroidEntryPoint
class ClipboardFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
                ClipboardScreen(::onNavigationBackClick)
            }
        }
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }
}