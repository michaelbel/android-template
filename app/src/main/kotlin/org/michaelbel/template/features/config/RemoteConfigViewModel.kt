package org.michaelbel.template.features.config

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import org.michaelbel.core.analytics.Analytics
import timber.log.Timber

@HiltViewModel
class RemoteConfigViewModel @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig
): ViewModel() {

    val customRemoteParam = MutableSharedFlow<Any>()

    init {
        fetchRemoteConfig()
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(RemoteConfigFragment::class.simpleName)
    }

    private fun fetchRemoteConfig() {
        firebaseRemoteConfig.fetchAndActivate().addOnFailureListener(Timber::e)
    }

    fun takeBooleanParam() = viewModelScope.launch {
        val customParam: Boolean = firebaseRemoteConfig.getBoolean(REMOTE_CONFIG_CUSTOM_BOOLEAN_PARAM)
        customRemoteParam.emit(customParam)
    }

    fun takeStringParam() = viewModelScope.launch {
        val customParam: String = firebaseRemoteConfig.getString(REMOTE_CONFIG_CUSTOM_STRING_PARAM)
        customRemoteParam.emit(customParam)
    }

    fun takeNumberParam() = viewModelScope.launch {
        val customParam: Number = firebaseRemoteConfig.getLong(REMOTE_CONFIG_CUSTOM_NUMBER_PARAM)
        customRemoteParam.emit(customParam)
    }

    private companion object {
        private const val REMOTE_CONFIG_CUSTOM_BOOLEAN_PARAM = "custom_boolean_param"
        private const val REMOTE_CONFIG_CUSTOM_STRING_PARAM = "custom_string_param"
        private const val REMOTE_CONFIG_CUSTOM_NUMBER_PARAM = "custom_number_param"
    }
}