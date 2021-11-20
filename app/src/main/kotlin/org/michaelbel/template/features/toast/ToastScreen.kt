package org.michaelbel.template.features.toast

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ui.TopAppBar
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R
import org.michaelbel.template.ui.AppTheme

typealias OnButtonClick = () -> Unit

@Composable
fun ToastScreen(
    onNavigationBackClick: OnNavigationBackClick,
    onButtonClick: OnButtonClick
) {
    AppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            ToastTopBar(onNavigationBackClick = onNavigationBackClick)
            Button(
                onClick = { onButtonClick() },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = stringResource(R.string.show_toast))
            }
        }
    }
}

@Composable
fun ToastTopBar(
    modifier: Modifier = Modifier,
    onNavigationBackClick: OnNavigationBackClick
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_toast)) },
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

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ToastScreenPreview() {
    ToastScreen(
        onButtonClick = {},
        onNavigationBackClick = {}
    )
}