@file:Suppress("unused")

package org.michaelbel.shared.ktx

import kotlin.coroutines.cancellation.CancellationException

inline fun <R> runCatchingCancellable(block: () -> R): Result<R> {
    return try {
        Result.success(value = block())
    } catch (ce: CancellationException) {
        throw ce
    } catch (e: Exception) {
        Result.failure(exception = e)
    }
}
