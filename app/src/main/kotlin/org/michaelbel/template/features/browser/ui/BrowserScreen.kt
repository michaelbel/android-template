package org.michaelbel.template.features.browser.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R
import org.michaelbel.template.features.browser.model.Browser
import org.michaelbel.template.features.browser.model.BrowserType
import org.michaelbel.template.features.browser.model.InAppBrowser
import org.michaelbel.template.ui.theme.AppTheme

@Composable
fun BrowserScreen(
    onNavigationBackClick: OnNavigationBackClick,
    onClick: (BrowserType) -> Unit
) {
    Scaffold(
        topBar = { Toolbar(onNavigationBackClick) }
    ) {
        Content(onClick = { browserType -> onClick(browserType) })
    }
}

@Composable
private fun Toolbar(onNavigationBackClick: OnNavigationBackClick) {
    SmallTopAppBar(
        title = { Text(text = stringResource(R.string.title_browser)) },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = onNavigationBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        }
    )
}

@Composable
private fun Content(
    onClick: (BrowserType) -> Unit
) {
    LazyColumn {
        item {
            OutlinedButton(
                onClick = { onClick(Browser) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.start_browser)) }
        }
        item {
            OutlinedButton(
                onClick = { onClick(InAppBrowser) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.start_in_app_browser)) }
        }
    }
}

@Preview
@Composable
private fun SettingsPanelPreview() {
    AppTheme {
        BrowserScreen(
            onNavigationBackClick = {},
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun SettingsPanelPreviewDark() {
    AppTheme(darkTheme = true) {
        BrowserScreen(
            onNavigationBackClick = {},
            onClick = {}
        )
    }
}