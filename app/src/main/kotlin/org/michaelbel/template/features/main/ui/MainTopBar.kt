package org.michaelbel.template.features.main.ui

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R

@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior?,
    onNavigationBackClick: OnNavigationBackClick,
    onMenuClick: () -> Unit
) {
    SmallTopAppBar(
        title = { Text(text = "Views") },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(
                onClick = { onNavigationBackClick() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.cd_menu)
                )
            }
        },
        actions = {
            IconButton(onClick = { onMenuClick() }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = stringResource(R.string.cd_settings)
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
private fun MainTopBarPreview() {
    MainTopBar(
        scrollBehavior = null,
        onNavigationBackClick = {},
        onMenuClick = {}
    )
}