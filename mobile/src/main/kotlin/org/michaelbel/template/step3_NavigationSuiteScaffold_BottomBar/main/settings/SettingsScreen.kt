@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.template.step3_NavigationSuiteScaffold_BottomBar.main.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.shared.icons.Github
import org.michaelbel.shared.middleLargeIncreasedListItemShape
import org.michaelbel.template.ui.settings.SettingsViewModel
import org.michaelbel.template.ui.settings.intent.SettingsIntent

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = koinViewModel()
) {
    val state by viewModel.stateFlow.collectAsStateWithLifecycle()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Settings"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                scrollBehavior = scrollBehavior
            )
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(middleLargeIncreasedListItemShape)
                        .clickable { viewModel.dispatch(SettingsIntent.ToggleDynamicColors) },
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surfaceContainerHighest),
                    headlineContent = {
                        Text(
                            text = "Dynamic Colors",
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    supportingContent = {
                        Text(
                            text = "Apply colors from Wallpaper",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    leadingContent = {
                        Icon(
                            imageVector = Github,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = state.dynamicColorsEnabled,
                            onCheckedChange = null
                        )
                    }
                )
            }
        }
    }
}
