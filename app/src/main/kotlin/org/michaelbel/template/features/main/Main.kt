package org.michaelbel.template.features.main

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.michaelbel.template.R
import org.michaelbel.template.Screen
import org.michaelbel.template.ui.AppTheme

typealias OnButtonClick = (Screen, Bundle) -> Unit

@Composable
fun Main(
    onUpdateAppClicked: () -> Unit,
    onNavigationIconClick: () -> Unit,
    onButtonClick: OnButtonClick
) {
    val viewModel = viewModel(MainViewModel::class.java)
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val context: Context = LocalContext.current
    val snackBarUpdateVisibleState by rememberUpdatedState(viewModel.updateAvailableMessage)

    val onShowSnackBar: (String, String) -> Unit = { message, actionLabel ->
        coroutineScope.launch {
            val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                duration = SnackbarDuration.Long
            )
            if (snackBarResult == SnackbarResult.ActionPerformed) {
                onUpdateAppClicked()
            }
        }
    }

    AppTheme {
        Scaffold(scaffoldState = scaffoldState) {
            Box(modifier = Modifier.fillMaxSize()) {
                MainTopBar(
                    onNavigationIconClick = onNavigationIconClick,
                    onAccountIconClick = {

                    },
                    modifier = Modifier.align(Alignment.TopCenter)
                )
                LazyColumn(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 56.dp)
                ) {
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.InAppReview, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_in_app_review)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.SavedState, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_saved_state)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Toast, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_toast)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Insets, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_window_insets)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Paging, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_paging)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Ads, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_ads)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = {
                                onButtonClick(
                                    Screen.NavArgs,
                                    bundleOf(
                                        "firstText" to "Some Text",
                                        "secondNumber" to 100
                                    )
                                )
                            },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_nav_args)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Config, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_remote_config)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.MaterialYou, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_material_you_colors)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Fonts, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_fonts)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Social, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_social)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Notifications, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_notifications)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.ConstraintsChains, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_constraints_chains)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.ConstraintsGuideline, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_constraints_guideline)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.ConstraintsConstrainedWidth, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_constraints_constrained_width)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.ConstraintsCircular, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_constraints_circular)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.ConstraintsGoneMargins, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_constraints_gone_margins)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Intents, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_intents)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.SettingsPanel, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_settings_panel)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.SystemServices, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                        ) { Text(text = stringResource(R.string.title_system_services)) }
                    }
                    item {
                        OutlinedButton(
                            onClick = { onButtonClick(Screen.Dialogs, bundleOf()) },
                            modifier = Modifier
                                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 16.dp)
                        ) { Text(text = stringResource(R.string.title_dialogs)) }
                    }
                }
            }
        }
    }

    if (snackBarUpdateVisibleState) {
        onShowSnackBar(
            context.getString(R.string.message_in_app_update_new_version_available),
            context.getString(R.string.action_update)
        )
    }
}

@Composable
fun MainTopBar(
    onNavigationIconClick: () -> Unit,
    onAccountIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.cd_menu)
                )
            }
        },
        elevation = 2.dp,
        actions = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                IconButton(onClick = onAccountIconClick) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = stringResource(R.string.cd_account)
                    )
                }
            }
        }
    )
}


@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainPreview() {
    Main(
        onUpdateAppClicked = {},
        onButtonClick = { _: Screen, _: Bundle -> },
        onNavigationIconClick = {}
    )
}