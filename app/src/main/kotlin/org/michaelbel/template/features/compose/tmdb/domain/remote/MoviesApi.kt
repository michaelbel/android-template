package org.michaelbel.template.features.compose.tmdb.domain.remote

import org.michaelbel.template.features.compose.tmdb.data.remote.Movie
import org.michaelbel.template.features.compose.tmdb.data.remote.Result
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

    @GET("movie/{movie_id}")
    suspend fun movie(
        @Path("movie_id") id: Long,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("append_to_response") appendToResponse: String
    ): Movie

    @GET("search/movie?")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("include_adult") adult: Boolean,
        @Query("region") region: String
    ): Result<Movie>
}