package org.michaelbel.template.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoute: NavKey

@Serializable
data object HomeRoute: AppRoute()

@Serializable
data class DetailsRoute(val id: Int): AppRoute()
