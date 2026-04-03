package org.michaelbel.template.ui.details2.model

import org.michaelbel.shared.mvi.Model
import org.michaelbel.shared.room.BoarEntity

data class Details2Model(
    val appEntity: BoarEntity = BoarEntity.Companion.Empty
): Model