package org.michaelbel.template.features.compose.config

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R

@Composable
fun RemoteConfigScreen(
    navController: NavController
) {
    val viewModel: RemoteConfigViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            Toolbar(navController)
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
        title = { Text(text = stringResource(R.string.title_remote_config)) },
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
    viewModel: RemoteConfigViewModel
) {
    val context: Context = LocalContext.current
    val remoteParam: Any? by rememberUpdatedState(viewModel.customRemoteParam)

    if (remoteParam != null) {
        Toast.makeText(context, remoteParam.toString(), Toast.LENGTH_SHORT).show()
    }

    Box(
        modifier = Modifier.fillMaxWidth(1F)
    ) {
        LazyColumn {
            item {
                OutlinedButton(
                    onClick = { viewModel.takeBooleanParam() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.button_fetch_boolean)) }
            }
            item {
                OutlinedButton(
                    onClick = { viewModel.takeStringParam() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.button_fetch_string)) }
            }
            item {
                OutlinedButton(
                    onClick = { viewModel.takeNumberParam() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 16.dp)
                ) { Text(text = stringResource(R.string.button_fetch_number)) }
            }
        }
    }
}