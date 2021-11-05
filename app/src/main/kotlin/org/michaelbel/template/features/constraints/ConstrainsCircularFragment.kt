package org.michaelbel.template.features.constraints

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentConstraintsCircularBinding
import javax.inject.Inject

@AndroidEntryPoint
class ConstrainsCircularFragment: Fragment(R.layout.fragment_constraints_circular) {

    @Inject lateinit var analytics: Analytics

    private val binding: FragmentConstraintsCircularBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(ConstrainsCircularFragment::class.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
    }
}