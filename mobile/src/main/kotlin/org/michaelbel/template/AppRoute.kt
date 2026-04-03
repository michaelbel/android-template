package org.michaelbel.template

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute: NavKey {

    @Serializable
    data object Home: AppRoute

    @Serializable
    data class Details(val boarId: Int): AppRoute
}