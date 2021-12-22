package org.michaelbel.template.features.tmdb_api.domain

import javax.inject.Inject
import org.michaelbel.template.features.tmdb_api.api.MoviesApi
import org.michaelbel.template.features.tmdb_api.model.Movie
import org.michaelbel.template.features.tmdb_api.model.Result

class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi) {

    suspend fun movies(
        list: String,
        apiKey: String,
        language: String,
        page: Int
    ): Result<Movie> = moviesApi.movies(list, apiKey, language, page)
}