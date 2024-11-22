package org.michaelbel.template.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Query("SELECT * FROM entities")
    fun entitiesFlow(): Flow<List<AppEntity>>

    @Insert
    suspend fun insertEntities(entities: List<AppEntity>)
}