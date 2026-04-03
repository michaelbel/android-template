package org.michaelbel.template.ui.details.intent

import org.michaelbel.shared.mvi.Intent

sealed class DetailsIntent: Intent {
    data object CollectData: DetailsIntent()
    data object NavigateBack: DetailsIntent()
}
