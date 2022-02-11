package org.michaelbel.template.features.compose

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.systemBarsPadding
import org.michaelbel.template.R
import org.michaelbel.template.features.compose.browser.BrowserScreen
import org.michaelbel.template.features.compose.clipboard.ClipboardScreen
import org.michaelbel.template.features.compose.networkimage.NetworkImageScreen
import org.michaelbel.template.features.compose.notifications.NotificationsScreen
import org.michaelbel.template.features.compose.settingspanel.SettingsPanelScreen
import org.michaelbel.template.features.compose.social.SocialScreen
import org.michaelbel.template.features.compose.system.SystemScreen
import org.michaelbel.template.features.compose.timer.TimerScreen

@Composable
fun ComposeActivityScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        Content(navController)
    }
}

@Composable
private fun BottomBar(
    navController: NavController
) {
    val items = listOf(
        ROUTE_HOME,
        ROUTE_BROWSER,
        ROUTE_CLIPBOARD,
        ROUTE_NETWORK_IMAGE,
        ROUTE_NOTIFICATIONS
    )

    NavigationBar(
        modifier = Modifier.systemBarsPadding()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.map { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = stringResource(R.string.bottom_item_compose)
                    )
                },
                label = {
                    Text(
                        text = "Compose"
                    )
                },
                selected = currentRoute == screen,
                onClick = {
                    navController.navigate(screen) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@SuppressLint("NewApi")
@Composable
private fun Content(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_HOME
    ) {
        composable(ROUTE_HOME) { HomeScreen(navController) }
        composable(ROUTE_BROWSER) { BrowserScreen(navController) }
        composable(ROUTE_CLIPBOARD) { ClipboardScreen(navController) }
        composable(ROUTE_NETWORK_IMAGE) { NetworkImageScreen(navController) }
        composable(ROUTE_NOTIFICATIONS) { NotificationsScreen(navController) }
        composable(ROUTE_SETTINGS_PANEL) { SettingsPanelScreen(navController) }
        composable(ROUTE_SOCIAL) { SocialScreen(navController) }
        composable(ROUTE_SYSTEM) { SystemScreen(navController) }
        composable(ROUTE_TIMER) { TimerScreen(navController) }
    }
}