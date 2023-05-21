package org.michaelbel.core.crashlytics

import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

internal class CrashlyticsTree: Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        val exception: Throwable = t ?: Exception(message)
        FirebaseCrashlytics.getInstance().run {
            setCustomKey(CRASHLYTICS_KEY_PRIORITY, priority)
            setCustomKey(CRASHLYTICS_KEY_TAG, tag.orEmpty())
            setCustomKey(CRASHLYTICS_KEY_MESSAGE, message)
            recordException(exception)
        }
    }

    private companion object {
        private const val CRASHLYTICS_KEY_PRIORITY = "priority"
        private const val CRASHLYTICS_KEY_TAG = "tag"
        private const val CRASHLYTICS_KEY_MESSAGE = "message"
    }
}