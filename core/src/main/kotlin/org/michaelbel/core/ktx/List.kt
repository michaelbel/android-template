@file:Suppress("unused")

package org.michaelbel.core.ktx

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

suspend fun <T, R> List<T>.mapAsync(
    transformation: suspend (T) -> R
): List<R> = coroutineScope {
    this@mapAsync.map { async { transformation(it) } }.awaitAll()
}