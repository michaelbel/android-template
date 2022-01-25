package org.michaelbel.template.features.compose.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R
import org.michaelbel.template.areNotificationsEnabled

@Composable
fun NotificationsScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { Toolbar(navController) }
    ) { Content() }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = { Text(text = stringResource(R.string.title_notifications)) },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
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
    modifier: Modifier = Modifier
) {
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
                    R.color.Primary
                } else {
                    R.color.Error
                }
            )
        )
    }
}