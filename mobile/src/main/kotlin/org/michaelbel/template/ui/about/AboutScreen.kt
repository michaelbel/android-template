@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.template.ui.about

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import org.michaelbel.shared.bottomListItemShape
import org.michaelbel.shared.icons.Github
import org.michaelbel.shared.icons.Telegram
import org.michaelbel.shared.topListItemShape

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "About"
                    )
                }
            )
        }
    ) { innerPadding ->
        val layoutDirection = LocalLayoutDirection.current

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = innerPadding.calculateStartPadding(layoutDirection),
                top = innerPadding.calculateTopPadding().plus(16.dp),
                end = innerPadding.calculateEndPadding(layoutDirection),
                bottom = innerPadding.calculateBottomPadding().plus(16.dp)
            )
        ) {
            item {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(topListItemShape)
                        .clickable {},
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.inversePrimary),
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
                            contentDescription = null,
                            modifier = Modifier.size(IconButtonDefaults.smallIconSize)
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
                        .padding(horizontal = 16.dp)
                        .clip(bottomListItemShape)
                        .clickable {},
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.inversePrimary),
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
                            contentDescription = null,
                            modifier = Modifier.size(IconButtonDefaults.smallIconSize)
                        )
                    }
                )
            }
        }
    }
}
