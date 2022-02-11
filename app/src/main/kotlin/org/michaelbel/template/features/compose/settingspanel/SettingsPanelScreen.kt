package org.michaelbel.template.features.compose.settingspanel

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R

/**
 * Settings.Global.getString(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON)
 * 0 if false, 1 if true.
 */

@RequiresApi(29)
@Composable
fun SettingsPanelScreen(
    navController: NavController
) {
    val context: Context = LocalContext.current

    Scaffold(
        topBar = { Toolbar(navController) }
    ) {
        Content(
            onClick = { panel -> context.startActivity(Intent(panel)) }
        )
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = { Text(text = stringResource(R.string.title_settings_panel)) },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        }
    )
}

@RequiresApi(29)
@Composable
private fun Content(
    onClick: (String) -> Unit
) {
    LazyColumn {
        item {
            OutlinedButton(
                onClick = { onClick(Settings.Panel.ACTION_INTERNET_CONNECTIVITY) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.settings_panel_connectivity)) }
        }
        item {
            OutlinedButton(
                onClick = { onClick(Settings.Panel.ACTION_NFC) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.settings_panel_nfc)) }
        }
        item {
            OutlinedButton(
                onClick = { onClick(Settings.Panel.ACTION_VOLUME) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.settings_panel_volume)) }
        }
        item {
            OutlinedButton(
                onClick = { onClick(Settings.Panel.ACTION_WIFI) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
            ) { Text(text = stringResource(R.string.settings_panel_wifi)) }
        }
    }
}