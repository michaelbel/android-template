package org.michaelbel.template.review.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.review.ReviewManagerFactory
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentReviewBinding

@AndroidEntryPoint
class ReviewFragment: Fragment(R.layout.fragment_review) {

    private var _binding: FragmentReviewBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReviewBinding.bind(view)

        binding.reviewButton.setOnClickListener {
            val reviewManager = ReviewManagerFactory.create(requireContext())
            val requestReviewFlow = reviewManager.requestReviewFlow()
            requestReviewFlow.addOnCompleteListener { request ->
                if (request.isSuccessful) {
                    val reviewInfo = request.result
                    val flow = reviewManager.launchReviewFlow(requireActivity(), reviewInfo)
                    flow.addOnCompleteListener {
                        // Обрабатываем завершение сценария оценки
                    }
                } else {
                    Snackbar.make(view, R.string.error_while_review, Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}