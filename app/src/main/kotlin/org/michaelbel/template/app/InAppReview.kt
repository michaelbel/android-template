package org.michaelbel.template.app

import android.app.Activity
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.tasks.Task
import timber.log.Timber
import javax.inject.Inject

class InAppReview @Inject constructor(
    private val reviewManager: ReviewManager
) {

    private val reviewInfo: Task<ReviewInfo> = reviewManager.requestReviewFlow()

    init {
        reviewInfo.addOnFailureListener(Timber::e)
    }

    fun startReviewFlow(activity: Activity) {
        reviewManager.launchReviewFlow(activity, reviewInfo.result)
    }
}