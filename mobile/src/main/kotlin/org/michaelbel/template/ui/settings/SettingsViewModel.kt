package org.michaelbel.template.ui.settings

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.michaelbel.shared.viewmodel.BaseViewModel
import org.michaelbel.shared.interactor.AppInteractor

class SettingsViewModel(
    private val appInteractor: AppInteractor
): BaseViewModel() {

    val dynamicColorsEnabled: StateFlow<Boolean> = appInteractor.dynamicColorsFlow
        .stateIn(scope = this, started = SharingStarted.WhileSubscribed(5_000), initialValue = false)

    fun toggleDynamicColors() {
        launch { appInteractor.setDynamicColors(!dynamicColorsEnabled.value) }
    }
}
