package org.michaelbel.shared.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface BoarDao {

    @Query("SELECT * FROM boars")
    fun selectFlow(): Flow<List<BoarEntity>>

    @Query("SELECT * FROM boars WHERE boarId = :boarId")
    fun selectFlow(boarId: Int): Flow<BoarEntity>

    @Upsert
    suspend fun upsert(entities: List<BoarEntity>)
}
