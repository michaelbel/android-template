package org.michaelbel.template.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

sealed interface AppNavigation {

    @Serializable
    data object Main: AppNavigation

    @Parcelize
    @Serializable
    data class Details(
        val id: Int
    ): AppNavigation, Parcelable
}

sealed interface TabNavigation {

    @Serializable
    data object Home: TabNavigation

    @Serializable
    data object Settings: TabNavigation

    @Serializable
    data object About: TabNavigation
}