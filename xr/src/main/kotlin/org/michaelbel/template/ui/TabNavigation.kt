package org.michaelbel.template.ui

import kotlinx.serialization.Serializable

sealed interface AppNavigation {

    @Serializable
    data object Main: AppNavigation

    @Serializable
    data class Details(
        val id: Int
    ): AppNavigation
}

sealed interface TabNavigation {

    @Serializable
    data object Home: TabNavigation

    @Serializable
    data object Settings: TabNavigation

    @Serializable
    data object About: TabNavigation
}