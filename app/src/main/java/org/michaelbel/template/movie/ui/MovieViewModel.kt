package org.michaelbel.template.movie.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.withTransaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.Constants
import org.michaelbel.template.app.data.AppDatabase
import org.michaelbel.template.app.data.entity.MovieDb
import org.michaelbel.template.movie.domain.MovieRepository
import org.michaelbel.template.movie.model.MoviesList
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val database: AppDatabase,
    private val movieRepository: MovieRepository,
    private val analytics: Analytics
): ViewModel() {

    val items: Flow<List<MovieDb>> = database.movieDao.getAll()

    init {
        loadingMovies()
        analytics.trackScreen(MovieFragment::class.simpleName)
    }

    private fun loadingMovies() = viewModelScope.launch {
        val movies: List<MovieDb> = withContext(Dispatchers.IO) {
            movieRepository.getMovies(
                MoviesList.NOW_PLAYING.sorting,
                Constants.TMDB_API_KEY,
                Locale.getDefault().language,
                1
            )
        }.results.map { movie -> MovieDb.from(movie) }

        database.withTransaction {
            database.movieDao.clearAll()
            database.movieDao.insertAll(movies)
        }
    }
}