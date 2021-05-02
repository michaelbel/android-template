package org.michaelbel.template.savedstate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentSavedstateBinding

@AndroidEntryPoint
class SavedStateFragment: Fragment(R.layout.fragment_savedstate) {

    private val viewModel: SavedStateViewModel by viewModels()

    private var _binding: FragmentSavedstateBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSavedstateBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}