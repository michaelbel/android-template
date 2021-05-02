package org.michaelbel.template.savedstate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentSavedStateBinding

@AndroidEntryPoint
class SavedStateFragment: Fragment(R.layout.fragment_saved_state) {

    private val viewModel: SavedStateViewModel by viewModels()

    private var _binding: FragmentSavedStateBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSavedStateBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}