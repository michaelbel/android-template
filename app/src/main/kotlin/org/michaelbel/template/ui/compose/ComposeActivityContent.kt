package org.michaelbel.template.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.michaelbel.template.auth.AuthScreen
import org.michaelbel.template.clipboard.ui.ClipboardScreen
import org.michaelbel.template.downloadfile.DownloadFileScreen
import org.michaelbel.template.getcontent.GetContentScreen
import org.michaelbel.template.ime.ImeScreen
import org.michaelbel.template.inappreview.ui.ReviewScreen
import org.michaelbel.template.intents.IntentsScreen
import org.michaelbel.template.location.LocationScreen
import org.michaelbel.template.phonecalls.ui.PhoneCallsScreen
import org.michaelbel.template.remoteconfig.ui.RemoteConfigScreen
import org.michaelbel.template.service.ui.ServiceScreen
import org.michaelbel.template.toast.ToastScreen
import org.michaelbel.template.ui.TemplateTheme
import org.michaelbel.template.ui.compose.lazylist.LazyListScreen
import org.michaelbel.template.ui.compose.list.ListScreen

@Composable
fun ComposeActivityContent(
    onNavigateBack: () -> Unit
) {
    val navController: NavHostController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable(route = "list") {
            ListScreen(navController, onNavigateBack)
        }
        composable(route = "clipboard") {
            ClipboardScreen(navController)
        }
        composable(route = "download_file") {
            DownloadFileScreen(navController)
        }
        composable(route = "intents") {
            IntentsScreen(navController)
        }
        composable(route = "auth") {
            AuthScreen(navController)
        }
        composable(route = "toast") {
            ToastScreen(navController)
        }
        composable(route = "config") {
            RemoteConfigScreen(navController)
        }
        composable(route = "review") {
            ReviewScreen(navController, {})
        }
        composable(route = "ime") {
            ImeScreen(navController)
        }
        composable(route = "location") {
            LocationScreen(navController)
        }
        composable(route = "service") {
            ServiceScreen(navController)
        }
        composable(route = "lazyList") {
            LazyListScreen(navController)
        }
        composable(route = "getcontent") {
            GetContentScreen(navController)
        }
        composable(route = "phone_calls") {
            PhoneCallsScreen(navController)
        }
    }
}

@Preview
@Composable
private fun ComposeActivityContentPreview() {
    TemplateTheme {
        ComposeActivityContent(
            onNavigateBack = {}
        )
    }
}