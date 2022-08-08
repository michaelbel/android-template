package org.michaelbel.template.phonecalls.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.michaelbel.template.phonecalls.PhoneCallsManager
import org.michaelbel.template.phonecalls.model.PhoneCallLog

@HiltViewModel
class PhoneCallsViewModel @Inject constructor(
    private val phoneCallsManager: PhoneCallsManager
): ViewModel() {

    private val _logs: MutableStateFlow<List<PhoneCallLog>> = MutableStateFlow(emptyList())
    val logs: StateFlow<List<PhoneCallLog>> = _logs.asStateFlow()

    init {
        readCallLog()
    }

    fun readCallLog() = viewModelScope.launch {
        _logs.emit(phoneCallsManager.readCallLog())
    }
}