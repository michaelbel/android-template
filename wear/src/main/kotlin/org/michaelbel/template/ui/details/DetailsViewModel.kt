package org.michaelbel.template.ui.details

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.michaelbel.core.ktx.require
import org.michaelbel.core.viewmodel.BaseViewModel
import org.michaelbel.template.interactor.AppInteractor
import org.michaelbel.template.room.AppEntity

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    appInteractor: AppInteractor
): BaseViewModel() {

    private val id: Int = savedStateHandle.require("id")

    val appEntity: StateFlow<AppEntity> = appInteractor.entityFlow(id)
        .stateIn(
            scope = this,
            started = SharingStarted.Lazily,
            initialValue = AppEntity.Empty
        )
}