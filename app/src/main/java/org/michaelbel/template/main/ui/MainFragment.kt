package org.michaelbel.template.main.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        binding.inAppReviewButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_reviewFragment)
        }
        binding.inAppUpdateButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_updateFragment)
        }
        binding.savedStateButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_savedStateFragment)
        }
        binding.toastButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_toastFragment)
        }
        binding.keyboardButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_insetsFragment)
        }
        binding.pagingButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pagingFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}