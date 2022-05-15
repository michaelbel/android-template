package org.michaelbel.template.features.compose.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.systemBarsPadding
import org.michaelbel.template.R
import org.michaelbel.template.features.compose.ROUTE_CLIPBOARD
import org.michaelbel.template.features.compose.ROUTE_CONFIG
import org.michaelbel.template.features.compose.ROUTE_IME
import org.michaelbel.template.features.compose.ROUTE_IN_APP_REVIEW
import org.michaelbel.template.features.compose.ROUTE_LOCATION
import org.michaelbel.template.features.compose.ROUTE_NETWORK_IMAGE
import org.michaelbel.template.features.compose.ROUTE_SERVICE
import org.michaelbel.template.features.compose.ROUTE_SETTINGS_PANEL
import org.michaelbel.template.features.compose.ROUTE_SOCIAL
import org.michaelbel.template.features.compose.ROUTE_SYSTEM
import org.michaelbel.template.features.compose.ROUTE_TIMER
import org.michaelbel.template.features.compose.ROUTE_TMDB
import org.michaelbel.template.features.compose.ROUTE_TOAST

typealias ImeStrings = org.michaelbel.template.ime.R.string
typealias IntentsStrings = org.michaelbel.template.intents.R.string
typealias ToastStrings = org.michaelbel.template.toast.R.string
typealias LocationString = org.michaelbel.template.location.R.string
typealias ServiceStrings = org.michaelbel.template.service.R.string
typealias ConfigStrings = org.michaelbel.template.remoteconfig.R.string
typealias ClipboardStrings = org.michaelbel.template.clipboard.R.string
typealias ReviewStrings = org.michaelbel.template.inappreview.R.string

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { Toolbar() }
    ) {
        Content(
            navController
        )
    }
}

@Composable
private fun Toolbar() {
    SmallTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_home)
            )
        },
        modifier = Modifier.systemBarsPadding()
    )
}

@Composable
private fun Content(
    navController: NavController
) {
    val listState: LazyListState = rememberLazyListState()

    val list = mapOf(
        ROUTE_CLIPBOARD to ClipboardStrings.title_clipboard,
        ROUTE_NETWORK_IMAGE to R.string.title_network_image,
        ROUTE_SETTINGS_PANEL to IntentsStrings.title_intents,
        ROUTE_SOCIAL to R.string.title_social,
        ROUTE_SYSTEM to R.string.title_system_services,
        ROUTE_TIMER to R.string.title_timer,
        ROUTE_TOAST to ToastStrings.title_toast,
        ROUTE_CONFIG to ConfigStrings.title_remote_config,
        ROUTE_TMDB to R.string.title_tmdb,
        ROUTE_IN_APP_REVIEW to ReviewStrings.title_in_app_review,
        ROUTE_IME to ImeStrings.title_ime_actions,
        ROUTE_LOCATION to LocationString.title_location,
        ROUTE_SERVICE to ServiceStrings.title_service
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(list.toList()) { (route, titleRes) ->
                ListItem(
                    text = {
                        Text(
                            text = stringResource(titleRes)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(route) {
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
}