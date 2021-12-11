package org.michaelbel.template.features.inappreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.features.inappreview.ui.ReviewScreen

@AndroidEntryPoint
class ReviewFragment: Fragment() {

    @Inject lateinit var inAppReview: InAppReview

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
                ReviewScreen(::startReviewFlow, ::onNavigationBackClick)
            }
        }
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(ReviewFragment::class.simpleName)
    }

    private fun startReviewFlow() {
        inAppReview.startReviewFlow(requireActivity())
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }
}