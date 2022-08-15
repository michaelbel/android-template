package org.michaelbel.template.ui.compose.lazylist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.core.ktx.dp
import org.michaelbel.template.R

@Composable
fun LazyListScreen(
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
                text = stringResource(R.string.title_lazy_list)
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
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun Content() {
    val donates: MutableList<String> = mutableListOf()
    repeat(100) {
        donates.add("https://picsum.photos/200/300?random=1")
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            count = donates.size,
            itemContent = { index: Int ->
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                ) {
                    val (avatar, name, date) = createRefs()

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(donates[index])
                            .size(40.dp(LocalContext.current))
                            .crossfade(true)
                            .placeholder(R.drawable.splashscreen_icon)
                            .error(R.drawable.splashscreen_icon)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .constrainAs(avatar) {
                                width = Dimension.value(40.dp)
                                height = Dimension.value(40.dp)
                                start.linkTo(parent.start, 16.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            },
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "Name",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier
                            .constrainAs(name) {
                                width = Dimension.fillToConstraints
                                start.linkTo(avatar.end, 12.dp)
                                top.linkTo(avatar.top)
                                end.linkTo(parent.end, 12.dp)
                                bottom.linkTo(date.top)
                            },
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W700
                    )

                    Text(
                        text = "Date",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier
                            .constrainAs(date) {
                                width = Dimension.fillToConstraints
                                start.linkTo(avatar.end, 12.dp)
                                top.linkTo(name.bottom)
                                end.linkTo(parent.end, 12.dp)
                                bottom.linkTo(avatar.bottom)
                            },
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
        )
    }
}