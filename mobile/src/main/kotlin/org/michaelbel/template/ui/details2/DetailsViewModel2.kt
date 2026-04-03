@file:OptIn(ExperimentalCoroutinesApi::class)

package org.michaelbel.template.ui.details2

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import org.michaelbel.shared.interactor.AppInteractor
import org.michaelbel.shared.mvi.Event
import org.michaelbel.shared.mvi.MviViewModel
import org.michaelbel.template.ui.details2.intent.Details2Intent
import org.michaelbel.template.ui.details2.model.Details2Model

class DetailsViewModel2(
    private val appInteractor: AppInteractor
): MviViewModel<Details2Intent, Details2Model, Event>(Details2Model()) {

    private val idFlow = MutableStateFlow(0)

    init {
        dispatch(Details2Intent.CollectData)
        dispatch(Details2Intent.CollectData)
    }

    override fun dispatch(intent: Details2Intent) {
        when (intent) {
            is Details2Intent.CollectData -> {
                launch {
                    idFlow.flatMapLatest { appInteractor.entityFlow(it) }.collectLatest { entity ->
                        reduce { it.copy(appEntity = entity) }
                    }
                }
            }
            is Details2Intent.SetId -> idFlow.value = intent.id
        }
    }
}
