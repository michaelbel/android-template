package org.michaelbel.template.features.main.ui

import android.content.res.Configuration
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainDrawerContent(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        content = { Text("Close Drawer") }
    )
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
private fun MainDrawerContentPreview() {
    MainDrawerContent(
        onClick = {}
    )
}