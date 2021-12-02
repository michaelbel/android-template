package org.michaelbel.template.features.networkimage

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ui.TopAppBar
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R
import org.michaelbel.template.ui.utils.NetworkImage

@Composable
fun NetworkImageScreen(
    onNavigationBackClick: OnNavigationBackClick
) {
    Column {
        NetworkImageTopBar(onNavigationBackClick = onNavigationBackClick)
        NetworkImageBox()
    }
}

@Composable
fun NetworkImageTopBar(
    modifier: Modifier = Modifier,
    onNavigationBackClick: OnNavigationBackClick
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_network_image)) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = { onNavigationBackClick() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        },
        elevation = 0.dp
    )
}

@Composable
fun NetworkImageBox(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        NetworkImage(
            url = "https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg",
            contentDescription = null,
            modifier = Modifier
                .size(280.dp)
                .clip(CircleShape)
        )
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ClipboardScreenPreview() {
    NetworkImageScreen(onNavigationBackClick = {})
}