package org.michaelbel.template.ui.settings.model

import org.michaelbel.shared.mvi.Model

data class SettingsModel(
    val dynamicColors: Boolean = false
): Model