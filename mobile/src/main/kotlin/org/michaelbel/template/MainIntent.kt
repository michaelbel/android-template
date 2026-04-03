package org.michaelbel.template

import org.michaelbel.shared.mvi.Intent

sealed class MainIntent: Intent {
    data object CollectData: MainIntent()
}
