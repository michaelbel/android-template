package org.michaelbel.template.ui.list.intent

import org.michaelbel.shared.mvi.Intent

sealed class ListIntent: Intent {
    data object CollectData: ListIntent()
    data object LoadData: ListIntent()
}