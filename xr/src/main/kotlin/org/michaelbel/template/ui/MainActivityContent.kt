package org.michaelbel.template.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import androidx.xr.compose.platform.LocalSpatialCapabilities
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.SpatialColumn
import androidx.xr.compose.subspace.SpatialPanel
import androidx.xr.compose.subspace.SpatialRow
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.alpha
import androidx.xr.compose.subspace.layout.fillMaxHeight
import androidx.xr.compose.subspace.layout.height
import androidx.xr.compose.subspace.layout.padding
import androidx.xr.compose.subspace.layout.size
import androidx.xr.compose.subspace.layout.width
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.MainViewModel
import org.michaelbel.template.ui.details2.DetailsScreen2
import org.michaelbel.template.ui.details2.empty.DetailsEmptyScreen
import org.michaelbel.template.ui.list.ListScreen

@Composable
fun MainActivityContent(
    viewModel: MainViewModel = koinViewModel()
) {
    var id by remember { mutableStateOf<Int?>(null) }

    if (LocalSpatialCapabilities.current.isSpatialUiEnabled) {
        SpatialLayout(
            primaryContent = {
                PrimaryContent(
                    id = id
                )
            },
            firstSupportingContent = {
                BlockOfContentOne(
                    onClick = { id = it }
                )
            }
        )
    } else {
        NonSpatialTwoPaneLayout(
            secondaryPane = {
                BlockOfContentOne(
                    onClick = { id = it }
                )
            },
            primaryPane = {
                PrimaryContent(
                    id = id
                )
            }
        )
    }
}

@Composable
private fun SpatialLayout(
    primaryContent: @Composable () -> Unit,
    firstSupportingContent: @Composable () -> Unit
) {
    val animatedAlpha = remember { Animatable(0.5f) }
    LaunchedEffect(Unit) {
        launch {
            animatedAlpha.animateTo(1.0F, animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing))
        }
    }

    Subspace {
        SpatialRow(
            modifier = SubspaceModifier.height(816.dp)
        ) {
            SpatialColumn {
                SpatialPanel(
                    SubspaceModifier.alpha(animatedAlpha.value).size(400.dp).padding(bottom = 16.dp)
                ) {
                    firstSupportingContent()
                }
            }

            SpatialPanel(
                modifier = SubspaceModifier
                    .alpha(animatedAlpha.value)
                    .width(1488.dp)
                    .fillMaxHeight()
                    .padding(left = 16.dp)
            ) {
                primaryContent()
            }
        }
    }
}

@Composable
private fun NonSpatialTwoPaneLayout(
    primaryPane: @Composable () -> Unit,
    secondaryPane: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
) {
    val animatedAlpha = remember { Animatable(0.5f) }
    LaunchedEffect(Unit) {
        launch {
            animatedAlpha.animateTo(
                1.0f,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
        }
    }
    Column(
        modifier = modifier
            .alpha(animatedAlpha.value)
            .padding(16.dp)
            .systemBarsPadding()
    ) {
        Spacer(Modifier.height(16.dp))
        if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT) {
            TopAndBottomPaneLayout(primaryPane, secondaryPane)
        } else {
            SideBySidePaneLayout(primaryPane, secondaryPane)
        }
    }
}

@Composable
private fun SideBySidePaneLayout(
    primaryPane: @Composable () -> Unit,
    secondaryPane: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Surface(
            Modifier
                .width(400.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Column {
                secondaryPane()
            }
        }
        Spacer(Modifier.width(16.dp))
        Surface(modifier.clip(RoundedCornerShape(16.dp))
        ) {
            primaryPane()
        }
    }
}

@Composable
private fun TopAndBottomPaneLayout(
    primaryPane: @Composable () -> Unit,
    secondaryPane: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Surface(Modifier.requiredHeight(500.dp)){
            primaryPane()
        }
        Spacer(Modifier.height(16.dp))
        Surface(
            Modifier
                .requiredHeight(500.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        ) {
            Column {
                secondaryPane()
            }
        }
    }
}

@Composable
private fun PrimaryContent(
    id: Int? = null,
    modifier: Modifier = Modifier
) {
    when {
        id != null -> {
            DetailsScreen2(
                id = id,
                modifier = modifier
            )
        }
        else -> {
            DetailsEmptyScreen(
                modifier = modifier
            )
        }
    }
}

@Composable
private fun BlockOfContentOne(
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    ListScreen(
        onClick = onClick,
        modifier = modifier
    )
}