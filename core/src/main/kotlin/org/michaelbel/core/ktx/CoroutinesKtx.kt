@file:Suppress("unused")

package org.michaelbel.core.ktx

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend inline fun <T> withIO(
    noinline block: suspend CoroutineScope.() -> T
): T {
    return withContext(Dispatchers.IO, block)
}

suspend inline fun <T> withMain(
    noinline block: suspend CoroutineScope.() -> T
): T {
    return withContext(Dispatchers.Main, block)
}

inline fun CoroutineScope.launchIO(
    crossinline safeAction: suspend () -> Unit,
    crossinline onError: suspend (Throwable) -> Unit,
    errorDispatcher: CoroutineDispatcher = Dispatchers.Main
): Job {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        launch(errorDispatcher) {
            onError.invoke(throwable)
        }
    }

    return this.launch(exceptionHandler + Dispatchers.IO) {
        safeAction.invoke()
    }
}

inline fun CoroutineScope.launchMain(
    crossinline safeAction: suspend () -> Unit,
    crossinline onError: suspend (Throwable) -> Unit,
    errorDispatcher: CoroutineDispatcher = Dispatchers.Main
): Job {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        launch(errorDispatcher) {
            onError.invoke(throwable)
        }
    }

    return this.launch(exceptionHandler + Dispatchers.Main) {
        safeAction.invoke()
    }
}