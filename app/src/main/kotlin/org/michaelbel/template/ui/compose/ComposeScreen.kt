package org.michaelbel.template.ui.compose

import androidx.compose.foundation.clickable
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

@Composable
fun ComposeScreen(
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
                text = stringResource(R.string.title_compose)
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

    val list: List<Pair<String, Int>> = mapOf(
        ROUTE_ADS to R.string.title_ads,
        ROUTE_CLIPBOARD to R.string.title_clipboard,
        ROUTE_DOWNLOAD_FILE to R.string.title_storage,
        ROUTE_IME to R.string.title_ime_actions,
        ROUTE_REVIEW to R.string.title_in_app_review,
        ROUTE_INTENTS to R.string.title_intents,
        ROUTE_LOCATION to R.string.title_location,
        ROUTE_CONFIG to R.string.title_remote_config,
        ROUTE_SERVICE to R.string.title_service,
        ROUTE_TOAST to R.string.title_toast,
        ROUTE_LAZY_LIST to R.string.title_lazy_list,
        ROUTE_GET_CONTENT to R.string.title_get_content,
        ROUTE_PHONE_CALLS to R.string.title_phone_calls
    ).toList()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(list) { (route, title) ->
            ListItem(
                text = {
                    Text(
                        text = stringResource(title)
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