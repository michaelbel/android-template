package org.michaelbel.template.step3_NavigationSuiteScaffold_BottomBar

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import org.michaelbel.template.AppRoute
import org.michaelbel.template.step3_NavigationSuiteScaffold_BottomBar.details.DetailsScreen
import org.michaelbel.template.step3_NavigationSuiteScaffold_BottomBar.main.MainScreen

@Composable
fun Step3App() {
    val backStack = rememberNavBackStack(AppRoute.Home)

    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        popTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        predictivePopTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<AppRoute.Home> {
                MainScreen(
                    onNavigateToDetails = { boarId -> backStack.add(AppRoute.Details(boarId)) }
                )
            }
            entry<AppRoute.Details> { route -> DetailsScreen(route) }
        }
    )
}
