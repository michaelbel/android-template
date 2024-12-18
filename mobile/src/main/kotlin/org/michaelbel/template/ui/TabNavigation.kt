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

    @Parcelize
    @Serializable
    data object Home: TabNavigation, Parcelable

    @Parcelize
    @Serializable
    data object Settings: TabNavigation, Parcelable

    @Parcelize
    @Serializable
    data object About: TabNavigation, Parcelable
}