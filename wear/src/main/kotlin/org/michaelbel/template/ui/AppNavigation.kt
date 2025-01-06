package org.michaelbel.template.ui

sealed class AppNavigation(
    val route: String
) {
    data object List: AppNavigation("list")

    data object Details: AppNavigation("details")

    data object Settings: AppNavigation("settings")

    data object About: AppNavigation("about")
}