package org.michaelbel.template.movie.domain

import org.michaelbel.template.movie.model.Movie
import org.michaelbel.template.app.model.Result
import org.michaelbel.template.movie.api.MovieApi
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi: MovieApi) {

    suspend fun getMovies(list: String, apiKey: String, language: String, page: Int): Result<Movie> {
        return movieApi.movies(list, apiKey, language, page)
    }
}