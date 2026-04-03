@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.template

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import kotlinx.coroutines.launch
import org.michaelbel.shared.ktx.ObserveAsEvents
import org.michaelbel.template.ui.details.DetailsScreen
import org.michaelbel.template.ui.home.HomeScreen
import org.michaelbel.template.ui.home.ReplyNavigationContentPosition

@Composable
fun MainActivityContent() {
    val backStack = rememberNavBackStack(AppRoute.Home)
    val scope = rememberCoroutineScope()
    val adaptiveInfo = currentWindowAdaptiveInfo()
    val navContentPosition = when {
        adaptiveInfo.windowSizeClass.isHeightAtLeastBreakpoint(480) -> ReplyNavigationContentPosition.CENTER
        else -> ReplyNavigationContentPosition.TOP
    }

    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        onBack = { backStack.removeLastOrNull() },
        popTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        predictivePopTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<AppRoute.Home> {
                HomeScreen(
                    navContentPosition = navContentPosition,
                    onNavigateToDetails = { id -> scope.launch { MainNavigator.forward(AppRoute.Details(id)) } }
                )
            }
            entry<AppRoute.Details> { route -> DetailsScreen(route) }
        }
    )

    ObserveAsEvents(
        flow = MainNavigator.eventFlow
    ) { event ->
        backStack.add(event)
    }
}
