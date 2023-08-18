package org.michaelbel.template.ui.view.ui

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
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.insets.ui.Scaffold
import org.michaelbel.template.ui.AppTheme
import org.michaelbel.template.ui.compose.ComposeActivity
import org.michaelbel.template.ui.view.MainViewModel
import org.michaelbel.template.ui.view.Screen
import org.michaelbel.template.ui.view.model.MainScreenState

typealias OnButtonClick = (Screen, Bundle) -> Unit

@Composable
fun MainScreen(
    onButtonClick: OnButtonClick
) {
    val listState: LazyListState = rememberLazyListState()
    val viewModel: MainViewModel = viewModel(MainViewModel::class.java)
    val scrollBehavior: TopAppBarScrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val context: Context = LocalContext.current
    val mainScreenState by viewModel.uiState.collectAsState()
    val mainState = mainScreenState as MainScreenState.MainScreen

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            Toolbar(
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Fab {
                    val intent = Intent(context, ComposeActivity::class.java)
                    context.startActivity(intent)
                }
            }
        },
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(mainState.list) { screenData ->
                ListItem(
                    text = {
                        Text(
                            text = stringResource(screenData.titleRes)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onButtonClick(screenData.screen, screenData.args) }
                )
            }
        }
    }
}

@Composable
private fun Toolbar(
    scrollBehavior: TopAppBarScrollBehavior
) {
    SmallTopAppBar(
        title = {
            Text(
                text = "Views"
            )
        },
        modifier = Modifier.statusBarsPadding(),
        scrollBehavior = scrollBehavior
    )
}

@Composable
private fun Fab(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    AppTheme {
        MainScreen(
            onButtonClick = { _: Screen, _: Bundle -> }
        )
    }
}

@Preview
@Composable
private fun MainScreenPreviewDark() {
    AppTheme(
        darkTheme = true
    ) {
        MainScreen(
            onButtonClick = { _: Screen, _: Bundle -> }
        )
    }
}