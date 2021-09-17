package org.michaelbel.template.review.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.play.core.review.ReviewManagerFactory
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentReviewBinding
import javax.inject.Inject

@AndroidEntryPoint
class ReviewFragment: Fragment(R.layout.fragment_review) {

    @Inject lateinit var analytics: Analytics

    private val binding: FragmentReviewBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(ReviewFragment::class.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
}