package org.michaelbel.template.features.compose.tmdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.michaelbel.core.model.handle
import org.michaelbel.template.features.compose.tmdb.data.Movie
import org.michaelbel.template.features.compose.tmdb.data.TMDB_API_KEY
import org.michaelbel.template.features.compose.tmdb.domain.MovieUseCase
import timber.log.Timber

@HiltViewModel
class TmdbViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
): ViewModel() {

    val movieFlow: Flow<Movie> = flow {
        movieUseCase(
            MovieUseCase.Params(
                movieId = 634649,
                apiKey = TMDB_API_KEY,
                language = Locale.getDefault().language,
                addToResponse = ""
            )
        ).handle(
            success = { movie: Movie ->
                emit(movie)
            },
            failure = {
                emit(Movie.empty())
            }
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = Movie.empty()
    )

    private val _movie: MutableStateFlow<Movie> = MutableStateFlow(Movie.empty())
    val movie: StateFlow<Movie>
        get() = _movie.asStateFlow()

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
                    _movie.emit(movie)
                },
                failure = { throwable: Throwable ->
                    Timber.e(throwable)
                }
            )
        }
    }
}