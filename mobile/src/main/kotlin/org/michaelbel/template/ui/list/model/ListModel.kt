package org.michaelbel.template.ui.list.model

import org.michaelbel.shared.mvi.Model
import org.michaelbel.shared.room.AppEntity

data class ListModel(
    val entities: List<AppEntity> = emptyList()
): Model