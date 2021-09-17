package org.michaelbel.template.savedstate

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentSavedStateBinding

@AndroidEntryPoint
class SavedStateFragment: Fragment(R.layout.fragment_saved_state) {

    private val viewModel: SavedStateViewModel by viewModels()
    private val binding: FragmentSavedStateBinding by viewBinding()
}