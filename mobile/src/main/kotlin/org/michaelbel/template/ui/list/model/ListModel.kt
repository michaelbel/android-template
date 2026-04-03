package org.michaelbel.template.ui.list.model

import org.michaelbel.shared.mvi.Model
import org.michaelbel.shared.room.BoarEntity

data class ListModel(
    val entities: List<BoarEntity> = emptyList()
): Model