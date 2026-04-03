package org.michaelbel.template.compact

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
import org.michaelbel.template.compact.details.DetailsScreen
import org.michaelbel.template.ui.home.HomeScreen
import org.michaelbel.template.ui.home.ReplyNavigationContentPosition

@Composable
fun CompactApp() {
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
                HomeScreen(
                    navContentPosition = ReplyNavigationContentPosition.TOP,
                    onNavigateToDetails = { id -> backStack.add(AppRoute.Details(id)) }
                )
            }
            entry<AppRoute.Details> { route -> DetailsScreen(route) }
        }
    )
}
