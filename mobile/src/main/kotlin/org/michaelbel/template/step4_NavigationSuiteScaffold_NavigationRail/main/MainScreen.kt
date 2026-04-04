@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.template.step4_NavigationSuiteScaffold_NavigationRail.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import org.michaelbel.template.step4_NavigationSuiteScaffold_NavigationRail.main.about.AboutScreen
import org.michaelbel.template.step4_NavigationSuiteScaffold_NavigationRail.main.home.HomeScreen
import org.michaelbel.template.step4_NavigationSuiteScaffold_NavigationRail.main.settings.SettingsScreen
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

    val windowAdaptiveInfo = currentWindowAdaptiveInfo()
    val navigationSuiteType = NavigationSuiteScaffoldDefaults.navigationSuiteType(windowAdaptiveInfo)
    val isNavigationRail = navigationSuiteType == NavigationSuiteType.WideNavigationRailCollapsed

    NavigationSuiteScaffold(
        layoutType = navigationSuiteType,
        navigationSuiteItems = {
            item(
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

            item(
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

            item(
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
    ) {
        when (selectedTab) {
            TabNavigation.Home -> {
                HomeScreen(
                    isNavigationRail = isNavigationRail,
                    onNavigateToDetails = onNavigateToDetails
                )
            }
            TabNavigation.Settings -> {
                SettingsScreen(
                    isNavigationRail = isNavigationRail
                )
            }
            TabNavigation.About -> {
                AboutScreen(
                    isNavigationRail = isNavigationRail
                )
            }
        }
    }
}
