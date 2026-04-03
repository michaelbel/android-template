package org.michaelbel.template.ui.details

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.michaelbel.shared.interactor.AppInteractor
import org.michaelbel.shared.mvi.Event
import org.michaelbel.shared.mvi.MviViewModel
import org.michaelbel.template.MainEventManager
import org.michaelbel.template.navigation.BackRoute
import org.michaelbel.template.navigation.DetailsRoute
import org.michaelbel.template.ui.details.intent.DetailsIntent
import org.michaelbel.template.ui.details.model.DetailsModel

class DetailsViewModel(
    private val route: DetailsRoute,
    private val appInteractor: AppInteractor
): MviViewModel<DetailsIntent, DetailsModel, Event>(DetailsModel()) {

    init {
        dispatch(DetailsIntent.CollectData)
    }

    override fun dispatch(intent: DetailsIntent) {
        when (intent) {
            is DetailsIntent.CollectData -> {
                launch {
                    appInteractor.entityFlow(route.id).collectLatest { entity ->
                        reduce { it.copy(appEntity = entity) }
                    }
                }
            }
            is DetailsIntent.NavigateBack -> launch { MainEventManager.send(BackRoute) }
        }
    }
}
