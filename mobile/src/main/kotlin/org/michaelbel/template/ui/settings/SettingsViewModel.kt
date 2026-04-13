package org.michaelbel.template.ui.settings

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.michaelbel.shared.interactor.AppInteractor
import org.michaelbel.shared.mvi.Event
import org.michaelbel.shared.mvi.MviViewModel
import org.michaelbel.template.ui.settings.intent.SettingsIntent
import org.michaelbel.template.ui.settings.model.SettingsModel

class SettingsViewModel(
    private val appInteractor: AppInteractor
): MviViewModel<SettingsIntent, SettingsModel, Event>(SettingsModel()) {

    init {
        dispatch(SettingsIntent.CollectDynamicColors)
    }

    override fun dispatch(intent: SettingsIntent) {
        when (intent) {
            is SettingsIntent.CollectDynamicColors -> {
                launch {
                    appInteractor.dynamicColorsFlow.collectLatest { enabled ->
                        reduce { it.copy(dynamicColors = enabled) }
                    }
                }
            }
            is SettingsIntent.ToggleDynamicColors -> {
                launch { appInteractor.setDynamicColors(!stateFlow.value.dynamicColors) }
            }
        }
    }
}
