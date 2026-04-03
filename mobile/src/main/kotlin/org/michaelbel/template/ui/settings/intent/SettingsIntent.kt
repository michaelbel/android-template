package org.michaelbel.template.ui.settings.intent

import org.michaelbel.shared.mvi.Intent

sealed interface SettingsIntent: Intent {
    data object CollectDynamicColors: SettingsIntent
    data object ToggleDynamicColors: SettingsIntent
}
