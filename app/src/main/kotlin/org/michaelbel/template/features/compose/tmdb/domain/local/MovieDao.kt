package org.michaelbel.template.features.compose.tmdb.domain.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.michaelbel.template.features.compose.tmdb.data.local.MovieDb

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieDb)

    @Query("SELECT * FROM movies WHERE id IN (:movieId)")
    suspend fun getMovie(movieId: Long): MovieDb
}