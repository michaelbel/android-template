package org.michaelbel.template.view.main

import org.michaelbel.template.ui.Destination

sealed class MainScreenState {
    data class MainScreen(
        val list: List<Destination.Fragment> = listOf()
    ): MainScreenState()

    companion object {
        val Empty = MainScreen()
    }
}