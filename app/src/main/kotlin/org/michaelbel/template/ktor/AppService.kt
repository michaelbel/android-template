package org.michaelbel.template.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class AppService(
    private val httpClient: HttpClient
) {

    suspend fun getAppResponse(id: Int): AppResponse {
        return httpClient.get("route/$id") {
            parameter("key", "1234")
        }.body()
    }

    companion object {
        const val REQUEST_TIMEOUT_MILLIS = 10_000L
        const val SOCKET_TIMEOUT_SECONDS = 10_000L
        const val HTTP_CACHE_SIZE_BYTES = 1024 * 1024 * 50
        const val CONNECT_TIMEOUT_MILLIS = 10_000L
    }
}