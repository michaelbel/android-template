package org.michaelbel.template.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Query("SELECT * FROM entities")
    fun entitiesFlow(): Flow<List<AppEntity>>

    @Query("SELECT * FROM entities WHERE id = :id")
    fun entityFlow(id: Int): Flow<AppEntity>

    @Upsert
    suspend fun upsertEntities(entities: List<AppEntity>)
}