package org.michaelbel.template.presentation.compose

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

    val list = mapOf(
        ROUTE_AUTH to "Auth",
        ROUTE_CLIPBOARD to "Clipboard",
        ROUTE_DOWNLOAD_FILE to "Download File",
        ROUTE_IME to "IME",
        ROUTE_REVIEW to "Review",
        ROUTE_INTENTS to "Intents",
        ROUTE_LOCATION to "Location",
        ROUTE_CONFIG to "Config",
        ROUTE_SERVICE to "Service",
        ROUTE_TOAST to "Toast"
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
            items(list.toList()) { (route, title) ->
                ListItem(
                    text = {
                        Text(
                            text = title
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