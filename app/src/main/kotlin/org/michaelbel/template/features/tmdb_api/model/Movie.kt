package org.michaelbel.template.features.tmdb_api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("id") val id: Int,
    @SerialName("imdb_id") val imdbId: String,
    @SerialName("adult") val adult: Boolean,
    @SerialName("backdrop_path") val backdropPath: String,
    @SerialName("budget") val budget: Int,
    @SerialName("homepage") val homepage: String,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("revenue") val revenue: Long,
    @SerialName("runtime") val runtime: Int,
    @SerialName("status") val status: String,
    @SerialName("tagline") val tagline: String,
    @SerialName("title") val title: String,
    @SerialName("video") val video: Boolean,
    @SerialName("vote_average") val voteAverage: Float,
    @SerialName("vote_count") val voteCount: Int,
    @SerialName("media_type") val mediaType: String,
    @SerialName("genre_ids") val genreIds: List<Int>
)