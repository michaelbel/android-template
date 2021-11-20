package org.michaelbel.template.features.main

import org.michaelbel.template.features.main.model.ScreenData

sealed class MainScreenState {
    data class MainScreen(
        val list: List<ScreenData> = listOf()
    ): MainScreenState()

    companion object {
        val Empty = MainScreen()
    }
}