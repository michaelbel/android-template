package org.michaelbel.template.features.tmdb_api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dates(
    @SerialName("minimum") val minimumDate: String,
    @SerialName("maximum") val maximumDate: String
)