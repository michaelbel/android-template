package org.michaelbel.template

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.michaelbel.shared.interactor.AppInteractor
import org.michaelbel.shared.mvi.Event
import org.michaelbel.shared.mvi.MviViewModel

class MainViewModel(
    private val appInteractor: AppInteractor
): MviViewModel<MainIntent, MainModel, Event>(MainModel()) {

    init {
        dispatch(MainIntent.CollectData)
    }

    override fun dispatch(intent: MainIntent) {
        when (intent) {
            is MainIntent.CollectData -> {
                launch {
                    appInteractor.dynamicColorsFlow.collectLatest { enabled ->
                        reduce { it.copy(dynamicColorsEnabled = enabled) }
                    }
                }
            }
        }
    }
}
