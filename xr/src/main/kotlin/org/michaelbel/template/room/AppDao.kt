package org.michaelbel.template.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Query("SELECT * FROM entities")
    fun entitiesFlow(): Flow<List<AppEntity>>

    @Query("SELECT * FROM entities WHERE id = :id")
    fun entityFlow(id: Int): Flow<AppEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntities(entities: List<AppEntity>)
}