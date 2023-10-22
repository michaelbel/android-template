package org.michaelbel.template.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import org.michaelbel.template.R

@Composable
fun ComposeScreen(
    navController: NavController,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.title_compose)
                    )
                },
                modifier = Modifier.statusBarsPadding(),
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        val listState: LazyListState = rememberLazyListState()

        val list: List<Pair<String, Int>> = mapOf(
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
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            state = listState
        ) {
            items(list) { (route, title) ->
                Button(
                    onClick = {
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
                ) {
                    Text(
                        text = stringResource(title)
                    )
                }
            }
        }
    }
}