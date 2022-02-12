package org.michaelbel.template.features.compose.config

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class RemoteConfigViewModel @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig
): ViewModel() {

    var customRemoteParam: Any? by mutableStateOf(null)

    init {
        fetchRemoteConfig()
    }

    private fun fetchRemoteConfig() {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 60
        }
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
        firebaseRemoteConfig.fetchAndActivate().addOnFailureListener(Timber::e)
    }

    fun takeBooleanParam() = viewModelScope.launch {
        val customParam: Boolean = firebaseRemoteConfig.getBoolean(REMOTE_CONFIG_CUSTOM_BOOLEAN_PARAM)
        customRemoteParam = customParam
    }

    fun takeStringParam() = viewModelScope.launch {
        val customParam: String = firebaseRemoteConfig.getString(REMOTE_CONFIG_CUSTOM_STRING_PARAM)
        customRemoteParam = customParam
    }

    fun takeNumberParam() = viewModelScope.launch {
        val customParam: Number = firebaseRemoteConfig.getLong(REMOTE_CONFIG_CUSTOM_NUMBER_PARAM)
        customRemoteParam = customParam
    }

    private companion object {
        private const val REMOTE_CONFIG_CUSTOM_BOOLEAN_PARAM = "custom_boolean_param"
        private const val REMOTE_CONFIG_CUSTOM_STRING_PARAM = "custom_string_param"
        private const val REMOTE_CONFIG_CUSTOM_NUMBER_PARAM = "custom_number_param"
    }
}