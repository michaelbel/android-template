package org.michaelbel.template.features.compose.tmdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.michaelbel.core.model.handle
import org.michaelbel.template.features.compose.tmdb.data.remote.Movie
import org.michaelbel.template.features.compose.tmdb.data.remote.TMDB_API_KEY
import org.michaelbel.template.features.compose.tmdb.domain.MovieUseCase
import org.michaelbel.template.features.compose.tmdb.domain.MoviesRepository
import timber.log.Timber

@HiltViewModel
class TmdbViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val useCase: MovieUseCase
): ViewModel() {

    val movieFlow: Flow<Movie> = flow {
        useCase(
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

    val movieEitherFlow: Flow<Movie> = flow {
        moviesRepository.movieEither(
            movieId = 634649,
            apiKey = TMDB_API_KEY,
            language = Locale.getDefault().language,
            addToResponse = ""
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

    private val searchTrigger = Channel<String>(Channel.CONFLATED)
    val searchResults: Flow<List<Movie>> = searchTrigger
        .receiveAsFlow()
        .mapLatest { query ->
            moviesRepository.searchMovies(
                apiKey = TMDB_API_KEY,
                language = Locale.getDefault().language,
                query = query,
                page = 1,
                adult = true,
                region = ""
            ).results
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            useCase(
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

    fun setSearchQuery(query: String) {
        searchTrigger.trySend(query)
    }
}