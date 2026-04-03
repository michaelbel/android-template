package org.michaelbel.shared.room

import androidx.room.Entity

@Entity(tableName = "boars", primaryKeys = ["boarId"])
data class BoarEntity(
    val boarId: Int,
    val name: String,
    val description: String,
    val picture: String
) {
    companion object {
        val Empty = BoarEntity(
            boarId = 0,
            name = "",
            description = "",
            picture = ""
        )
    }
}
