package org.michaelbel.template.remoteconfig.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.michaelbel.template.remoteconfig.R
import org.michaelbel.template.remoteconfig.viewmodel.RemoteConfigViewModel

@Composable
fun RemoteConfigScreen(
    navController: NavController
) {
    val viewModel: RemoteConfigViewModel = hiltViewModel()
    val scope: CoroutineScope = rememberCoroutineScope()
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }

    val onShowSnackbar: (String) -> Unit = { message ->
        scope.launch {
            snackbarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Short
            )
        }
    }

    Scaffold(
        topBar = {
            Toolbar(navController)
        }
    ) {
        Content(
            viewModel = viewModel,
            snackbarHostState = snackbarHostState,
            onShowSnackbar = onShowSnackbar
        )
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_remote_config)
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
    viewModel: RemoteConfigViewModel,
    snackbarHostState: SnackbarHostState,
    onShowSnackbar: (String) -> Unit
) {
    val remoteParam: Any? by viewModel.customRemoteParam.collectAsState()

    if (remoteParam != null) {
        onShowSnackbar(remoteParam.toString())
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                OutlinedButton(
                    onClick = {
                        viewModel.takeBooleanParam()
                    },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.button_fetch_boolean)
                    )
                }
            }
            item {
                OutlinedButton(
                    onClick = {
                        viewModel.takeStringParam()
                    },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.button_fetch_string)
                    )
                }
            }
            item {
                OutlinedButton(
                    onClick = {
                        viewModel.takeNumberParam()
                    },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.button_fetch_number)
                    )
                }
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}