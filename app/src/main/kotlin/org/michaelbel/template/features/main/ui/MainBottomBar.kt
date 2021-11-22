package org.michaelbel.template.features.main.ui

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainBottomBar() {
    NavigationBar {
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(
                        Icons.Filled.List,
                        contentDescription = "Favorite"
                    )
                }
            },
            label = { Text("Yellow") },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("7") } }) {
                    Icon(
                        Icons.Filled.List,
                        contentDescription = "Favorite"
                    )
                }
            },
            label = { Text("Black") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("6") } }) {
                    Icon(
                        Icons.Filled.List,
                        contentDescription = "Favorite"
                    )
                }
            },
            label = { Text("White") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("5") } }) {
                    Icon(
                        Icons.Filled.List,
                        contentDescription = "Favorite"
                    )
                }
            },
            label = { Text("Red") },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
fun MainBottomBarPreview() {
    MainBottomBar()
}