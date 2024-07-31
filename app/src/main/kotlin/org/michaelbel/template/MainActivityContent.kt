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
import androidx.fragment.compose.AndroidFragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.michaelbel.template.compose.ContextualScreen
import org.michaelbel.template.ui.TemplateTheme
import org.michaelbel.template.view.ConstrainsBaselineFragment
import org.michaelbel.template.view.ConstrainsChainsFragment
import org.michaelbel.template.view.ConstrainsCircularFragment
import org.michaelbel.template.view.ConstrainsConstrainedWidthFragment
import org.michaelbel.template.view.ConstrainsFlowFragment
import org.michaelbel.template.view.ConstrainsGoneMarginsFragment
import org.michaelbel.template.view.ConstrainsGuidelineFragment

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
                startDestination = selectedRoute,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("compose") {
                    val composeNavHostController = rememberNavController()

                    NavHost(
                        navController = composeNavHostController,
                        startDestination = "compose-home"
                    ) {
                        composable("compose-home") {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {
                                        composeNavHostController.navigate("contextual")
                                    }
                                ) {
                                    Text(
                                        text = "Contextual"
                                    )
                                }
                            }
                        }
                        composable("contextual") {
                            ContextualScreen(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
                composable("view") {
                    val viewNavHostController = rememberNavController()

                    NavHost(
                        navController = viewNavHostController,
                        startDestination = "view-home"
                    ) {
                        composable("view-home") {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {
                                        viewNavHostController.navigate("baseline")
                                    }
                                ) {
                                    Text(
                                        text = "Baseline"
                                    )
                                }

                                Button(
                                    onClick = {
                                        viewNavHostController.navigate("chains")
                                    }
                                ) {
                                    Text(
                                        text = "Chains"
                                    )
                                }

                                Button(
                                    onClick = {
                                        viewNavHostController.navigate("circular")
                                    }
                                ) {
                                    Text(
                                        text = "Circular"
                                    )
                                }

                                Button(
                                    onClick = {
                                        viewNavHostController.navigate("width")
                                    }
                                ) {
                                    Text(
                                        text = "Width"
                                    )
                                }

                                Button(
                                    onClick = {
                                        viewNavHostController.navigate("flow")
                                    }
                                ) {
                                    Text(
                                        text = "Flow"
                                    )
                                }

                                Button(
                                    onClick = {
                                        viewNavHostController.navigate("gone")
                                    }
                                ) {
                                    Text(
                                        text = "Gone"
                                    )
                                }

                                Button(
                                    onClick = {
                                        viewNavHostController.navigate("guideline")
                                    }
                                ) {
                                    Text(
                                        text = "Guideline"
                                    )
                                }
                            }
                        }
                        composable("baseline") {
                            AndroidFragment(
                                clazz = ConstrainsBaselineFragment::class.java,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        composable("chains") {
                            AndroidFragment(
                                clazz = ConstrainsChainsFragment::class.java,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        composable("circular") {
                            AndroidFragment(
                                clazz = ConstrainsCircularFragment::class.java,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        composable("width") {
                            AndroidFragment(
                                clazz = ConstrainsConstrainedWidthFragment::class.java,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        composable("flow") {
                            AndroidFragment(
                                clazz = ConstrainsFlowFragment::class.java,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        composable("gone") {
                            AndroidFragment(
                                clazz = ConstrainsGoneMarginsFragment::class.java,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        composable("guideline") {
                            AndroidFragment(
                                clazz = ConstrainsGuidelineFragment::class.java,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}