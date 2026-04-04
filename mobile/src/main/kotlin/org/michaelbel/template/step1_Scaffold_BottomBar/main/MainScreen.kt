@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.template.step1_Scaffold_BottomBar.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.michaelbel.template.step1_Scaffold_BottomBar.main.about.AboutScreen
import org.michaelbel.template.step1_Scaffold_BottomBar.main.home.HomeScreen
import org.michaelbel.template.step1_Scaffold_BottomBar.main.settings.SettingsScreen
import org.michaelbel.template.ui.TabNavigation

@Composable
fun MainScreen(
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable(
        stateSaver = Saver(
            save = { tab: TabNavigation ->
                when (tab) {
                    TabNavigation.Home -> 0
                    TabNavigation.Settings -> 1
                    TabNavigation.About -> 2
                }
            },
            restore = { index: Int ->
                when (index) {
                    1 -> TabNavigation.Settings
                    2 -> TabNavigation.About
                    else -> TabNavigation.Home
                }
            }
        )
    ) { mutableStateOf(TabNavigation.Home) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                NavigationBarItem(
                    selected = selectedTab == TabNavigation.Home,
                    onClick = { selectedTab = TabNavigation.Home },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "Home"
                        )
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == TabNavigation.Settings,
                    onClick = { selectedTab = TabNavigation.Settings },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "Settings"
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedTab == TabNavigation.About,
                    onClick = { selectedTab = TabNavigation.About },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "About"
                        )
                    }
                )
            }
        }
    ) { innerPadding ->
        when (selectedTab) {
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
