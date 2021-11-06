package org.michaelbel.template.features.dialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.michaelbel.template.R
import org.michaelbel.template.ui.AppTheme

typealias OnButtonClick = (DialogItem) -> Unit

@Composable
fun DialogsScreen(onButtonClick: OnButtonClick) {
    AppTheme {
        Column {
            DialogsTopBar()
            DialogsBox(onButtonClick = onButtonClick)
        }
    }
}

@Composable
fun DialogsTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_dialogs)) },
        modifier = modifier,
        elevation = 2.dp
    )
}

@Composable
fun DialogsBox(
    modifier: Modifier = Modifier,
    onButtonClick: OnButtonClick
) {
    Box(modifier = modifier.fillMaxWidth(1F)) {
        LazyColumn {
            item {
                OutlinedButton(
                    onClick = { onButtonClick(DialogItem.BottomSheet) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.bottom_sheet)) }
            }
            item {
                OutlinedButton(
                    onClick = { onButtonClick(DialogItem.DatePicker) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.date_picker)) }
            }
            item {
                OutlinedButton(
                    onClick = { onButtonClick(DialogItem.TimePicker) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
                ) { Text(text = stringResource(R.string.time_picker)) }
            }
        }
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DialogsPreview() {
    DialogsScreen {}
}