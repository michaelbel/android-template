package org.michaelbel.template

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.material3.samples.ButtonSample
import androidx.compose.material3.samples.ButtonWithIconSample
import androidx.compose.material3.samples.ColorSchemeSample
import androidx.compose.material3.samples.ElevatedButtonSample
import androidx.compose.material3.samples.ExtendedFloatingActionButtonSample
import androidx.compose.material3.samples.FilledTonalButtonSample
import androidx.compose.material3.samples.FloatingActionButtonSample
import androidx.compose.material3.samples.IconButtonSample
import androidx.compose.material3.samples.IconToggleButtonSample
import androidx.compose.material3.samples.LargeFloatingActionButtonSample
import androidx.compose.material3.samples.OutlinedButtonSample
import androidx.compose.material3.samples.SmallFloatingActionButtonSample
import androidx.compose.material3.samples.TextButtonSample
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.michaelbel.template.ui.theme.AppTheme

fun launchComposeActivity(context: Context) {
    val intent = Intent(context, ComposeActivity::class.java)
    context.startActivity(intent)
}

class ComposeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MySmallTopAppBar()
                //ColorSchemeSample()
                //SimpleSmallTopAppBar()
                //SimpleCenterAlignedTopAppBar()
                //EnterAlwaysSmallTopAppBar()
                //ExitUntilCollapsedMediumTopAppBar()
                //ExitUntilCollapsedLargeTopAppBar()
                //AlertDialogSample()
                //AlertDialogWithIconSample()
                //NavigationBarItemWithBadge()
                //NavigationDrawerSample()
                //ExtendedFloatingActionButtonSample()
                //FloatingActionButtonSample()
                //LargeFloatingActionButtonSample()
                //SmallFloatingActionButtonSample()
                //NavigationBarSample()
                //NavigationBarWithOnlySelectedLabelsSample()
                //NavigationRailBottomAlignSample()
                //NavigationRailSample()
                //NavigationRailWithOnlySelectedLabelsSample()
                //AppIcons()
                //DrawIcon()
            }
        }
    }
}

sealed class Pages {
    object List : Pages()
    object Colors : Pages()
}

@Composable
fun MySmallTopAppBar() {
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
    val page = remember { mutableStateOf<Pages>(Pages.List) }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        drawerContent = {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                },
                content = { Text("Close Drawer") }
            )
        },
        bottomBar = {
            MyNavigationBarItemWithBadge {
                page.value = it
            }
        },
        floatingActionButton = {
            // Use only 1 and remove column
            Column(horizontalAlignment = Alignment.End) {
                SmallFloatingActionButtonSample()
                FloatingActionButtonSample()
                LargeFloatingActionButtonSample()
                ExtendedFloatingActionButtonSample()
            }
        },
        topBar = {
            SmallTopAppBar(
                title = { Text("Small TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    // RowScope here, so these icons will be placed horizontally
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        content = { innerPadding ->

            when (page.value) {
                Pages.Colors -> ColorSchemeSample()
                Pages.List -> {


                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        contentPadding = innerPadding,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {


                        item {

                            Text(text = if (scaffoldState.drawerState.isClosed) ">>> Swipe to open or close drawer >>>" else "<<< Swipe <<<")
                            Spacer(Modifier.height(20.dp))
                            Button(onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }) {
                                Text("Click to open drawer")
                            }
                        }
                        item {
                            ButtonSample()
                            ButtonWithIconSample()
                            ElevatedButtonSample()
                            FilledTonalButtonSample()
                            OutlinedButtonSample()
                            TextButtonSample()
                        }

                        item {
                            IconButtonSample()
                            IconToggleButtonSample()
                        }
                        item {


                            Text(
                                text = "typography.displayLarge",
                                style = MaterialTheme.typography.displayLarge
                            )
                            Text(
                                text = "typography.displayMedium",
                                style = MaterialTheme.typography.displayMedium
                            )
                            Text(
                                text = "typography.displaySmall",
                                style = MaterialTheme.typography.displaySmall
                            )
                            Text(
                                text = "typography.headlineLarge",
                                style = MaterialTheme.typography.headlineLarge
                            )
                            Text(
                                text = "typography.headlineMedium",
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Text(
                                text = "typography.headlineSmall",
                                style = MaterialTheme.typography.headlineSmall
                            )
                            Text(
                                text = "typography.titleLarge",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "typography.titleMedium",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "typography.titleSmall",
                                style = MaterialTheme.typography.titleSmall
                            )
                            Text(
                                text = "typography.bodyLarge",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = "typography.bodyMedium",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "typography.bodySmall",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "typography.labelLarge",
                                style = MaterialTheme.typography.labelLarge
                            )
                            Text(
                                text = "typography.labelMedium",
                                style = MaterialTheme.typography.labelMedium
                            )
                            Text(
                                text = "typography.labelSmall",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }

                    }
                }
            }
        }
    )
}

@Composable
fun MyNavigationBarItemWithBadge(navigate: (Pages) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(
                        Icons.Filled.List,
                        contentDescription = "Favorite"
                    )
                }
            },
            selected = true,
            onClick = {
                navigate(Pages.List)
            }
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(
                        Icons.Filled.Palette,
                        contentDescription = "Favorite"
                    )
                }
            },
            selected = false,
            onClick = {
                navigate(Pages.Colors)
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        MySmallTopAppBar()
    }
}