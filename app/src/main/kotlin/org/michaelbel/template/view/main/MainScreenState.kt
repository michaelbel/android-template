package org.michaelbel.template.view.main

sealed class MainScreenState {
    data class MainScreen(
        val list: List<ScreenData> = listOf()
    ): MainScreenState()

    companion object {
        val Empty = MainScreen()
    }
}