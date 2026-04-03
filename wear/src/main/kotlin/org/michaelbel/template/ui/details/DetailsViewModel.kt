package org.michaelbel.template.ui.details

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.michaelbel.shared.ktx.require
import org.michaelbel.shared.viewmodel.BaseViewModel
import org.michaelbel.shared.interactor.AppInteractor
import org.michaelbel.shared.room.BoarEntity

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    appInteractor: AppInteractor
): BaseViewModel() {

    private val id: Int = savedStateHandle.require("id")

    val appEntity: StateFlow<BoarEntity> = appInteractor.boarEntityFlow(id)
        .stateIn(
            scope = this,
            started = SharingStarted.Lazily,
            initialValue = BoarEntity.Empty
        )
}
