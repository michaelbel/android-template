package org.michaelbel.template.ui

import kotlinx.serialization.Serializable

sealed interface Navigation {

    @Serializable
    data object Home: Navigation

    @Serializable
    data class Details(
        val id: Int
    ): Navigation

    @Serializable
    data object Settings: Navigation

    @Serializable
    data object About: Navigation
}