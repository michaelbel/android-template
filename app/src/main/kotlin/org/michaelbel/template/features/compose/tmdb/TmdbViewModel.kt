package org.michaelbel.template.features.compose.tmdb

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.launch
import org.michaelbel.core.model.handle
import org.michaelbel.template.features.compose.tmdb.data.Movie
import org.michaelbel.template.features.compose.tmdb.data.TMDB_API_KEY
import org.michaelbel.template.features.compose.tmdb.domain.MovieUseCase

@HiltViewModel
class TmdbViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
): ViewModel() {

    init {
        viewModelScope.launch {
            movieUseCase(
                MovieUseCase.Params(
                    movieId = 634649,
                    apiKey = TMDB_API_KEY,
                    language = Locale.getDefault().language,
                    addToResponse = ""
                )
            ).handle(
                success = { movie: Movie ->
                    Log.e("2580", "success = $movie")
                },
                failure = { throwable: Throwable ->
                    Log.e("2580", "failure = $throwable")
                }
            )
        }
    }
}