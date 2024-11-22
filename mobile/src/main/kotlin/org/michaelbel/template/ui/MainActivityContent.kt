@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.template.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.MainViewModel
import org.michaelbel.template.R

@Composable
fun MainActivityContent(
    windowSize: WindowSizeClass,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel()
) {
    val navHostController = rememberNavController()
    var selectedRoute by remember { mutableStateOf<Navigation>(Navigation.Home) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val adaptiveInfo = currentWindowAdaptiveInfo()
    val windowSize = with(LocalDensity.current) {
        currentWindowSize().toSize().toDpSize()
    }

    val navLayoutType = when {
        adaptiveInfo.windowPosture.isTabletop -> NavigationSuiteType.NavigationBar
        adaptiveInfo.windowSizeClass.isCompact() -> NavigationSuiteType.NavigationBar
        adaptiveInfo.windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED && windowSize.width >= 1200.dp -> NavigationSuiteType.NavigationDrawer
        else -> NavigationSuiteType.NavigationRail
    }
    val navContentPosition = when (adaptiveInfo.windowSizeClass.windowHeightSizeClass) {
        WindowHeightSizeClass.COMPACT -> ReplyNavigationContentPosition.TOP
        WindowHeightSizeClass.MEDIUM,
        WindowHeightSizeClass.EXPANDED -> ReplyNavigationContentPosition.CENTER
        else -> ReplyNavigationContentPosition.TOP
    }

    AppTheme {
        NavigationSuiteScaffoldLayout(
            navigationSuite = {
                when (navLayoutType) {
                    NavigationSuiteType.NavigationBar -> {
                        NavigationBar(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            NavigationBarItem(
                                selected = selectedRoute == Navigation.Home,
                                onClick = { selectedRoute = Navigation.Home },
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
                                selected = selectedRoute == Navigation.Chat,
                                onClick = { selectedRoute = Navigation.Chat },
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            this@NavigationBar.AnimatedVisibility(
                                                visible = selectedRoute != Navigation.Chat,
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
                                            imageVector = Icons.Outlined.Email,
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
                                selected = selectedRoute == Navigation.Settings,
                                onClick = { selectedRoute = Navigation.Settings },
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
                    }
                    NavigationSuiteType.NavigationRail -> {
                        NavigationRail(
                            modifier = Modifier.fillMaxHeight(),
                            containerColor = MaterialTheme.colorScheme.inverseOnSurface
                        ) {
                            Column(
                                modifier = Modifier.layoutId(LayoutType.HEADER),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                FloatingActionButton(
                                    onClick = {},
                                    modifier = Modifier.padding(top = 8.dp, bottom = 32.dp),
                                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                                Spacer(Modifier.height(8.dp)) // NavigationRailHeaderPadding
                                Spacer(Modifier.height(4.dp)) // NavigationRailVerticalPadding

                                NavigationRailItem(
                                    selected = selectedRoute == Navigation.Home,
                                    onClick = { selectedRoute = Navigation.Home },
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

                                NavigationRailItem(
                                    selected = selectedRoute == Navigation.Chat,
                                    onClick = { selectedRoute = Navigation.Chat },
                                    icon = {
                                        BadgedBox(
                                            badge = {
                                                this@Column.AnimatedVisibility(
                                                    visible = selectedRoute != Navigation.Chat,
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
                                                imageVector = Icons.Outlined.Email,
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

                                NavigationRailItem(
                                    selected = selectedRoute == Navigation.Settings,
                                    onClick = { selectedRoute = Navigation.Settings },
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
                        }
                    }
                    NavigationSuiteType.NavigationDrawer -> {
                        PermanentDrawerSheet(
                            modifier = Modifier.sizeIn(minWidth = 200.dp, maxWidth = 300.dp),
                            drawerContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        ) {
                            Layout(
                                modifier = Modifier
                                    .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                                    .padding(16.dp),
                                content = {
                                    Column(
                                        modifier = Modifier.layoutId(LayoutType.HEADER),
                                        horizontalAlignment = Alignment.Start,
                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Text(
                                            modifier = Modifier
                                                .padding(16.dp),
                                            text = stringResource(id = R.string.app_name).uppercase(),
                                            style = MaterialTheme.typography.titleMedium,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                        ExtendedFloatingActionButton(
                                            onClick = { /*TODO*/ },
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 8.dp, bottom = 40.dp),
                                            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Edit,
                                                contentDescription = null,
                                                modifier = Modifier.size(24.dp)
                                            )
                                            Text(
                                                text = "Compose",
                                                modifier = Modifier.weight(1f),
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }

                                    Column(
                                        modifier = Modifier
                                            .layoutId(LayoutType.CONTENT)
                                            .verticalScroll(rememberScrollState()),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                    ) {
                                        NavigationDrawerItem(
                                            selected = selectedRoute == Navigation.Home,
                                            onClick = { selectedRoute = Navigation.Home },
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

                                        NavigationDrawerItem(
                                            selected = selectedRoute == Navigation.Chat,
                                            onClick = { selectedRoute = Navigation.Chat },
                                            icon = {
                                                BadgedBox(
                                                    badge = {
                                                        this@Column.AnimatedVisibility(
                                                            visible = selectedRoute != Navigation.Chat,
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
                                                        imageVector = Icons.Outlined.Email,
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

                                        NavigationDrawerItem(
                                            selected = selectedRoute == Navigation.Settings,
                                            onClick = { selectedRoute = Navigation.Settings },
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
                                measurePolicy = navigationMeasurePolicy(navContentPosition)
                            )
                        }
                    }
                }
            },
            layoutType = navLayoutType
        ) {
            NavHost(
                navController = navHostController,
                startDestination = selectedRoute,
                //modifier = Modifier.padding(innerPadding)
            ) {
                composable<Navigation.Home> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Home"
                        )
                    }
                }
                composable<Navigation.Chat> {
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
                composable<Navigation.Settings> {
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

        /*Scaffold(
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
                        selected = selectedRoute == Navigation.Home,
                        onClick = { selectedRoute = Navigation.Home },
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
                        selected = selectedRoute == Navigation.Chat,
                        onClick = { selectedRoute = Navigation.Chat },
                        icon = {
                            BadgedBox(
                                badge = {
                                    this@BottomAppBar.AnimatedVisibility(
                                        visible = selectedRoute != Navigation.Chat,
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
                                    imageVector = Icons.Outlined.Email,
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
                        selected = selectedRoute == Navigation.Settings,
                        onClick = { selectedRoute = Navigation.Settings },
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
                composable<Navigation.Home> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Home"
                        )
                    }
                }
                composable<Navigation.Chat> {
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
                composable<Navigation.Settings> {
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
        }*/
    }
}

sealed interface Navigation {

    @Serializable
    data object Home: Navigation

    @Serializable
    data object Chat: Navigation

    @Serializable
    data object Settings: Navigation
}

private fun androidx.window.core.layout.WindowSizeClass.isCompact() =
    windowWidthSizeClass == WindowWidthSizeClass.COMPACT || windowHeightSizeClass == WindowHeightSizeClass.COMPACT

fun navigationMeasurePolicy(
    navigationContentPosition: ReplyNavigationContentPosition,
): MeasurePolicy {
    return MeasurePolicy { measurables, constraints ->
        lateinit var headerMeasurable: Measurable
        lateinit var contentMeasurable: Measurable
        measurables.forEach {
            when (it.layoutId) {
                LayoutType.HEADER -> headerMeasurable = it
                LayoutType.CONTENT -> contentMeasurable = it
                else -> error("Unknown layoutId encountered!")
            }
        }

        val headerPlaceable = headerMeasurable.measure(constraints)
        val contentPlaceable = contentMeasurable.measure(
            constraints.offset(vertical = -headerPlaceable.height)
        )
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place the header, this goes at the top
            headerPlaceable.placeRelative(0, 0)

            // Determine how much space is not taken up by the content
            val nonContentVerticalSpace = constraints.maxHeight - contentPlaceable.height

            val contentPlaceableY = when (navigationContentPosition) {
                // Figure out the place we want to place the content, with respect to the
                // parent (ignoring the header for now)
                ReplyNavigationContentPosition.TOP -> 0
                ReplyNavigationContentPosition.CENTER -> nonContentVerticalSpace / 2
            }
                // And finally, make sure we don't overlap with the header.
                .coerceAtLeast(headerPlaceable.height)

            contentPlaceable.placeRelative(0, contentPlaceableY)
        }
    }
}

enum class ReplyNavigationContentPosition {
    TOP, CENTER
}

enum class LayoutType {
    HEADER, CONTENT
}