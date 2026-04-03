package org.michaelbel.template

import org.michaelbel.shared.mvi.Model

data class MainModel(
    val dynamicColorsEnabled: Boolean = false
): Model
