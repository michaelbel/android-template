package org.michaelbel.template.features.compose.tmdb.data.local

import androidx.room.Entity

@Entity(tableName = "movies", primaryKeys = ["id"])
data class MovieDb(
    val id: Int,
    val title: String,
    val posterPath: String
)