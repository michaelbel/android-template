package org.michaelbel.template.features.networkimage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.features.networkimage.ui.NetworkImageScreen

@AndroidEntryPoint
class NetworkImageFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
                NetworkImageScreen(::onNavigationBackClick)
            }
        }
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }
}