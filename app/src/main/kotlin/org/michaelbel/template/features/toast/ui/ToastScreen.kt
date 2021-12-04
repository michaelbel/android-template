package org.michaelbel.template.features.toast.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R

typealias OnButtonClick = () -> Unit

@Composable
fun ToastScreen(
    onNavigationBackClick: OnNavigationBackClick,
    onButtonClick: OnButtonClick
) {
    Scaffold(
        topBar = { Toolbar(onNavigationBackClick) }
    ) { Content(onButtonClick) }
}

@Composable
private fun Toolbar(onNavigationBackClick: OnNavigationBackClick) {
    SmallTopAppBar(
        title = { Text(stringResource(id = R.string.title_toast)) },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = onNavigationBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        }
    )
}

@Composable
private fun Content(onButtonClick: OnButtonClick) {
    Box {
        Button(
            onClick = { onButtonClick() },
            modifier = Modifier.align(Alignment.Center).padding(start = 16.dp)
        ) {
            Text(text = stringResource(R.string.show_toast))
        }
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ToastScreenPreview() {
    ToastScreen(
        onButtonClick = {},
        onNavigationBackClick = {}
    )
}