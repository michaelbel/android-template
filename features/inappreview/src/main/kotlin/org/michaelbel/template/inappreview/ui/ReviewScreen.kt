package org.michaelbel.template.inappreview.ui

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.inappreview.R

@Composable
fun ReviewScreen(
    navController: NavController,
    onButtonClick: () -> Unit
) {
    Scaffold(
        topBar = {
            Toolbar(navController)
        }
    ) {
        Content(
            onButtonClick = onButtonClick
        )
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(stringResource(R.string.title_in_app_review))
        },
        modifier = Modifier
            .statusBarsPadding(),
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                OutlinedButton(
                    onClick = { onButtonClick() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.title_in_app_review)
                    )
                }
            }
        }
    }
}

@Preview(
    name = "default",
    group = "previews",
    apiLevel = 31,
    widthDp = -1,
    heightDp = -1,
    locale = "en",
    fontScale = 1F,
    showSystemUi = false,
    showBackground = false,
    backgroundColor = 0,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    device = Devices.PIXEL_4_XL
)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ScreenPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    ReviewScreen(
        navController = navController,
        onButtonClick = {}
    )
}