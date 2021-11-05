package org.michaelbel.template.features.constraints

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentConstraintsGoneMarginsBinding
import javax.inject.Inject

@AndroidEntryPoint
class ConstrainsGoneMarginsFragment: Fragment(R.layout.fragment_constraints_gone_margins) {

    @Inject lateinit var analytics: Analytics

    private val binding: FragmentConstraintsGoneMarginsBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(ConstrainsGoneMarginsFragment::class.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
    }
}