package org.michaelbel.template.review.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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
            val reviewManagerFactory = ReviewManagerFactory.create(requireContext())
            val requestReviewFlow = reviewManagerFactory.requestReviewFlow()
            requestReviewFlow.addOnCompleteListener { task ->
                val message: String = String.format(
                    getString(R.string.message_review_status),
                    task.exception,
                    task.result,
                    task.isSuccessful,
                    task.isComplete
                )

                if (task.isSuccessful) {
                    val reviewInfo = task.result
                    val flow = reviewManagerFactory.launchReviewFlow(requireActivity(), reviewInfo)
                    flow.addOnCompleteListener {
                        // Обрабатываем завершение сценария оценки.
                    }
                }

                binding.reviewStatusTextView.text = message
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}