package org.michaelbel.template.ui.view.constraints

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.ktx.doOnApplyWindowInsets
import org.michaelbel.core.ktx.topPadding
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentConstraintsChainsBinding

@AndroidEntryPoint
class ConstrainsChainsFragment: Fragment(R.layout.fragment_constraints_chains) {

    private val binding: FragmentConstraintsChainsBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            appBarLayout.doOnApplyWindowInsets { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.topPadding = systemBars.top
                WindowInsetsCompat.CONSUMED
            }
            toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }
}