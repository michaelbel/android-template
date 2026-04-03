package org.michaelbel.template.ui.list

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.michaelbel.shared.interactor.AppInteractor
import org.michaelbel.shared.mvi.Event
import org.michaelbel.shared.mvi.MviViewModel
import org.michaelbel.template.ui.list.intent.ListIntent
import org.michaelbel.template.ui.list.model.ListModel

class ListViewModel(
    private val appInteractor: AppInteractor
): MviViewModel<ListIntent, ListModel, Event>(ListModel()) {

    init {
        dispatch(ListIntent.CollectData)
        dispatch(ListIntent.LoadData)
    }

    override fun dispatch(intent: ListIntent) {
        when (intent) {
            is ListIntent.CollectData -> {
                launch {
                    appInteractor.entitiesFlow.collectLatest { entities ->
                        reduce { it.copy(entities = entities) }
                    }
                }
            }
            is ListIntent.LoadData -> launch { appInteractor.loadDataResponse() }
        }
    }
}
