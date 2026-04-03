@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.template.compact.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.michaelbel.template.compact.main.about.AboutScreen
import org.michaelbel.template.compact.main.home.HomeScreen
import org.michaelbel.template.compact.main.settings.SettingsScreen
import org.michaelbel.template.ui.TabNavigation

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val selectedTabRoute: TabNavigation = when (selectedTabIndex) {
        1 -> TabNavigation.Settings
        2 -> TabNavigation.About
        else -> TabNavigation.Home
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                NavigationBarItem(
                    selected = selectedTabRoute == TabNavigation.Home,
                    onClick = { selectedTabIndex = 0 },
                    icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) },
                    label = { Text(text = "Home") }
                )
                NavigationBarItem(
                    selected = selectedTabRoute == TabNavigation.Settings,
                    onClick = { selectedTabIndex = 1 },
                    icon = { Icon(imageVector = Icons.Outlined.Settings, contentDescription = null) },
                    label = { Text(text = "Settings") }
                )
                NavigationBarItem(
                    selected = selectedTabRoute == TabNavigation.About,
                    onClick = { selectedTabIndex = 2 },
                    icon = { Icon(imageVector = Icons.Filled.Info, contentDescription = null) },
                    label = { Text(text = "About") }
                )
            }
        }
    ) { innerPadding ->
        when (selectedTabRoute) {
            TabNavigation.Home -> {
                HomeScreen(
                    bottomPadding = innerPadding.calculateBottomPadding(),
                    onNavigateToDetails = onNavigateToDetails
                )
            }
            TabNavigation.Settings -> {
                SettingsScreen(
                    bottomPadding = innerPadding.calculateBottomPadding()
                )
            }
            TabNavigation.About -> {
                AboutScreen(
                    bottomPadding = innerPadding.calculateBottomPadding()
                )
            }
        }
    }
}
