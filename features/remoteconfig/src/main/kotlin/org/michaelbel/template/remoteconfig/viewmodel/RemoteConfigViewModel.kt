package org.michaelbel.template.remoteconfig.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class RemoteConfigViewModel @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig
): ViewModel() {

    private val _customRemoteParam: MutableStateFlow<Any?> = MutableStateFlow(null)
    val customRemoteParam: StateFlow<Any?> = _customRemoteParam.asStateFlow()

    init {
        fetchRemoteConfig()
    }

    fun takeBooleanParam() = viewModelScope.launch {
        val customParam: Boolean = firebaseRemoteConfig.getBoolean(
            REMOTE_CONFIG_CUSTOM_BOOLEAN_PARAM
        )
        _customRemoteParam.emit(customParam)
    }

    fun takeStringParam() = viewModelScope.launch {
        val customParam: String = firebaseRemoteConfig.getString(REMOTE_CONFIG_CUSTOM_STRING_PARAM)
        _customRemoteParam.emit(customParam)
    }

    fun takeNumberParam() = viewModelScope.launch {
        val customParam: Number = firebaseRemoteConfig.getLong(REMOTE_CONFIG_CUSTOM_NUMBER_PARAM)
        _customRemoteParam.emit(customParam)
    }

    private fun fetchRemoteConfig() {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 60
        }
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
        firebaseRemoteConfig.fetchAndActivate().addOnFailureListener(Timber::e)
    }

    private companion object {
        private const val REMOTE_CONFIG_CUSTOM_BOOLEAN_PARAM = "custom_boolean_param"
        private const val REMOTE_CONFIG_CUSTOM_STRING_PARAM = "custom_string_param"
        private const val REMOTE_CONFIG_CUSTOM_NUMBER_PARAM = "custom_number_param"
    }
}