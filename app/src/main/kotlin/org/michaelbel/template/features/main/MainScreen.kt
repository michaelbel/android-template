package org.michaelbel.template.features.main

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.michaelbel.template.R
import org.michaelbel.template.Screen
import org.michaelbel.template.features.main.ui.MainBottomBar
import org.michaelbel.template.features.main.ui.MainListItem
import org.michaelbel.template.ui.components.HomeBottomSheet
import org.michaelbel.template.ui.components.SearchBar
import org.michaelbel.template.ui.theme.AppTheme
import org.michaelbel.template.ui.theme.Dimens

typealias OnButtonClick = (Screen, Bundle) -> Unit

@Composable
fun Main(
    listState: LazyListState = rememberLazyListState(),
    onUpdateAppClicked: () -> Unit,
    onButtonClick: OnButtonClick,
    onSortOptionClicked: (Int) -> Unit = {},
    currentSortOption: Int = 0,
    onSettingsClicked: () -> Unit = {},
    onSearch: (String) -> Unit = {},
    onFabClick: () -> Unit
) {
    val viewModel: MainViewModel = viewModel(MainViewModel::class.java)
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val context: Context = LocalContext.current
    val focusManager: FocusManager = LocalFocusManager.current
    val snackBarUpdateVisibleState by rememberUpdatedState(viewModel.updateAvailableMessage)
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val mainScreenState by viewModel.uiState.collectAsState()
    val mainState = mainScreenState as MainScreenState.MainScreen

    val onShowSnackBar: (String, String) -> Unit = { message, actionLabel ->
        coroutineScope.launch {
            val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                duration = SnackbarDuration.Long
            )
            if (snackBarResult == SnackbarResult.ActionPerformed) {
                onUpdateAppClicked()
            }
        }
    }

    AppTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                SearchBar(
                    focusManager = focusManager,
                    onSearch = { onSearch(it) },
                    onDismissSearchClicked = { onSearch("") },
                    onOptionsClicked = {
                        coroutineScope.launch {
                            sheetState.show()
                        }
                    },
                    modifier = Modifier.padding(
                        vertical = Dimens.SmallPadding.size
                    )
                )
            },
            bottomBar = { MainBottomBar() },
            floatingActionButton = {
                Column(horizontalAlignment = Alignment.End) {
                    Fab(onFabClick)
                }
            },
        ) {
            ModalBottomSheetLayout(
                sheetContent = {
                    HomeBottomSheet(
                        sheetState = sheetState,
                        scope = coroutineScope,
                        onSortOptionClicked = {
                            onSortOptionClicked(it)
                        },
                        currentSortOption = currentSortOption,
                        onSettingsClicked = onSettingsClicked
                    )
                },
                sheetState = sheetState,
                sheetElevation = 0.dp,
                sheetBackgroundColor = Color.Transparent
            ) {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Spacer(modifier = Modifier.statusBarsPadding())
                    }
                    items(mainState.list) { screenData ->
                        MainListItem(
                            screenData = screenData,
                            onClick = { (screen, args) -> onButtonClick(screen, args) }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.navigationBarsPadding())
                    }
                }
            }
        }
    }

    if (snackBarUpdateVisibleState) {
        onShowSnackBar(
            context.getString(R.string.message_in_app_update_new_version_available),
            context.getString(R.string.action_update)
        )
    }
}

@Composable
fun Fab(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
    ) {
        Icon(Icons.Filled.Add, "Localized description")
    }
}

/*@Composable
fun MainTopBar(
    onNavigationIconClick: () -> Unit,
    onAccountIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.cd_menu)
                )
            }
        },
        elevation = 2.dp,
        actions = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                IconButton(onClick = onAccountIconClick) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = stringResource(R.string.cd_account)
                    )
                }
            }
        }
    )
}*/

@Preview(
    name = "default",
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    device = Devices.PIXEL_4
)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
fun MainPreview() {
    /*Main(
        onUpdateAppClicked = {},
        onButtonClick = { _: Screen, _: Bundle -> }
    )*/
}