@file:OptIn(ExperimentalHorologistApi::class)

package org.michaelbel.template.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.wear.compose.foundation.lazy.items
import coil.compose.AsyncImage
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnState
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.template.room.AppEntity
import org.michaelbel.template.ui.AppTheme

@Composable
fun ListScreen(
    onClick: (Int) -> Unit,
    navigateToSettings: () -> Unit,
    navigateToAbout: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ListViewModel = koinViewModel()
) {
    val entities by viewModel.appEntities.collectAsStateWithLifecycle()
    val columnState: ScalingLazyColumnState = rememberResponsiveColumnState()

    ScreenScaffold(
        modifier = modifier,
        scrollState = columnState
    ) {
        ScalingLazyColumn(
            columnState = columnState
        ) {
            items(entities) { entity ->
                ListElement(
                    entity = entity,
                    onCLick = onClick
                )
            }
            item {
                Row {
                    IconButton(
                        onClick = navigateToSettings,
                        colors = IconButtonDefaults.iconButtonColors().copy(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    IconButton(
                        onClick = navigateToAbout,
                        modifier = Modifier.padding(start = 8.dp),
                        colors = IconButtonDefaults.iconButtonColors().copy(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ListElement(
    entity: AppEntity,
    onCLick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .clickable { onCLick(entity.id) }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = entity.picture,
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Text(
                text = entity.name,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun ListElementPreview() {
    AppTheme {
        ListElement(
            entity = AppEntity(0, "", "", ""),
            onCLick = {}
        )
    }
}