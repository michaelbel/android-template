package org.michaelbel.template.ui.details.model

import org.michaelbel.shared.mvi.Model
import org.michaelbel.shared.room.AppEntity

data class DetailsModel(
    val appEntity: AppEntity = AppEntity.Companion.Empty
): Model