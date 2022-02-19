package org.michaelbel.template.features.compose.tmdb.domain.local

import javax.inject.Inject
import org.michaelbel.core.model.Either
import org.michaelbel.core.model.response
import org.michaelbel.template.features.compose.tmdb.data.local.MovieDb

class MoviesLocalDataSource @Inject constructor(
    private val moviesDao: MovieDao
) {

    suspend fun movieEither(
        movieId: Long,
    ): Either<MovieDb> {
        return response { moviesDao.getMovie(movieId) }
    }

    suspend fun movie(
        movieId: Long,
    ): MovieDb {
        return moviesDao.getMovie(movieId)
    }

    suspend fun insertMovie(
        movieDb: MovieDb
    ) {
        moviesDao.insertMovie(movieDb)
    }
}