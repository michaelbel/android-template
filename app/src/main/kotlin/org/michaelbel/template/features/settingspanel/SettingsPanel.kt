package org.michaelbel.template.features.settingspanel

import android.content.res.Configuration
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.michaelbel.template.R
import org.michaelbel.template.ui.AppTheme

typealias OnButtonClick = (String) -> Unit

@RequiresApi(29)
@Composable
fun SettingsPanel(onButtonClick: OnButtonClick) {
    AppTheme {
        Column {
            SettingsPanelTopBar()
            SettingsPanelBox(onButtonClick = onButtonClick)
        }
    }
}

@Composable
fun SettingsPanelTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_settings_panel)) },
        modifier = modifier,
        elevation = 2.dp
    )
}

@RequiresApi(29)
@Composable
fun SettingsPanelBox(
    modifier: Modifier = Modifier,
    onButtonClick: OnButtonClick
) {
    Box(modifier = modifier.fillMaxWidth(1F)) {
        LazyColumn {
            item {
                OutlinedButton(
                    onClick = { onButtonClick(Settings.Panel.ACTION_INTERNET_CONNECTIVITY) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.settings_panel_connectivity)) }
            }
            item {
                OutlinedButton(
                    onClick = { onButtonClick(Settings.Panel.ACTION_NFC) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.settings_panel_nfc)) }
            }
            item {
                OutlinedButton(
                    onClick = { onButtonClick(Settings.Panel.ACTION_VOLUME) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.settings_panel_volume)) }
            }
            item {
                OutlinedButton(
                    onClick = { onButtonClick(Settings.Panel.ACTION_WIFI) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
                ) { Text(text = stringResource(R.string.settings_panel_wifi)) }
            }
        }
    }
}

@RequiresApi(29)
@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SettingsPanelPreview() {
    SettingsPanel {}
}