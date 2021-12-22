package org.michaelbel.template.features.tmdb_api.api

import org.michaelbel.template.features.tmdb_api.model.moshi.Movie2
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{movie_id}")
    suspend fun movie(
        @Path("movie_id") id: Long,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("append_to_response") appendToResponse: String
    ): Movie2
}