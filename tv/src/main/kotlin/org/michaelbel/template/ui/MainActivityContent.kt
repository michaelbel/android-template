package org.michaelbel.template.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.MainViewModel

@Composable
fun MainActivityContent(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel()
) {
    val navController = rememberNavController()

    TvAppTheme {
        NavHost(
            navController = navController,
            startDestination = Navigation.Home.route
        ) {
            composable(Navigation.Home.route) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { navController.navigate(Navigation.Chat.route) }
                    ) {
                        Text("Navigate to Chat")
                    }
                }
            }
            composable(Navigation.Chat.route) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { navController.navigate(Navigation.Settings.route) }
                    ) {
                        Text("Navigate to Settings")
                    }
                }
            }
            composable(Navigation.Settings.route) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { navController.navigate(Navigation.Home.route) }
                    ) {
                        Text("Navigate to Home")
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