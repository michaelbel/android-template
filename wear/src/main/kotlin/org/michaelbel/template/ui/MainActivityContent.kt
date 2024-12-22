package org.michaelbel.template.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.google.android.horologist.compose.layout.AppScaffold
import com.google.android.horologist.compose.layout.ScreenScaffold
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.MainViewModel
import org.michaelbel.template.ui.details.DetailsScreen
import org.michaelbel.template.ui.list.ListScreen

@Composable
fun MainActivityContent(
    viewModel: MainViewModel = koinViewModel()
) {
    val swipeDismissableNavController = rememberSwipeDismissableNavController()

    AppScaffold {
        SwipeDismissableNavHost(
            startDestination = AppNavigation.List.route,
            navController = swipeDismissableNavController
        ) {
            composable(
                route = AppNavigation.List.route
            ) {
                ListScreen(
                    onClick = { swipeDismissableNavController.navigate(AppNavigation.Details.route + "/$it") },
                    navigateToSettings = { swipeDismissableNavController.navigate(AppNavigation.Settings.route) },
                    navigateToAbout = { swipeDismissableNavController.navigate(AppNavigation.About.route) },
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(
                route = AppNavigation.Details.route + "/{id}",
                arguments = listOf(navArgument("id", builder = { type = NavType.IntType }))
            ) {
                DetailsScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(
                route = AppNavigation.Settings.route
            ) {
                ScreenScaffold {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Settings",
                            color = MaterialTheme.colorScheme.surface
                        )
                    }
                }
            }
            composable(
                route = AppNavigation.About.route
            ) {
                ScreenScaffold {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "About",
                            color = MaterialTheme.colorScheme.surface
                        )
                    }
                }
            }
        }
    }
}