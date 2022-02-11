package org.michaelbel.template.features.compose.system

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R
import org.michaelbel.template.ui.theme.AppTheme

/**
 * Vibrate
 * Google Voice Input
 * GooglePlay is Available
 * Connectivity
 * Bluetooth
 * Battery is Charging
 * Battery Level
 */

@Composable
fun SystemScreen(
    navController: NavController
) {
    val viewModel: SystemViewModel = hiltViewModel()

    Scaffold(
        topBar = { Toolbar(navController) }
    ) {
        Content(
            viewModel = viewModel
        )
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = { Text(text = stringResource(R.string.title_system_services)) },
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

@Composable
private fun Content(
    viewModel: SystemViewModel
) {
    val context: Context = LocalContext.current

    val isPlayAvailable: Boolean by rememberUpdatedState(viewModel.isPlayAvailable)
    val isOnline: Boolean by rememberUpdatedState(viewModel.isOnline)
    val isConnectedWifi: Boolean by rememberUpdatedState(viewModel.isConnectedWifi)
    val isBluetoothEnabled: Boolean by rememberUpdatedState(viewModel.isBluetoothEnabled)
    val isBatteryCharging: Boolean by rememberUpdatedState(viewModel.isBatteryCharging)
    val batteryLevel: Int by rememberUpdatedState(viewModel.batteryLevel)

    val speechRecognizeContract = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        val data: Intent? = activityResult.data
        val spokenText: String? =
            data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.let { results ->
                results[0]
            }
        Toast.makeText(context, spokenText, Toast.LENGTH_SHORT).show()
    }

    LazyColumn {
        item {
            OutlinedButton(
                onClick = {
                    viewModel.vibrate()
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.button_vibrate)) }
        }
        item {
            OutlinedButton(
                onClick = {
                    val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                        putExtra(
                            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                        )
                    }
                    speechRecognizeContract.launch(intent)
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.button_voice)) }
        }
        item {
            Text(
                text = stringResource(
                    if (isPlayAvailable) {
                        R.string.play_services_available
                    } else {
                        R.string.play_services_not_available
                    }
                ),
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            )
        }
        item {
            Text(
                text = stringResource(
                    if (isOnline) {
                        R.string.internet_connected
                    } else {
                        R.string.internet_not_connected
                    }
                ),
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            )
        }
        item {
            Text(
                text = stringResource(
                    if (isConnectedWifi) {
                        R.string.wifi_connected
                    } else {
                        R.string.wifi_not_connected
                    }
                ),
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            )
        }
        item {
            Text(
                text = stringResource(
                    if (isBluetoothEnabled) {
                        R.string.bluetooth_enabled
                    } else {
                        R.string.bluetooth_disabled
                    }
                ),
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            )
        }
        item {
            Text(
                text = stringResource(
                    if (isBatteryCharging) {
                        R.string.battery_charging
                    } else {
                        R.string.battery_not_charging
                    }
                ),
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            )
        }
        item {
            Text(
                text = context.getString(R.string.battery_level, batteryLevel).plus("%"),
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun SystemPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    AppTheme {
        SystemScreen(
            navController = navController
        )
    }
}

@Preview
@Composable
private fun SystemPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    AppTheme(
        darkTheme = true
    ) {
        SystemScreen(
            navController = navController
        )
    }
}