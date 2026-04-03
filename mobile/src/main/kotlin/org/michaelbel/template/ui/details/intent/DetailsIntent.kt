package org.michaelbel.template.ui.details.intent

import org.michaelbel.shared.mvi.Intent

sealed interface DetailsIntent: Intent {
    data object CollectBoarEntity: DetailsIntent
}
