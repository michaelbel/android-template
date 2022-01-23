package org.michaelbel.template.features.tmdbapi.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.launch
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.Constants
import org.michaelbel.template.features.tmdbapi.domain.MoviesRepository
import org.michaelbel.template.features.tmdbapi.model.Movie
import org.michaelbel.template.features.tmdbapi.model.MoviesList
import org.michaelbel.template.features.tmdbapi.usecase.MovieUseCase

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MoviesRepository,
    private val movieUseCase: MovieUseCase
): ViewModel() {

    init {
        loadingMovies()
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(MovieFragment::class.simpleName)
    }

    private fun loadingMovies() = viewModelScope.launch {
        val movies: List<Movie> = movieRepository.movies(
            MoviesList.NOW_PLAYING.sorting,
            Constants.TMDB_API_KEY,
            Locale.getDefault().language,
            1
        ).results
        Log.e("2580", "movies = $movies")
    }
}