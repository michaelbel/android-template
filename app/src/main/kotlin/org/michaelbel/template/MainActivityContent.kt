@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.template

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.michaelbel.template.ui.TemplateTheme

@Composable
internal fun MainActivityContent(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()
    var selectedRoute by remember { mutableStateOf("compose") }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    TemplateTheme {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Template"
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    NavigationBarItem(
                        selected = selectedRoute == "compose",
                        onClick = { selectedRoute = "compose" },
                        icon = {
                           Icon(
                               imageVector = Icons.Outlined.Refresh,
                               contentDescription = null
                           )
                        },
                        label = {
                            Text(
                                text = "Compose"
                            )
                        }
                    )

                    NavigationBarItem(
                        selected = selectedRoute == "view",
                        onClick = { selectedRoute = "view" },
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.Build,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = "View"
                            )
                        }
                    )
                }
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                message = "How do you do?",
                                actionLabel = "Ok"
                            )
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Phone,
                        contentDescription = null
                    )
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navHostController,
                startDestination = selectedRoute
            ) {
                composable("compose") {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {}
                        ) {
                            Text(
                                text = "Compose"
                            )
                        }
                    }
                }
                composable("view") {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {}
                        ) {
                            Text(
                                text = "View"
                            )
                        }
                    }
                }
            }
        }
    }
}