package org.michaelbel.template.features.tmdbapi.domain

import javax.inject.Inject
import org.michaelbel.template.features.tmdbapi.api.MoviesApi
import org.michaelbel.template.features.tmdbapi.model.Movie
import org.michaelbel.template.features.tmdbapi.model.Result

class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi) {

    suspend fun movies(
        list: String,
        apiKey: String,
        language: String,
        page: Int
    ): Result<Movie> = moviesApi.movies(list, apiKey, language, page)
}