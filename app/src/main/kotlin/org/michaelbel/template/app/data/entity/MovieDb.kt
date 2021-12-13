package org.michaelbel.template.app.data.entity

import androidx.room.Entity
import org.michaelbel.template.features.tmdb_api.model.Movie

@Entity(tableName = "movies", primaryKeys = ["id"])
data class MovieDb(
    val id: Int,
    val title: String,
    val posterPath: String
) {
    companion object {
        fun from(movie: Movie): MovieDb {
            return MovieDb(
                id = movie.id,
                title = movie.title,
                posterPath = movie.posterPath
            )
        }
    }
}