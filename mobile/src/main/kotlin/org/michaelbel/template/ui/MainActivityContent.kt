@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.template.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowHeightSizeClass
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.core.ktx.isDesktop
import org.michaelbel.core.ktx.isTabletPortrait
import org.michaelbel.core.ktx.navigationSuiteType
import org.michaelbel.template.MainViewModel
import org.michaelbel.template.ui.about.AboutScreen
import org.michaelbel.template.ui.details.DetailsScreen
import org.michaelbel.template.ui.details2.DetailsScreen2
import org.michaelbel.template.ui.details2.empty.DetailsEmptyScreen
import org.michaelbel.template.ui.list.ListScreen
import org.michaelbel.template.ui.settings.SettingsScreen

@Composable
fun MainActivityContent(
    viewModel: MainViewModel = koinViewModel()
) {
    val navHostController = rememberNavController()
    var selectedTabRoute by rememberSaveable { mutableStateOf<TabNavigation>(TabNavigation.Home) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val adaptiveInfo = currentWindowAdaptiveInfo()
    val navContentPosition = when (adaptiveInfo.windowSizeClass.windowHeightSizeClass) {
        WindowHeightSizeClass.COMPACT -> ReplyNavigationContentPosition.TOP
        WindowHeightSizeClass.MEDIUM,
        WindowHeightSizeClass.EXPANDED -> ReplyNavigationContentPosition.CENTER
        else -> ReplyNavigationContentPosition.TOP
    }
    val layoutDirection = LocalLayoutDirection.current

    val listDetailPaneScaffoldNavigator = rememberListDetailPaneScaffoldNavigator<AppNavigation.Details>()

    NavHost(
        navController = navHostController,
        startDestination = AppNavigation.Main,
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.displayCutout)
            .fillMaxSize()
    ) {
        composable<AppNavigation.Main> {
            NavigationSuiteScaffoldLayout(
                navigationSuite = {
                    when (navigationSuiteType) {
                        NavigationSuiteType.NavigationBar -> {
                            NavigationBar(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                NavigationBarItem(
                                    selected = selectedTabRoute == TabNavigation.Home,
                                    onClick = { selectedTabRoute = TabNavigation.Home },
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
                                    selected = selectedTabRoute == TabNavigation.Settings,
                                    onClick = { selectedTabRoute = TabNavigation.Settings },
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
                                    selected = selectedTabRoute == TabNavigation.About,
                                    onClick = { selectedTabRoute = TabNavigation.About },
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
                        NavigationSuiteType.NavigationRail -> {
                            NavigationRail(
                                modifier = Modifier
                                    .fillMaxHeight(),
                                containerColor = MaterialTheme.colorScheme.inverseOnSurface
                            ) {
                                Column(
                                    modifier = Modifier.layoutId(LayoutType.HEADER),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    FloatingActionButton(
                                        onClick = {
                                            coroutineScope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "Single-line snackbar with action",
                                                    actionLabel = "Action",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        },
                                        modifier = Modifier
                                            .statusBarsPadding()
                                            .padding(top = 16.dp),
                                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = null
                                        )
                                    }

                                    Spacer(Modifier.height(16.dp))

                                    NavigationRailItem(
                                        selected = selectedTabRoute == TabNavigation.Home,
                                        onClick = { selectedTabRoute = TabNavigation.Home },
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Outlined.Home,
                                                contentDescription = null
                                            )
                                        }
                                    )

                                    NavigationRailItem(
                                        selected = selectedTabRoute == TabNavigation.Settings,
                                        onClick = { selectedTabRoute = TabNavigation.Settings },
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Outlined.Settings,
                                                contentDescription = null
                                            )
                                        }
                                    )

                                    NavigationRailItem(
                                        selected = selectedTabRoute == TabNavigation.About,
                                        onClick = { selectedTabRoute = TabNavigation.About },
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Outlined.Info,
                                                contentDescription = null
                                            )
                                        }
                                    )
                                }
                            }
                        }
                        NavigationSuiteType.NavigationDrawer -> {
                            PermanentDrawerSheet(
                                modifier = Modifier.sizeIn(
                                    minWidth = 200.dp,
                                    maxWidth = if (isDesktop) 300.dp else 200.dp
                                ),
                                drawerContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh
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
                                            ExtendedFloatingActionButton(
                                                onClick = {
                                                    coroutineScope.launch {
                                                        snackbarHostState.showSnackbar(
                                                            message = "Single-line snackbar with action",
                                                            actionLabel = "Action",
                                                            duration = SnackbarDuration.Short
                                                        )
                                                    }
                                                },
                                                modifier = Modifier
                                                    .statusBarsPadding()
                                                    .fillMaxWidth(),
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
                                                    modifier = Modifier.padding(start = 8.dp),
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
                                                selected = selectedTabRoute == TabNavigation.Home,
                                                onClick = { selectedTabRoute = TabNavigation.Home },
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
                                                selected = selectedTabRoute == TabNavigation.Settings,
                                                onClick = { selectedTabRoute = TabNavigation.Settings },
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

                                            NavigationDrawerItem(
                                                selected = selectedTabRoute == TabNavigation.About,
                                                onClick = { selectedTabRoute = TabNavigation.About },
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
                                    },
                                    measurePolicy = navigationMeasurePolicy(navContentPosition)
                                )
                            }
                        }
                    }
                },
                layoutType = navigationSuiteType
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackbarHostState
                        )
                    },
                    floatingActionButton = {
                        if (navigationSuiteType == NavigationSuiteType.NavigationBar) {
                            ExtendedFloatingActionButton(
                                onClick = {
                                    coroutineScope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "Single-line snackbar with action",
                                            actionLabel = "Action",
                                            duration = SnackbarDuration.Short
                                        )
                                    }
                                },
                                modifier = Modifier.offset(y = 16.dp),
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    contentDescription = null
                                )

                                Text(
                                    text = "Compose",
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    val tabsNavHostController = rememberNavController()

                    NavHost(
                        navController = tabsNavHostController,
                        startDestination = selectedTabRoute,
                        modifier = Modifier
                            .padding(
                                start = innerPadding.calculateStartPadding(layoutDirection),
                                top = 0.dp,
                                end = innerPadding.calculateEndPadding(layoutDirection),
                                bottom = 0.dp
                            )
                            .fillMaxSize()
                    ) {
                        composable<TabNavigation.Home> {
                            when {
                                navigationSuiteType == NavigationSuiteType.NavigationBar || (navigationSuiteType == NavigationSuiteType.NavigationRail && isTabletPortrait) -> {
                                    ListScreen(
                                        onClick = { navHostController.navigate(AppNavigation.Details(it)) },
                                        modifier = if (isTabletPortrait) Modifier.navigationBarsPadding() else Modifier
                                    )
                                }
                                else -> {
                                    ListDetailPaneScaffold(
                                        directive = listDetailPaneScaffoldNavigator.scaffoldDirective,
                                        value = listDetailPaneScaffoldNavigator.scaffoldValue,
                                        listPane = {
                                            AnimatedPane(
                                                modifier = Modifier
                                                    .navigationBarsPadding()
                                                    .then(if (isDesktop) Modifier.preferredWidth(600.dp) else Modifier.fillMaxWidth(0.4F))
                                            ) {
                                                ListScreen(
                                                    onClick = { listDetailPaneScaffoldNavigator.navigateTo(ListDetailPaneScaffoldRole.Detail, AppNavigation.Details(it)) }
                                                )
                                            }
                                        },
                                        detailPane = {
                                            AnimatedPane(
                                                modifier = Modifier.then(if (isDesktop) Modifier else Modifier.fillMaxWidth(0.6F))
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
                            }
                        }
                        composable<TabNavigation.Settings> {
                            SettingsScreen()
                        }
                        composable<TabNavigation.About> {
                            AboutScreen()
                        }
                    }
                }
            }
        }
        composable<AppNavigation.Details> {
            DetailsScreen(
                navigateBack = navHostController::popBackStack
            )
        }
    }
}

fun navigationMeasurePolicy(
    navigationContentPosition: ReplyNavigationContentPosition
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
    TOP,
    CENTER
}

enum class LayoutType {
    HEADER,
    CONTENT
}