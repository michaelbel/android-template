package org.michaelbel.template.features.main

import android.content.res.Configuration
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import org.michaelbel.template.R
import org.michaelbel.template.Screen

typealias OnButtonClick = (Screen, Bundle) -> Unit
typealias OnNavigationIconClick = () -> Unit

@Composable
fun Main(
    onButtonClick: OnButtonClick
) {
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            MainTopBar(
                onNavigationIconClick = {},
                modifier = Modifier.align(Alignment.TopCenter)
            )
            LazyColumn(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 100.dp)
            ) {
                item {
                    Button(onClick = { onButtonClick(Screen.InAppReview, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_in_app_review))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.InAppUpdate, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_in_app_update))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.SavedState, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_saved_state))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.Toast, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_toast))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.Insets, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_window_insets))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.Paging, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_paging))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.Ads, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_ads))
                    }
                }
                item {
                    Button(
                        onClick = {
                            onButtonClick(
                                Screen.NavArgs,
                                bundleOf(
                                    "firstText" to "Some Text",
                                    "secondNumber" to 100
                                )
                            )
                        }
                    ) {
                        Text(text = stringResource(R.string.title_nav_args))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.Config, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_remote_config))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.MaterialYou, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_material_you_colors))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.Fonts, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_fonts))
                    }
                }
                item {
                    Button(onClick = { onButtonClick(Screen.Search, bundleOf()) }) {
                        Text(text = stringResource(R.string.title_search))
                    }
                }
            }
        }
    }
}

@Composable
fun MainTopBar(
    onNavigationIconClick: OnNavigationIconClick,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.content_description_menu_main)
                )
            }
        },
        elevation = 2.dp
    )
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainPreview() {
    Main(onButtonClick = { _: Screen, _: Bundle -> })
}