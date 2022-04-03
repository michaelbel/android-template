package org.michaelbel.template.features.compose.tmdb

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R
import org.michaelbel.template.features.compose.tmdb.data.remote.Movie
import org.michaelbel.template.features.compose.tmdb.data.remote.image

@Composable
fun TmdbScreen(
    navController: NavController
) {
    val viewModel: TmdbViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            Toolbar(navController)
        }
    ) {
        Content(
            viewModel = viewModel
        )
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(text = stringResource(R.string.title_tmdb))
        },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
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
    modifier: Modifier = Modifier,
    viewModel: TmdbViewModel
) {
    val movie: Movie by viewModel.movie.collectAsState()
    val movieResult: Movie by viewModel.movieFlow.collectAsState(initial = Movie.empty())
    val searchResults: List<Movie> by viewModel.searchResults.collectAsState(initial = emptyList())

    val painter = rememberImagePainter(
        data = image(movieResult.posterPath.orEmpty()),
        builder = {
            crossfade(true)
        }
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable { viewModel.setSearchQuery("spider") }
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