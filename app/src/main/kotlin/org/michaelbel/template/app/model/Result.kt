package org.michaelbel.template.app.model

import com.google.gson.annotations.SerializedName

data class Result<T>(
    @SerializedName("id") val id: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<T>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("dates") val dates: Dates?
)