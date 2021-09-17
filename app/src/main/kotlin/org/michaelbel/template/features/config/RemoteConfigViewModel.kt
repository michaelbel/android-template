package org.michaelbel.template.features.config

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import org.michaelbel.core.analytics.Analytics
import javax.inject.Inject

@HiltViewModel
class RemoteConfigViewModel @Inject constructor(
    analytics: Analytics
): ViewModel() {

    val remoteColor = MutableSharedFlow<String>()

    init {
        analytics.trackScreen(RemoteConfigFragment::class.simpleName)
        initConfig()
    }

    private fun initConfig() = viewModelScope.launch {
        val defaults = mapOf("color" to "#FF5252")

        val remoteConfig = FirebaseRemoteConfig.getInstance()
        remoteConfig.setDefaultsAsync(defaults)
        remoteConfig.fetch().addOnSuccessListener {
            Log.e("2580", "addOnSuccessListener $it")
        }

        val color = remoteConfig.getString("color")
        remoteColor.emit(color)
    }
}