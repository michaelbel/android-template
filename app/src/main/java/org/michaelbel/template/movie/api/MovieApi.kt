package org.michaelbel.template.movie.api

import org.michaelbel.template.app.model.Result
import org.michaelbel.template.movie.model.Movie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{list}")
    suspend fun movies(
        @Path("list") list: String,
        @Query("api_key") apiKey: String,
        @Query("language") lang: String,
        @Query("page") page: Int
    ): Result<Movie>
}