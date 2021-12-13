package org.michaelbel.template.features.github_api.api

import com.google.gson.annotations.SerializedName
import org.michaelbel.template.features.github_api.model.Repo

/**
 * Data class to hold repo responses from searchRepo API calls.
 */
data class RepoSearchResponse(
    @SerializedName("total_count") val total: Int = 0,
    @SerializedName("items") val items: List<Repo> = emptyList(),
    val nextPage: Int? = null
)