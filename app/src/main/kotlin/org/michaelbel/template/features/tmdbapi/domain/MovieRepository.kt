package org.michaelbel.template.features.tmdbapi.domain

import javax.inject.Inject
import org.michaelbel.template.features.tmdbapi.api.MovieApi
import org.michaelbel.template.features.tmdbapi.model.moshi.Movie2

class MovieRepository @Inject constructor(private val movieApi: MovieApi) {

    suspend fun movie(
        movieId: Long,
        apiKey: String,
        language: String,
        addToResponse: String
    ): Movie2 = movieApi.movie(movieId, apiKey, language, addToResponse)
}