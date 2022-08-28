package org.michaelbel.template.inappupdate

import android.app.Activity
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.tasks.Task
import javax.inject.Inject
import org.michaelbel.core.googleapi.GoogleApi
import timber.log.Timber

class InAppUpdate @Inject constructor(
    private val appUpdateManager: AppUpdateManager,
    googleApi: GoogleApi
) {

    var onUpdateAvailableListener: (Boolean) -> Unit = {}

    private val appUpdateInfo: Task<AppUpdateInfo> = appUpdateManager.appUpdateInfo
    private val appUpdateType: Int = AppUpdateType.IMMEDIATE

    init {
        if (googleApi.isAppFromGooglePlay) {
            appUpdateInfo.addOnSuccessListener(::onSuccessAppUpdate)
            appUpdateInfo.addOnFailureListener(Timber::e)
        }
    }

    fun startUpdateFlow(activity: Activity) {
        appUpdateManager.startUpdateFlow(
            appUpdateInfo.result,
            activity,
            AppUpdateOptions.defaultOptions(appUpdateType)
        )
    }

    private fun onSuccessAppUpdate(appUpdateInfo: AppUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
            onUpdateAvailableListener(true)
        }
    }
}