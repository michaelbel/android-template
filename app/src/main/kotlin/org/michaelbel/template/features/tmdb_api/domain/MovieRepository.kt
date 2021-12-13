package org.michaelbel.template.features.tmdb_api.domain

import javax.inject.Inject
import org.michaelbel.template.app.model.Result
import org.michaelbel.template.features.tmdb_api.api.MovieApi
import org.michaelbel.template.features.tmdb_api.model.Movie

class MovieRepository @Inject constructor(private val movieApi: MovieApi) {

    suspend fun getMovies(
        list: String,
        apiKey: String,
        language: String,
        page: Int
    ): Result<Movie> = movieApi.movies(list, apiKey, language, page)
}