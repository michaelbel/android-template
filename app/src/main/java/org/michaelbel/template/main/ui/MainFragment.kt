package org.michaelbel.template.main.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentMainBinding
import org.michaelbel.template.review.ui.ReviewFragment
import org.michaelbel.template.savedstate.SavedStateFragment
import org.michaelbel.template.toast.ToastFragment
import org.michaelbel.template.update.ui.UpdateFragment

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        binding.inAppReviewButton.setOnClickListener {
            parentFragmentManager.commit(allowStateLoss = true) {
                replace(R.id.container, ReviewFragment(), ReviewFragment::class.java.canonicalName)
                addToBackStack(ReviewFragment::class.java.canonicalName)
            }
        }
        binding.inAppUpdateButton.setOnClickListener {
            parentFragmentManager.commit(allowStateLoss = true) {
                replace(R.id.container, UpdateFragment(), UpdateFragment::class.java.canonicalName)
                addToBackStack(UpdateFragment::class.java.canonicalName)
            }
        }
        binding.savedStateButton.setOnClickListener {
            parentFragmentManager.commit(allowStateLoss = true) {
                replace(R.id.container, SavedStateFragment(), SavedStateFragment::class.java.canonicalName)
                addToBackStack(SavedStateFragment::class.java.canonicalName)
            }
        }
        binding.toastButton.setOnClickListener {
            parentFragmentManager.commit(allowStateLoss = true) {
                replace(R.id.container, ToastFragment(), ToastFragment::class.java.canonicalName)
                addToBackStack(ToastFragment::class.java.canonicalName)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}