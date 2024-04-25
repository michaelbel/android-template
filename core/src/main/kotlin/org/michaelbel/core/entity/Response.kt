@file:Suppress("unused")

package org.michaelbel.core.entity

suspend fun <T> response(
    request: suspend () -> T
): Either<T> {
    return try {
        Either.Success(request.invoke())
    } catch (e: Exception) {
        Either.Failure(e)
    }
}