package org.michaelbel.template.room

import androidx.room.Entity

@Entity(tableName = "entities", primaryKeys = ["id"])
data class AppEntity(
    val id: Int,
    val name: String
)