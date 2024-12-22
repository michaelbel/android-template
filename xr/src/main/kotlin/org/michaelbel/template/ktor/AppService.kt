package org.michaelbel.template.ktor

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class AppService(
    private val httpClient: HttpClient
) {

    suspend fun getDataResponse(): List<AppResponse> {
        val response: String = httpClient.get(DATA_URL).bodyAsText()
        return Json.decodeFromString<List<AppResponse>>(response)
    }

    companion object {
        const val REQUEST_TIMEOUT_MILLIS = 10_000L
        const val SOCKET_TIMEOUT_SECONDS = 10_000L
        const val HTTP_CACHE_SIZE_BYTES = 1024 * 1024 * 50
        const val CONNECT_TIMEOUT_MILLIS = 10_000L

        const val DATA_URL = "https://raw.githubusercontent.com/michaelbel/android-template/refs/heads/develop/.github/data/data.json"
    }
}