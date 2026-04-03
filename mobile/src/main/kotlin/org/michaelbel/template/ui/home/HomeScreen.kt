@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package org.michaelbel.template.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import kotlinx.coroutines.launch
import org.michaelbel.shared.ktx.isDesktop
import org.michaelbel.shared.ktx.isTabletPortrait
import org.michaelbel.shared.ktx.navigationSuiteType
import org.michaelbel.template.ui.TabNavigation
import org.michaelbel.template.ui.about.AboutScreen
import org.michaelbel.template.ui.details2.DetailsScreen2
import org.michaelbel.template.ui.details2.ui.DetailsEmptyScreen
import org.michaelbel.template.ui.list.ListScreen
import org.michaelbel.template.ui.settings.SettingsScreen

private val composeFabBottomSpacing = 16.dp
private val composeFabHeight = 56.dp
private val listBottomPaddingAboveFab = composeFabHeight + composeFabBottomSpacing + 16.dp

@Composable
fun HomeScreen(
    navContentPosition: ReplyNavigationContentPosition,
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val selectedTabRoute: TabNavigation = when (selectedTabIndex) {
        1 -> TabNavigation.Settings
        2 -> TabNavigation.About
        else -> TabNavigation.Home
    }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val layoutDirection = LocalLayoutDirection.current
    val listDetailPaneScaffoldNavigator = rememberListDetailPaneScaffoldNavigator<DetailsPaneKey>()

    NavigationSuiteScaffoldLayout(
        navigationSuite = {
            when (navigationSuiteType) {
                NavigationSuiteType.NavigationBar -> {
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
                NavigationSuiteType.NavigationRail -> {
                    NavigationRail(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Column(
                            modifier = Modifier.layoutId(LayoutType.HEADER),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            FloatingActionButton(
                                onClick = {
                                    snackbarHostState.currentSnackbarData?.dismiss()
                                    scope.launch {
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
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Edit,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            Spacer(
                                modifier = Modifier.height(16.dp)
                            )

                            NavigationRailItem(
                                selected = selectedTabRoute == TabNavigation.Home,
                                onClick = { selectedTabIndex = 0 },
                                icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) }
                            )

                            NavigationRailItem(
                                selected = selectedTabRoute == TabNavigation.Settings,
                                onClick = { selectedTabIndex = 1 },
                                icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = null) }
                            )

                            NavigationRailItem(
                                selected = selectedTabRoute == TabNavigation.About,
                                onClick = { selectedTabIndex = 2 },
                                icon = { Icon(imageVector = Icons.Filled.Info, contentDescription = null) }
                            )
                        }
                    }
                }
                NavigationSuiteType.NavigationDrawer -> {
                    PermanentDrawerSheet(
                        modifier = Modifier.sizeIn(
                            minWidth = 200.dp,
                            maxWidth = if (isDesktop) 300.dp else 200.dp
                        )
                    ) {
                        Layout(
                            modifier = Modifier.padding(16.dp),
                            content = {
                                Column(
                                    modifier = Modifier.layoutId(LayoutType.HEADER),
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    ExtendedFloatingActionButton(
                                        onClick = {
                                            snackbarHostState.currentSnackbarData?.dismiss()
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "Single-line snackbar with action",
                                                    actionLabel = "Action",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        },
                                        modifier = Modifier
                                            .statusBarsPadding()
                                            .fillMaxWidth()
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Edit,
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )

                                        Text(
                                            text = "Compose",
                                            modifier = Modifier.padding(start = 8.dp)
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
                                        onClick = { selectedTabIndex = 0 },
                                        icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) },
                                        label = { Text(text = "Home") }
                                    )

                                    NavigationDrawerItem(
                                        selected = selectedTabRoute == TabNavigation.Settings,
                                        onClick = { selectedTabIndex = 1 },
                                        icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = null) },
                                        label = { Text(text = "Settings") }
                                    )

                                    NavigationDrawerItem(
                                        selected = selectedTabRoute == TabNavigation.About,
                                        onClick = { selectedTabIndex = 2 },
                                        icon = { Icon(imageVector = Icons.Filled.Info, contentDescription = null) },
                                        label = { Text(text = "About") }
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
                            snackbarHostState.currentSnackbarData?.dismiss()
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "Single-line snackbar with action",
                                    actionLabel = "Action",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        },
                        modifier = Modifier.padding(bottom = composeFabBottomSpacing)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Text(
                            text = "Compose"
                        )
                    }
                }
            },
            contentWindowInsets = WindowInsets(0, 0, 0, 0)
        ) { innerPadding ->
            val contentModifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(layoutDirection),
                    top = 0.dp,
                    end = innerPadding.calculateEndPadding(layoutDirection),
                    bottom = 0.dp
                )
                .fillMaxSize()

            when (selectedTabRoute) {
                TabNavigation.Home -> {
                    when {
                        navigationSuiteType == NavigationSuiteType.NavigationBar ||
                            (navigationSuiteType == NavigationSuiteType.NavigationRail && isTabletPortrait) -> {
                            ListScreen(
                                onClick = onNavigateToDetails,
                                bottomContentPadding = listBottomPaddingAboveFab,
                                modifier = contentModifier
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
                                            .then(
                                                if (isDesktop) Modifier.width(600.dp)
                                                else Modifier.fillMaxWidth(0.4F)
                                            )
                                    ) {
                                        ListScreen(
                                            onClick = {
                                                scope.launch {
                                                    listDetailPaneScaffoldNavigator.navigateTo(
                                                        ListDetailPaneScaffoldRole.Detail,
                                                        DetailsPaneKey(it)
                                                    )
                                                }
                                            }
                                        )
                                    }
                                },
                                detailPane = {
                                    AnimatedPane(
                                        modifier = Modifier.then(
                                            if (isDesktop) Modifier else Modifier.fillMaxWidth(0.6F)
                                        )
                                    ) {
                                        when {
                                            listDetailPaneScaffoldNavigator.currentDestination?.contentKey != null -> {
                                                DetailsScreen2(
                                                    id = listDetailPaneScaffoldNavigator.currentDestination?.contentKey?.id!!
                                                )
                                            }
                                            else -> DetailsEmptyScreen()
                                        }
                                    }
                                },
                                modifier = contentModifier
                            )
                        }
                    }
                }
                TabNavigation.Settings -> SettingsScreen()
                TabNavigation.About -> AboutScreen()
            }
        }
    }
}

private fun navigationMeasurePolicy(
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
            headerPlaceable.placeRelative(0, 0)
            val nonContentVerticalSpace = constraints.maxHeight - contentPlaceable.height
            val contentPlaceableY = when (navigationContentPosition) {
                ReplyNavigationContentPosition.TOP -> 0
                ReplyNavigationContentPosition.CENTER -> nonContentVerticalSpace / 2
            }.coerceAtLeast(headerPlaceable.height)
            contentPlaceable.placeRelative(0, contentPlaceableY)
        }
    }
}

private data class DetailsPaneKey(val id: Int)

enum class ReplyNavigationContentPosition {
    TOP,
    CENTER
}

private enum class LayoutType {
    HEADER,
    CONTENT
}
