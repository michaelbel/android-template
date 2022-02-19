package org.michaelbel.template.features.compose

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.michaelbel.template.features.compose.clipboard.ClipboardScreen
import org.michaelbel.template.features.compose.config.RemoteConfigScreen
import org.michaelbel.template.features.compose.home.HomeScreen
import org.michaelbel.template.features.compose.intents.IntentsScreen
import org.michaelbel.template.features.compose.networkimage.NetworkImageScreen
import org.michaelbel.template.features.compose.notifications.NotificationsScreen
import org.michaelbel.template.features.compose.social.SocialScreen
import org.michaelbel.template.features.compose.system.SystemScreen
import org.michaelbel.template.features.compose.timer.TimerScreen
import org.michaelbel.template.features.compose.tmdb.TmdbScreen
import org.michaelbel.template.features.compose.toast.ToastScreen

const val ROUTE_HOME = "route_home"
const val ROUTE_CLIPBOARD = "route_clipboard"
const val ROUTE_NETWORK_IMAGE = "route_network_image"
const val ROUTE_NOTIFICATIONS = "route_notifications"
const val ROUTE_SETTINGS_PANEL = "route_settings_panel"
const val ROUTE_SOCIAL = "route_social"
const val ROUTE_SYSTEM = "route_system"
const val ROUTE_TIMER = "route_timer"
const val ROUTE_TOAST = "route_toast"
const val ROUTE_CONFIG = "route_config"
const val ROUTE_TMDB = "route_tmdb"

@SuppressLint("NewApi")
@Composable
fun Content(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_HOME
    ) {
        composable(ROUTE_HOME) { HomeScreen(navController) }
        composable(ROUTE_CLIPBOARD) { ClipboardScreen(navController) }
        composable(ROUTE_NETWORK_IMAGE) { NetworkImageScreen(navController) }
        composable(ROUTE_NOTIFICATIONS) { NotificationsScreen(navController) }
        composable(ROUTE_SETTINGS_PANEL) { IntentsScreen(navController) }
        composable(ROUTE_SOCIAL) { SocialScreen(navController) }
        composable(ROUTE_SYSTEM) { SystemScreen(navController) }
        composable(ROUTE_TIMER) { TimerScreen(navController) }
        composable(ROUTE_TOAST) { ToastScreen(navController) }
        composable(ROUTE_CONFIG) { RemoteConfigScreen(navController) }
        composable(ROUTE_TMDB) { TmdbScreen(navController) }
    }
}