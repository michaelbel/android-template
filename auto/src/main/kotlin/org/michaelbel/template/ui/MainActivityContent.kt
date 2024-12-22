@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.template.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.MainViewModel
import org.michaelbel.template.ui.details2.DetailsScreen2
import org.michaelbel.template.ui.details2.empty.DetailsEmptyScreen
import org.michaelbel.template.ui.list.ListScreen

@Composable
fun MainActivityContent(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel()
) {
    val navHostController = rememberNavController()
    var selectedRoute by remember { mutableStateOf<TabNavigation>(TabNavigation.Home) }
    val listDetailPaneScaffoldNavigator = rememberListDetailPaneScaffoldNavigator<AppNavigation.Details>()

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            item(
                selected = selectedRoute == TabNavigation.Home,
                onClick = { selectedRoute = TabNavigation.Home },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = null
                    )
                }
            )
            item(
                selected = selectedRoute == TabNavigation.Settings,
                onClick = { selectedRoute = TabNavigation.Settings },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = null
                    )
                }
            )
            item(
                selected = selectedRoute == TabNavigation.About,
                onClick = { selectedRoute = TabNavigation.About },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null
                    )
                }
            )
        }
    ) {
        NavHost(
            navController = navHostController,
            startDestination = selectedRoute
        ) {
            composable<TabNavigation.Home> {
                ListDetailPaneScaffold(
                    directive = listDetailPaneScaffoldNavigator.scaffoldDirective,
                    value = listDetailPaneScaffoldNavigator.scaffoldValue,
                    listPane = {
                        AnimatedPane(
                            modifier = Modifier
                                .navigationBarsPadding()
                                .fillMaxWidth(0.5F)
                        ) {
                            ListScreen(
                                onClick = { listDetailPaneScaffoldNavigator.navigateTo(ListDetailPaneScaffoldRole.Detail, AppNavigation.Details(it)) }
                            )
                        }
                    },
                    detailPane = {
                        AnimatedPane(
                            modifier = Modifier.fillMaxWidth(0.5F)
                        ) {
                            when {
                                listDetailPaneScaffoldNavigator.currentDestination?.content != null -> {
                                    DetailsScreen2(
                                        id = listDetailPaneScaffoldNavigator.currentDestination?.content?.id!!
                                    )
                                }
                                else -> {
                                    DetailsEmptyScreen()
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            composable<TabNavigation.Settings> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Settings"
                    )
                }
            }
            composable<TabNavigation.About> {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "About"
                    )
                }
            }
        }
    }
}