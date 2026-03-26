package org.michaelbel.template

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.michaelbel.shared.interactor.AppInteractor
import org.michaelbel.shared.viewmodel.BaseViewModel

class MainViewModel(
    appInteractor: AppInteractor
): BaseViewModel() {

    val dynamicColorsEnabled: StateFlow<Boolean> = appInteractor.dynamicColorsFlow
        .stateIn(scope = this, started = SharingStarted.WhileSubscribed(5_000), initialValue = false)
}
