package org.michaelbel.template.ui.details2.model

import org.michaelbel.shared.mvi.Model
import org.michaelbel.shared.room.AppEntity

data class Details2Model(
    val appEntity: AppEntity = AppEntity.Companion.Empty
): Model