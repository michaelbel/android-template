package org.michaelbel.template.features.fonts

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentFontsBinding

@AndroidEntryPoint
class FontsFragment: Fragment(R.layout.fragment_fonts) {

    @Inject lateinit var analytics: Analytics

    private val binding: FragmentFontsBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(FontsFragment::class.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }

        binding.toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = 0
            bottomMargin = 0
        }
    }
}