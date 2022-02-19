package org.michaelbel.template.features.compose.tmdb.domain

import javax.inject.Inject
import org.michaelbel.template.features.compose.tmdb.data.Movie
import org.michaelbel.template.features.compose.tmdb.data.Result

class MoviesRepository @Inject constructor(
    private val moviesApi: MoviesApi
) {

    suspend fun movie(
        movieId: Long,
        apiKey: String,
        language: String,
        addToResponse: String
    ): Movie = moviesApi.movie(movieId, apiKey, language, addToResponse)

    suspend fun movies(
        list: String,
        apiKey: String,
        language: String,
        page: Int
    ): Result<Movie> = moviesApi.movies(list, apiKey, language, page)
}