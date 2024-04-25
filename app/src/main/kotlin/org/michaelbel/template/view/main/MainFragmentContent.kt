@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.template.view.main

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.core.os.bundleOf
import androidx.lifecycle.viewmodel.compose.viewModel

typealias OnButtonClick = (Int, Bundle) -> Unit

@Composable
fun MainFragmentContent(
    onNavigateBack: () -> Unit,
    onButtonClick: OnButtonClick
) {
    val listState: LazyListState = rememberLazyListState()
    val viewModel: MainViewModel = viewModel(MainViewModel::class.java)
    val mainScreenState by viewModel.uiState.collectAsState()
    val mainState = mainScreenState as MainScreenState.MainScreen

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        text = "Views"
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
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            items(mainState.list) { destination ->
                Button(
                    onClick = {
                        onButtonClick(destination.fragmentId, bundleOf())
                    }
                ) {
                    Text(
                        text = stringResource(destination.titleRes)
                    )
                }
            }
        }
    }
}