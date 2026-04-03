package org.michaelbel.template.ui.details.model

import org.michaelbel.shared.mvi.Model
import org.michaelbel.shared.room.BoarEntity

data class DetailsModel(
    val entity: BoarEntity = BoarEntity.Empty
): Model
