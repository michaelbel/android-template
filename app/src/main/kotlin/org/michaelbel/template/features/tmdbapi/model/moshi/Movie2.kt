package org.michaelbel.template.features.tmdbapi.model.moshi

import com.squareup.moshi.Json

data class Movie2(
    @Json(name = "id") val id: Int,
    @Json(name = "imdb_id") val imdbId: String,
    @Json(name = "adult") val adult: Boolean,
    @Json(name = "backdrop_path") val backdropPath: String,
    @Json(name = "budget") val budget: Int,
    @Json(name = "homepage") val homepage: String,
    @Json(name = "original_language") val originalLanguage: String,
    @Json(name = "original_title") val originalTitle: String,
    @Json(name = "overview") val overview: String,
    @Json(name = "popularity") val popularity: Double,
    @Json(name = "poster_path") val posterPath: String,
    @Json(name = "release_date") val releaseDate: String,
    @Json(name = "revenue") val revenue: Long,
    @Json(name = "runtime") val runtime: Int,
    @Json(name = "status") val status: String,
    @Json(name = "tagline") val tagline: String,
    @Json(name = "title") val title: String,
    @Json(name = "video") val video: Boolean,
    @Json(name = "vote_average") val voteAverage: Float,
    @Json(name = "vote_count") val voteCount: Int,
    @Json(name = "media_type") val mediaType: String,
    @Json(name = "genre_ids") val genreIds: List<Int>
)