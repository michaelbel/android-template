package org.michaelbel.template.features.tmdb_api.api

import org.michaelbel.template.features.tmdb_api.model.Movie
import org.michaelbel.template.features.tmdb_api.model.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/{list}")
    suspend fun movies(
        @Path("list") list: String,
        @Query("api_key") apiKey: String,
        @Query("language") lang: String,
        @Query("page") page: Int
    ): Result<Movie>
}