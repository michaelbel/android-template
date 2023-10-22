package org.michaelbel.template.ui.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.ui.TemplateTheme

@AndroidEntryPoint
class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            TemplateTheme {
                MainFragmentContent({ requireActivity().finish() }, ::navigateTo)
            }
        }
    }

    private fun navigateTo(@IdRes toId: Int, args: Bundle) {
        findNavController().navigate(toId, args)
    }
}