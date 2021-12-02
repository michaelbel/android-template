package org.michaelbel.template.features.dialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ui.TopAppBar
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R
import org.michaelbel.template.features.dialog.model.DialogItem
import org.michaelbel.template.ui.components.CustomAlertDialog

typealias OnButtonClick = (DialogItem) -> Unit

@Composable
fun DialogsScreen(
    onNavigationBackClick: OnNavigationBackClick,
    onButtonClick: OnButtonClick
) {
    Column {
        DialogsTopBar(onNavigationBackClick = onNavigationBackClick)
        DialogsBox(onButtonClick = onButtonClick)
    }
}

@Composable
fun DialogsTopBar(
    onNavigationBackClick: OnNavigationBackClick
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_dialogs)) },
        navigationIcon = {
            IconButton(onClick = onNavigationBackClick) {
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
fun DialogsBox(
    modifier: Modifier = Modifier,
    onButtonClick: OnButtonClick
) {
    var alertDialogShown by remember { mutableStateOf(false) }
    if (alertDialogShown) {
        CustomAlertDialog { alertDialogShown = false }
    }

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
            item {
                OutlinedButton(
                    onClick = { alertDialogShown = true },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
                ) { Text(text = stringResource(R.string.alert_dialog)) }
            }
        }
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DialogsScreenPreview() {
    DialogsScreen(
        onNavigationBackClick = {},
        onButtonClick = {}
    )
}