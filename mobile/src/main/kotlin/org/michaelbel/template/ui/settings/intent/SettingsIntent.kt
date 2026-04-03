package org.michaelbel.template.ui.settings.intent

import org.michaelbel.shared.mvi.Intent

sealed class SettingsIntent : Intent {
    data object CollectDynamicColors: SettingsIntent()
    data object ToggleDynamicColors: SettingsIntent()
}