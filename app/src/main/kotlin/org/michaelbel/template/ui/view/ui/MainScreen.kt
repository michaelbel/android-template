package org.michaelbel.template.ui.view.ui

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import org.michaelbel.template.ui.TemplateTheme
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
    val mainScreenState by viewModel.uiState.collectAsState()
    val mainState = mainScreenState as MainScreenState.MainScreen

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
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
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            items(mainState.list) { screenData ->
                Button(
                    onClick = {
                        onButtonClick(screenData.screen, screenData.args)
                    }
                ) {
                    Text(
                        text = stringResource(screenData.titleRes)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    TemplateTheme {
        MainScreen(
            onButtonClick = { _: Screen, _: Bundle -> }
        )
    }
}