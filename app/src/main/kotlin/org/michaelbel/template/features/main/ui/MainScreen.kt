package org.michaelbel.template.features.main.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ListItem
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ViewQuilt
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.insets.ui.Scaffold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.michaelbel.template.R
import org.michaelbel.template.features.compose.ComposeActivity
import org.michaelbel.template.features.main.MainScreenState
import org.michaelbel.template.features.main.MainViewModel
import org.michaelbel.template.ui.OnNavigationBackClick
import org.michaelbel.template.ui.Screen
import org.michaelbel.template.ui.components.HomeBottomSheet
import org.michaelbel.template.ui.theme.AppTheme

typealias OnButtonClick = (Screen, Bundle) -> Unit

@Composable
fun MainScreen(
    onUpdateAppClicked: () -> Unit,
    onButtonClick: OnButtonClick
) {
    val listState: LazyListState = rememberLazyListState()
    val viewModel: MainViewModel = viewModel(MainViewModel::class.java)
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
    val scope: CoroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val context: Context = LocalContext.current
    val snackBarUpdateVisibleState by rememberUpdatedState(viewModel.updateAvailableMessage)
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val mainScreenState by viewModel.uiState.collectAsState()
    val mainState = mainScreenState as MainScreenState.MainScreen

    val onShowSnackbar: (String, String) -> Unit = { message, actionLabel ->
        scope.launch {
            val snackBarResult = snackbarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                duration = SnackbarDuration.Long
            )
            if (snackBarResult == SnackbarResult.ActionPerformed) {
                onUpdateAppClicked()
            }
        }
    }

    if (snackBarUpdateVisibleState) {
        onShowSnackbar(
            stringResource(R.string.message_in_app_update_new_version_available),
            stringResource(R.string.action_update)
        )
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            Toolbar(
                scrollBehavior = scrollBehavior,
                onNavigationBackClick = { scope.launch { scaffoldState.drawerState.open() } },
                onMenuClick = { scope.launch { sheetState.show() } }
            )
        },
        bottomBar = { BottomBar() },
        drawerContent = {
            DrawerContent { scope.launch { scaffoldState.drawerState.close() } }
        },
        drawerGesturesEnabled = true,
        floatingActionButton = {
            Column(horizontalAlignment = Alignment.End) {
                Fab {
                    val intent = Intent(context, ComposeActivity::class.java)
                    context.startActivity(intent)
                }
            }
        },
    ) {
        ModalBottomSheetLayout(
            sheetContent = {
                HomeBottomSheet(
                    sheetState = sheetState,
                    scope = scope,
                    onSortOptionClicked = {},
                    onSettingsClicked = {}
                )
            },
            sheetState = sheetState
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(mainState.list) { screenData ->
                    ListItem(
                        text = { Text(text = stringResource(screenData.titleRes)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onButtonClick(screenData.screen, screenData.args) }
                    )
                }
            }
        }
    }
}

@Composable
private fun Toolbar(
    scrollBehavior: TopAppBarScrollBehavior?,
    onNavigationBackClick: OnNavigationBackClick,
    onMenuClick: () -> Unit
) {
    SmallTopAppBar(
        title = { Text(text = "Views") },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(
                onClick = { onNavigationBackClick() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.cd_menu)
                )
            }
        },
        actions = {
            IconButton(onClick = { onMenuClick() }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = stringResource(R.string.cd_settings)
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
private fun BottomBar() {
    NavigationBar(
        modifier = Modifier.systemBarsPadding()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.ViewQuilt,
                    contentDescription = stringResource(R.string.bottom_item_compose)
                )
            },
            label = { Text(stringResource(R.string.bottom_item_compose)) },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.CardGiftcard,
                    contentDescription = stringResource(R.string.bottom_item_android)
                )
            },
            label = { Text(stringResource(R.string.bottom_item_android)) },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("1") } }) {
                    Icon(
                        imageVector = Icons.Filled.ListAlt,
                        contentDescription = stringResource(R.string.bottom_item_other)
                    )
                }
            },
            label = { Text(stringResource(R.string.bottom_item_other)) },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
private fun DrawerContent(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        content = {
            Text("Close Drawer")
        }
    )
}

@Composable
private fun Fab(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
    ) {
        Icon(Icons.Filled.Add, "Localized description")
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    AppTheme {
        MainScreen(
            onUpdateAppClicked = {},
            onButtonClick = { _: Screen, _: Bundle -> }
        )
    }
}

@Preview
@Composable
private fun MainScreenPreviewDark() {
    AppTheme(darkTheme = true) {
        MainScreen(
            onUpdateAppClicked = {},
            onButtonClick = { _: Screen, _: Bundle -> }
        )
    }
}