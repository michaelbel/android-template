package org.michaelbel.template.clipboard.ui

import android.content.Context
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.michaelbel.template.clipboard.R
import org.michaelbel.template.clipboard.viewmodel.ClipboardViewModel

@Composable
fun ClipboardScreen(
    navController: NavController
) {
    val viewModel: ClipboardViewModel = hiltViewModel()
    val scope: CoroutineScope = rememberCoroutineScope()
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }

    val clipText: String by viewModel.clipText.collectAsState()

    val onShowSnackbar: (String) -> Unit = { message ->
        scope.launch {
            snackbarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Short
            )
        }
    }

    if (clipText.isNotEmpty()) {
        onShowSnackbar(clipText)
    }

    Scaffold(
        topBar = {
            Toolbar(navController)
        }
    ) {
        Content(
            viewModel = viewModel
        )

        SnackbarHost(
            hostState = snackbarHostState
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
                text = stringResource(R.string.title_clipboard)
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
    viewModel: ClipboardViewModel
) {
    LazyColumn {
        item {
            OutlinedButton(
                onClick = {
                    viewModel.copyText()
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 4.dp)
            ) {
                Text(
                    text = stringResource(R.string.copy_to_clipboard)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    viewModel.pasteText()
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) {
                Text(
                    text = stringResource(R.string.paste_from_clipboard)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    viewModel.clearClipboard()
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) {
                Text(
                    text = stringResource(R.string.clear_clipboard)
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

    ClipboardScreen(
        navController = navController
    )
}

@Preview
@Composable
private fun ScreenPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    ClipboardScreen(
        navController = navController
    )
}