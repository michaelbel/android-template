package org.michaelbel.template

import org.michaelbel.shared.mvi.Intent

sealed interface MainIntent: Intent {
    data object CollectData: MainIntent
}
