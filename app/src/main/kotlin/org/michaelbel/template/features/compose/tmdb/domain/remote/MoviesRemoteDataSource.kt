package org.michaelbel.template.features.compose.tmdb.domain.remote

import javax.inject.Inject
import org.michaelbel.core.model.Either
import org.michaelbel.core.model.response
import org.michaelbel.template.features.compose.tmdb.data.remote.Movie
import org.michaelbel.template.features.compose.tmdb.data.remote.Result

class MoviesRemoteDataSource @Inject constructor(
    private val moviesApi: MoviesApi
) {

    suspend fun movie(
        movieId: Long,
        apiKey: String,
        language: String,
        addToResponse: String
    ): Movie {
        return moviesApi.movie(movieId, apiKey, language, addToResponse)
    }

    suspend fun movieEither(
        movieId: Long,
        apiKey: String,
        language: String,
        addToResponse: String
    ): Either<Movie> {
        return response { moviesApi.movie(movieId, apiKey, language, addToResponse) }
    }

    suspend fun movies(
        list: String,
        apiKey: String,
        language: String,
        page: Int
    ): Result<Movie> = moviesApi.movies(list, apiKey, language, page)

    suspend fun searchMovies(
        apiKey: String,
        language: String,
        query: String,
        page: Int,
        adult: Boolean,
        region: String
    ): Result<Movie> {
        return moviesApi.searchMovies(apiKey, language, query, page, adult, region)
    }
}