package org.michaelbel.template.features.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import org.michaelbel.template.R
import org.michaelbel.template.Screen
import org.michaelbel.template.features.main.model.ScreenData
import org.michaelbel.template.ui.theme.AppTheme
import org.michaelbel.template.ui.theme.Red80

@Composable
fun MainListItem(
    screenData: ScreenData,
    onClick: (screenData: ScreenData) -> Unit,
    shape: Shape = RectangleShape,
    elevation: Dp = AppTheme.elevations.card,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        shape = shape,
        elevation = elevation
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(color = Red80, shape = RoundedCornerShape(16.dp))
            .clickable(onClick = { onClick(screenData) })
        ) {
            Text(
                text = stringResource(screenData.titleRes),
                style = titleStyle,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
            )
        }
    }
}

@Preview
@Composable
private fun MainListItemPreview() {
    val screenData = ScreenData(Screen.NetworkImage, bundleOf(), R.string.title_network_image)
    MainListItem(
        screenData = screenData,
        onClick = { screenData }
    )
}