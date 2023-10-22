package org.michaelbel.template.phonecalls.ui

import android.Manifest
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.core.ktx.granted
import org.michaelbel.template.phonecalls.viewmodel.PhoneCallsViewModel
import org.michaelbel.template.phonecalls.R
import org.michaelbel.template.phonecalls.model.PhoneCallLog

@Composable
fun PhoneCallsScreen(
    navController: NavController
) {
    val viewModel: PhoneCallsViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            Toolbar(
                navController = navController
            )
        }
    ) {
        Content(viewModel)
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_phone_calls)
            )
        },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun Content(
    viewModel: PhoneCallsViewModel
) {
    val context: Context = LocalContext.current

    var permissionGranted: Boolean by remember {
        mutableStateOf(Manifest.permission.READ_CALL_LOG.granted(context))
    }

    val readCallLogsPermission = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted: Boolean ->
        permissionGranted = granted
        if (granted) {
            viewModel.readCallLog()
        }
    }

    val logs: List<PhoneCallLog> by viewModel.logs.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ) {
        if (logs.isNotEmpty()) {
            val listState: LazyListState = rememberLazyListState()

            LazyColumn(
                state = listState,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(logs) { log: PhoneCallLog ->
                    PhoneLogLayout(log)
                }
            }
        } else {
            Button(
                onClick = {
                    if (permissionGranted) {
                        viewModel.readCallLog()
                    } else {
                        readCallLogsPermission.launch(Manifest.permission.READ_CALL_LOG)
                    }
                },
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Text(
                    text = "Read Call Log"
                )
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    PhoneCallsScreen(
        navController = navController
    )
}

@Preview
@Composable
private fun ScreenPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    PhoneCallsScreen(
        navController = navController
    )
}