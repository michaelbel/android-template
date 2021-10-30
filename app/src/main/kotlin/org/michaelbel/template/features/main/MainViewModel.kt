package org.michaelbel.template.features.main

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.app.InAppUpdate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    analytics: Analytics,
    private val inAppUpdate: InAppUpdate
): ViewModel() {

    var updateAvailableMessage: Boolean by mutableStateOf(false)

    init {
        analytics.trackScreen(MainFragment::class.simpleName)
        inAppUpdate.onUpdateAvailableListener = { updateAvailable ->
            updateAvailableMessage = updateAvailable
        }
    }

    fun startUpdateFlow(activity: Activity) {
        inAppUpdate.startUpdateFlow(activity)
    }
}