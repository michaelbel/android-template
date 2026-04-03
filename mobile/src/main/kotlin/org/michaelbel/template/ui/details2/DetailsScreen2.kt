package org.michaelbel.template.ui.details2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.michaelbel.shared.ktx.isTabletLandscape
import org.michaelbel.template.ui.details2.intent.Details2Intent

@Composable
fun DetailsScreen2(
    id: Int,
    viewModel: DetailsViewModel2 = koinViewModel()
) {
    val state by viewModel.stateFlow.collectAsStateWithLifecycle()
    val appEntity = state.appEntity

    LaunchedEffect(id) {
        viewModel.dispatch(Details2Intent.SetId(id))
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(end = 16.dp)
                .fillMaxSize()
        ) {
            item {
                AsyncImage(
                    model = appEntity.picture,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(if (isTabletLandscape) 400.dp else 220.dp)
                )
            }
            item {
                Text(
                    text = appEntity.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            item {
                Text(
                    text = appEntity.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                )
            }
        }
    }
}
