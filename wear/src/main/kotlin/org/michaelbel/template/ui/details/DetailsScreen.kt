@file:OptIn(ExperimentalHorologistApi::class)

package org.michaelbel.template.ui.details

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnState
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberColumnState
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = koinViewModel()
) {
    val appEntity by viewModel.appEntity.collectAsStateWithLifecycle()
    val columnState: ScalingLazyColumnState = rememberColumnState()

    ScreenScaffold(
        modifier = modifier
    ) {
        ScalingLazyColumn(
            columnState = columnState
        ) {
            item {
                AsyncImage(
                    model = appEntity.picture,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                )
            }
            item {
                Text(
                    text = appEntity.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            item {
                Text(
                    text = appEntity.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
                )
            }
        }
    }
}