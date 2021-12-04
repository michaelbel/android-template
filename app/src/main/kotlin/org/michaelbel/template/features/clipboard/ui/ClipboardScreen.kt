package org.michaelbel.template.features.clipboard.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.launch
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R
import org.michaelbel.template.features.clipboard.ClipboardViewModel

@Composable
fun ClipboardScreen(
    onNavigationBackClick: OnNavigationBackClick
) {
    val viewModel = viewModel(ClipboardViewModel::class.java)
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
        topBar = { Toolbar(onNavigationBackClick) },
        floatingActionButton = {
            Fab {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Snackbar")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.navigationBarsPadding()
            ) {}
        }
    ) { Content(viewModel = viewModel) }
}

@Composable
private fun Toolbar(onNavigationBackClick: OnNavigationBackClick) {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.error,

        title = { Text(text = stringResource(R.string.title_clipboard)) },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = { onNavigationBackClick() }) {
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
    modifier: Modifier = Modifier,
    viewModel: ClipboardViewModel
) {
    Box(modifier = modifier.fillMaxSize()) {
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
}

@Composable
private fun Fab(
    onClick: () -> Unit
) {
    FloatingActionButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = stringResource(R.string.cd_favorite)
        )
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ClipboardScreenPreview() {
    ClipboardScreen(
        onNavigationBackClick = {}
    )
}