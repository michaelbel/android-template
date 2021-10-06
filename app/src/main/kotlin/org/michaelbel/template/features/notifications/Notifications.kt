package org.michaelbel.template.features.notifications

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.michaelbel.template.R
import org.michaelbel.template.areNotificationsEnabled
import org.michaelbel.template.ui.AppTheme

@Composable
fun Notifications() {
    AppTheme {
        Column {
            NotificationsTopBar()
            NotificationsBox()
        }
    }
}

@Composable
fun NotificationsTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_notifications)) },
        modifier = modifier,
        elevation = 2.dp
    )
}

@Composable
fun NotificationsBox(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val areNotificationsEnabled by remember { mutableStateOf(context.areNotificationsEnabled()) }

    Box(modifier = modifier.fillMaxWidth(1F)) {
        Text(
            text = stringResource(
                if (areNotificationsEnabled) {
                    R.string.notifications_enabled
                } else {
                    R.string.notifications_disabled
                }
            ),
            modifier = modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
        )
        Icon(
            painter = painterResource(
                if (areNotificationsEnabled) {
                    R.drawable.ic_baseline_check_circle_24
                } else {
                    R.drawable.ic_outline_error_24
                }
            ),
            contentDescription = stringResource(
                if (areNotificationsEnabled) {
                    R.string.cd_notifications_enabled
                } else {
                    R.string.cd_notifications_disabled
                }
            ),
            modifier = modifier
                .align(alignment = Alignment.CenterEnd)
                .padding(end = 16.dp),
            tint = colorResource(
                if (areNotificationsEnabled) {
                    R.color.successColor
                } else {
                    R.color.errorColor
                }
            )
        )
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NotificationsPreview() {
    Notifications()
}