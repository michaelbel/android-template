@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.template.step6_NavigationSuiteScaffold_NavigationRailExpanded.main.about

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import org.michaelbel.shared.bottomListItemShape
import org.michaelbel.shared.icons.Github
import org.michaelbel.shared.icons.Telegram
import org.michaelbel.shared.topListItemShape

@Composable
fun AboutScreen(
    isNavigationRail: Boolean
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val uriHandler = LocalUriHandler.current
    val navBarBottom = if (isNavigationRail) WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() else 0.dp

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "About"
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
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = if (isNavigationRail) navBarBottom else 16.dp
            )
        ) {
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(topListItemShape)
                        .clickable { uriHandler.openUri("https://github.com/michaelbel") },
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surfaceContainerHighest),
                    headlineContent = {
                        Text(
                            text = "GitHub",
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    supportingContent = {
                        Text(
                            text = "View the Repository",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    leadingContent = {
                        Icon(
                            imageVector = Github,
                            contentDescription = null
                        )
                    }
                )
            }
            item {
                Spacer(
                    modifier = Modifier.height(2.dp)
                )
            }
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(bottomListItemShape)
                        .clickable { uriHandler.openUri("https://t.me/android_career") },
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surfaceContainerHighest),
                    headlineContent = {
                        Text(
                            text = "Telegram",
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    supportingContent = {
                        Text(
                            text = "Subscribe to Channel",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    leadingContent = {
                        Icon(
                            imageVector = Telegram,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}
