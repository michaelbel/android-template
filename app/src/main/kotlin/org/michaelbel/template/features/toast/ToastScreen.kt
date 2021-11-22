package org.michaelbel.template.features.toast

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
            SmallTopAppBar(
                title = { Text(stringResource(id = R.string.title_toast)) },
                navigationIcon = {
                    androidx.compose.material.IconButton(onClick = onNavigationBackClick) {
                        androidx.compose.material.Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.cd_back)
                        )
                    }
                }
            )
            Button(
                onClick = { onButtonClick() },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = stringResource(R.string.show_toast))
            }
        }
    }
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