package org.michaelbel.template.features.clipboard

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.ui.TopAppBar
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R
import org.michaelbel.template.ui.AppTheme

@Composable
fun ClipboardScreen(
    onNavigationBackClick: OnNavigationBackClick
) {
    AppTheme {
        Column {
            ClipboardTopBar(onNavigationBackClick = onNavigationBackClick)
            ClipboardBox()
        }
    }
}

@Composable
fun ClipboardTopBar(
    modifier: Modifier = Modifier,
    onNavigationBackClick: OnNavigationBackClick
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_clipboard)) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = { onNavigationBackClick() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        },
        elevation = 2.dp
    )
}

@Composable
fun ClipboardBox(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel(ClipboardViewModel::class.java)

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
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.paste_from_clipboard)) }
            }
            item {
                OutlinedButton(
                    onClick = { viewModel.clearClipboard() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.clear_clipboard)) }
            }
        }
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ClipboardScreenPreview() {
    ClipboardScreen(
        onNavigationBackClick = {}
    )
}