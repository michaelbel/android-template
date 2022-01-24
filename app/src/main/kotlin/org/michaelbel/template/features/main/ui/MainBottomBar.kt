package org.michaelbel.template.features.main.ui

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.ViewQuilt
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.systemBarsPadding
import org.michaelbel.template.R

@Composable
fun MainBottomBar() {
    NavigationBar(
        modifier = Modifier.systemBarsPadding()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.ViewQuilt,
                    contentDescription = stringResource(R.string.bottom_item_compose)
                )
            },
            label = { Text(stringResource(R.string.bottom_item_compose)) },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.CardGiftcard,
                    contentDescription = stringResource(R.string.bottom_item_android)
                )
            },
            label = { Text(stringResource(R.string.bottom_item_android)) },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("1") } }) {
                    Icon(
                        imageVector = Icons.Filled.ListAlt,
                        contentDescription = stringResource(R.string.bottom_item_other)
                    )
                }
            },
            label = { Text(stringResource(R.string.bottom_item_other)) },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
private fun MainBottomBarPreview() {
    MainBottomBar()
}