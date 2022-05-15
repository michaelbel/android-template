package org.michaelbel.template.presentation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import org.michaelbel.template.auth.AuthScreen
import org.michaelbel.template.clipboard.ClipboardScreen
import org.michaelbel.template.ime.ImeScreen
import org.michaelbel.template.inappreview.ReviewScreen
import org.michaelbel.template.intents.IntentsScreen
import org.michaelbel.template.location.LocationScreen
import org.michaelbel.template.remoteconfig.RemoteConfigScreen
import org.michaelbel.template.service.ServiceScreen
import org.michaelbel.template.toast.ToastScreen

const val ROUTE_COMPOSE = "compose"
const val ROUTE_AUTH = "auth"
const val ROUTE_CLIPBOARD = "clipboard"
const val ROUTE_IME = "ime"
const val ROUTE_REVIEW = "review"
const val ROUTE_INTENTS = "intents"
const val ROUTE_LOCATION = "location"
const val ROUTE_CONFIG = "config"
const val ROUTE_SERVICE = "service"
const val ROUTE_TOAST = "toast"

@Composable
fun Content(
    navController: NavHostController,
    onReviewButtonClick: () -> Unit
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = ROUTE_COMPOSE
    ) {
        composable(route = ROUTE_COMPOSE) { ComposeScreen(navController) }
        composable(route = ROUTE_CLIPBOARD) { ClipboardScreen(navController) }
        composable(route = ROUTE_INTENTS) { IntentsScreen(navController) }
        composable(route = ROUTE_AUTH) { AuthScreen(navController) }
        composable(route = ROUTE_TOAST) { ToastScreen(navController) }
        composable(route = ROUTE_CONFIG) { RemoteConfigScreen(navController) }
        composable(route = ROUTE_REVIEW) { ReviewScreen(navController, onReviewButtonClick) }
        composable(route = ROUTE_IME) { ImeScreen(navController) }
        composable(route = ROUTE_LOCATION) { LocationScreen(navController) }
        composable(route = ROUTE_SERVICE) { ServiceScreen(navController) }
    }
}