@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.template

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.michaelbel.template.ui.TemplateTheme

@Composable
fun MainActivityContent(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()
    var selectedRoute by remember { mutableStateOf("home") }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    TemplateTheme {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Android Template"
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    NavigationBarItem(
                        selected = selectedRoute == "home",
                        onClick = { selectedRoute = "home" },
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
                        selected = selectedRoute == "chat",
                        onClick = { selectedRoute = "chat" },
                        icon = {
                            BadgedBox(
                                badge = {
                                    this@BottomAppBar.AnimatedVisibility(
                                        visible = selectedRoute != "chat",
                                        enter = fadeIn(),
                                        exit = fadeOut()
                                    ) {
                                        Box(
                                            contentAlignment = Alignment.Center,
                                            modifier = Modifier
                                                .size(24.dp)
                                                .background(color = Color.Red, shape = CircleShape)
                                        ) {
                                            Text(
                                                text = "12",
                                                color = Color.White,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Medium
                                            )
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Outlined.Chat,
                                    contentDescription = null
                                )
                            }
                        },
                        label = {
                            Text(
                                text = "Chat"
                            )
                        }
                    )

                    NavigationBarItem(
                        selected = selectedRoute == "settings",
                        onClick = { selectedRoute = "settings" },
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
                                message = "Single-line snackbar with action",
                                actionLabel = "Action"
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
                composable("home") {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Home"
                        )
                    }
                }
                composable("chat") {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Chat"
                        )
                    }
                }
                composable("settings") {
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
            }
        }
    }
}