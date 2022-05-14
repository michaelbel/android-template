package org.michaelbel.template.features.compose.networkimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R

@Composable
fun NetworkImageScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            Toolbar(navController)
        }
    ) {
        Content()
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_network_image)
            )
        },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
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
    val painter = rememberImagePainter(
        data = "https://picsum.photos/300/300",
        builder = {
            crossfade(true)
        }
    )

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painter,
            contentDescription = null
        )

        when (painter.state) {
            is ImagePainter.State.Loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            is ImagePainter.State.Error -> {}
            is ImagePainter.State.Empty -> {}
            is ImagePainter.State.Success -> {}
        }
    }
}