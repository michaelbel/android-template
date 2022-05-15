package org.michaelbel.template.presentation.view.model

sealed class MainScreenState {
    data class MainScreen(
        val list: List<ScreenData> = listOf()
    ): MainScreenState()

    companion object {
        val Empty = MainScreen()
    }
}