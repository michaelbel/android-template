package org.michaelbel.template.features.main

import android.app.Activity
import android.content.Context
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.tasks.Task
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject

class InAppUpdate @Inject constructor(
    @ApplicationContext private val context: Context
) {

    var onUpdateAvailableListener: (Boolean) -> Unit = {}

    private val appUpdateManagerFactory: AppUpdateManager = AppUpdateManagerFactory.create(context)
    private val appUpdateInfo: Task<AppUpdateInfo> = appUpdateManagerFactory.appUpdateInfo
    private val appUpdateType: Int = AppUpdateType.IMMEDIATE

    init {
        appUpdateInfo.addOnSuccessListener(::onSuccessAppUpdate)
        appUpdateInfo.addOnFailureListener(Timber::e)
    }

    fun startUpdateFlow(activity: Activity) {
        appUpdateManagerFactory.startUpdateFlow(
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