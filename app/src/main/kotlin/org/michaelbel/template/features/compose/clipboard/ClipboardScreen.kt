package org.michaelbel.template.features.compose.clipboard

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.insets.ui.Scaffold
import kotlinx.coroutines.launch
import org.michaelbel.template.R

@Composable
fun ClipboardScreen(
    navController: NavController
) {
    val viewModel: ClipboardViewModel = hiltViewModel()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val clipText by rememberUpdatedState(viewModel.clipText)

    val onShowSnackbar: (CharSequence) -> Unit = { message ->
        scope.launch {
            scaffoldState.snackbarHostState.showSnackbar(
                message = message.toString(),
                duration = SnackbarDuration.Short
            )
        }
    }

    if (clipText.isNotEmpty()) {
        onShowSnackbar(clipText)
    }

    Scaffold(
        scaffoldState = scaffoldState,
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
        title = { Text(text = stringResource(R.string.title_clipboard)) },
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
    viewModel: ClipboardViewModel
) {
    LazyColumn {
        item {
            OutlinedButton(
                onClick = { viewModel.copyText() },
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.copy_to_clipboard)) }
        }
        item {
            OutlinedButton(
                onClick = { viewModel.pasteText() },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.paste_from_clipboard)) }
        }
        item {
            OutlinedButton(
                onClick = { viewModel.clearClipboard() },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.clear_clipboard)) }
        }
    }
}