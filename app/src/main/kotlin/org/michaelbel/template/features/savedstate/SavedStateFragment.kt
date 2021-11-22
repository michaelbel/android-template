package org.michaelbel.template.features.savedstate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentSavedStateBinding

@AndroidEntryPoint
class SavedStateFragment: Fragment(R.layout.fragment_saved_state) {

    //private val viewModel: SavedStateViewModel by viewModels()
    private val binding: FragmentSavedStateBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
    }
}