package org.michaelbel.template.features.intents.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ui.Scaffold
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R
import org.michaelbel.template.features.intents.model.IntentItem

typealias OnButtonClick = (IntentItem) -> Unit

@Composable
fun IntentsScreen(
    onNavigationBackClick: OnNavigationBackClick,
    onButtonClick: OnButtonClick
) {
    Scaffold(
        topBar = { Toolbar(onNavigationBackClick) }
    ) { Content(onButtonClick = onButtonClick) }
}

@Composable
private fun Toolbar(onNavigationBackClick: OnNavigationBackClick) {
    SmallTopAppBar(
        title = { Text(text = stringResource(R.string.title_intents)) },
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
private fun Content(
    modifier: Modifier = Modifier,
    onButtonClick: OnButtonClick
) {
    Box(modifier = modifier.fillMaxWidth(1F)) {
        LazyColumn {
            item {
                OutlinedButton(
                    onClick = { onButtonClick(IntentItem.Share) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.share_intent)) }
            }
            item {
                OutlinedButton(
                    onClick = { onButtonClick(IntentItem.Email) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.email_intent)) }
            }
            item {
                OutlinedButton(
                    onClick = { onButtonClick(IntentItem.GooglePlay) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.google_play)) }
            }
            item {
                OutlinedButton(
                    onClick = { onButtonClick(IntentItem.OpenTelegramChat) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 16.dp)
                ) { Text(text = stringResource(R.string.open_telegram_chat)) }
            }
        }
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun IntentScreenPreview() {
    IntentsScreen(
        onNavigationBackClick = {},
        onButtonClick = {}
    )
}