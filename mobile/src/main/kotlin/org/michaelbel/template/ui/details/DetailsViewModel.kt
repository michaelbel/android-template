package org.michaelbel.template.ui.details

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.michaelbel.shared.interactor.AppInteractor
import org.michaelbel.shared.mvi.Event
import org.michaelbel.shared.mvi.MviViewModel
import org.michaelbel.template.AppRoute
import org.michaelbel.template.ui.details.intent.DetailsIntent
import org.michaelbel.template.ui.details.model.DetailsModel

class DetailsViewModel(
    private val route: AppRoute.Details,
    private val appInteractor: AppInteractor
): MviViewModel<DetailsIntent, DetailsModel, Event>(DetailsModel()) {

    init {
        dispatch(DetailsIntent.CollectData)
    }

    override fun dispatch(intent: DetailsIntent) {
        when (intent) {
            is DetailsIntent.CollectData -> {
                launch {
                    appInteractor.entityFlow(route.boarId).collectLatest { entity ->
                        reduce { it.copy(appEntity = entity) }
                    }
                }
            }
        }
    }
}
