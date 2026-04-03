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
    private val interactor: AppInteractor
): MviViewModel<DetailsIntent, DetailsModel, Event>(DetailsModel()) {

    init {
        dispatch(DetailsIntent.CollectBoarEntity)
    }

    override fun dispatch(intent: DetailsIntent) {
        when (intent) {
            is DetailsIntent.CollectBoarEntity -> {
                launch {
                    interactor.boarEntityFlow(route.boarId).collectLatest { entity ->
                        reduce { it.copy(entity = entity) }
                    }
                }
            }
        }
    }
}
