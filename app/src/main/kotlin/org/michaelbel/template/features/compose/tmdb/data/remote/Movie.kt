package org.michaelbel.template.features.compose.tmdb.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.michaelbel.core.model.Transform
import org.michaelbel.template.features.compose.tmdb.data.local.MovieDb

@Serializable
data class Movie(
    @SerialName("id") val id: Int?,
    @SerialName("imdb_id") val imdbId: String?,
    @SerialName("adult") val adult: Boolean?,
    @SerialName("backdrop_path") val backdropPath: String?,
    @SerialName("budget") val budget: Int?,
    @SerialName("homepage") val homepage: String?,
    @SerialName("original_language") val originalLanguage: String?,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("overview") val overview: String?,
    @SerialName("popularity") val popularity: Double?,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("release_date") val releaseDate: String?,
    @SerialName("revenue") val revenue: Long?,
    @SerialName("runtime") val runtime: Int?,
    @SerialName("status") val status: String?,
    @SerialName("tagline") val tagline: String?,
    @SerialName("title") val title: String?,
    @SerialName("video") val video: Boolean?,
    @SerialName("vote_average") val voteAverage: Float?,
    @SerialName("vote_count") val voteCount: Int?,
    @SerialName("media_type") val mediaType: String?,
    @SerialName("genre_ids") val genreIds: List<Int>?
): Transform<MovieDb> {

    override fun transform(): MovieDb {
        return MovieDb(
            id = id ?: 0,
            title = title.orEmpty(),
            posterPath = posterPath.orEmpty()
        )
    }

    companion object {
        fun empty(): Movie {
            return Movie(
                id = 0,
                imdbId = "",
                adult = false,
                backdropPath = "",
                budget = 0,
                homepage = "",
                originalLanguage = "",
                originalTitle = "",
                overview = "",
                popularity = 0.0,
                posterPath = "",
                releaseDate = "",
                revenue = 0L,
                runtime = 0,
                status = "",
                tagline = "",
                title = "",
                video = false,
                voteAverage = 0F,
                voteCount = 0,
                mediaType = "",
                genreIds = emptyList()
            )
        }
    }
}