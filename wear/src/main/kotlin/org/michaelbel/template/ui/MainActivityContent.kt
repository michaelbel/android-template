@file:OptIn(ExperimentalHorologistApi::class)

package org.michaelbel.template.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import androidx.wear.compose.navigation.rememberSwipeDismissableNavHostState
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.AppScaffold
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.material.Chip
import com.google.android.horologist.images.base.paintable.ImageVectorPaintable.Companion.asPaintable
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.MainViewModel

@Composable
fun MainActivityContent(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel()
) {
    val navController = rememberSwipeDismissableNavController()
    val navHostState = rememberSwipeDismissableNavHostState()

    WearAppTheme {
        AppScaffold {
            SwipeDismissableNavHost(
                startDestination = Navigation.Home.route,
                navController = navController,
                modifier = Modifier.background(Color.Transparent),
                state = navHostState
            ) {
                composable(
                    route = Navigation.Home.route
                ) {
                    ScreenScaffold {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Chip(
                                label = "Navigate to Chat",
                                onClick = { navController.navigate(Navigation.Chat.route) },
                                modifier = Modifier.padding(horizontal = 16.dp),
                                icon = Icons.Outlined.MailOutline.asPaintable()
                            )
                        }
                    }
                }
                composable(
                    route = Navigation.Chat.route
                ) {
                    ScreenScaffold {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Chip(
                                label = "Navigate to Settings",
                                onClick = { navController.navigate(Navigation.Settings.route) },
                                modifier = Modifier.padding(horizontal = 16.dp),
                                icon = Icons.Outlined.Settings.asPaintable()
                            )
                        }
                    }
                }
                composable(
                    route = Navigation.Settings.route
                ) {
                    ScreenScaffold {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Chip(
                                label = "Navigate to Home",
                                onClick = { navController.navigate(Navigation.Home.route) },
                                modifier = Modifier.padding(horizontal = 16.dp),
                                icon = Icons.Outlined.Home.asPaintable()
                            )
                        }
                    }
                }
            }
        }
    }
}

sealed class Navigation(
    val route: String
) {
    data object Home: Navigation("home")
    data object Chat: Navigation("chat")
    data object Settings: Navigation("settings")
}