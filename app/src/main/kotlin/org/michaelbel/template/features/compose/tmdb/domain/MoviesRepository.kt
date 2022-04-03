package org.michaelbel.template.features.compose.tmdb.domain

import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.michaelbel.core.coroutines.IoDispatcher
import org.michaelbel.core.model.Either
import org.michaelbel.core.model.handle
import org.michaelbel.template.features.compose.tmdb.data.local.MovieDb
import org.michaelbel.template.features.compose.tmdb.data.remote.Movie
import org.michaelbel.template.features.compose.tmdb.data.remote.Result
import org.michaelbel.template.features.compose.tmdb.domain.local.MoviesLocalDataSource
import org.michaelbel.template.features.compose.tmdb.domain.remote.MoviesRemoteDataSource

class MoviesRepository @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MoviesLocalDataSource
) {

    suspend fun movieEither(
        movieId: Long,
        apiKey: String,
        language: String,
        addToResponse: String
    ): Either<Movie> {
        return remoteDataSource.movieEither(movieId, apiKey, language, addToResponse)
    }

    suspend fun searchMovies(
        apiKey: String,
        language: String,
        query: String,
        page: Int,
        adult: Boolean,
        region: String
    ): Result<Movie> {
        return remoteDataSource.searchMovies(apiKey, language, query, page, adult, region)
    }

    suspend fun movie(
        movieId: Long,
        apiKey: String,
        language: String,
        addToResponse: String
    ): Flow<Either<MovieDb>> {
        return flow {
            remoteDataSource.movieEither(
                movieId = movieId,
                apiKey = apiKey,
                language = language,
                addToResponse = addToResponse
            ).handle(
                success = { movie: Movie ->
                    localDataSource.insertMovie(movie.transform())
                    emit(Either.Success(localDataSource.movie(movieId)))
                },
                failure = { throwable: Throwable ->
                    emit(Either.Failure(throwable))
                }
            )
        }.flowOn(dispatcher)
    }

    suspend fun movieCached(movieId: Long): Flow<Either<MovieDb>> {
        return flow {
            localDataSource.movieEither(
                movieId = movieId
            ).handle(
                success = {
                    emit(Either.Success(localDataSource.movie(movieId)))
                },
                failure = { throwable: Throwable ->
                    emit(Either.Failure(throwable))
                }
            )
        }.flowOn(dispatcher)
    }
}