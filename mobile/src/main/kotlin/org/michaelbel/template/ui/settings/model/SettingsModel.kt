package org.michaelbel.template.ui.settings.model

import org.michaelbel.shared.mvi.Model

data class SettingsModel(
    val dynamicColorsEnabled: Boolean = false
): Model