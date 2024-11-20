@file:Suppress("unused")

package org.michaelbel.core.ktx

import androidx.paging.PagingData
import androidx.paging.TerminalSeparatorType
import androidx.paging.insertSeparators

fun <T: R, R: Any> PagingData<T>.insertSourceSeparator(
    generator: suspend (T?, T?) -> R?
): PagingData<R> {
    return insertSeparators(TerminalSeparatorType.SOURCE_COMPLETE, generator)
}

fun <T: R, R: Any> PagingData<T>.insertFullySeparator(
    generator: suspend (T?, T?) -> R?
): PagingData<R> {
    return insertSeparators(TerminalSeparatorType.FULLY_COMPLETE, generator)
}

fun <T: Any> PagingData<T>.insertHeaderOrNull(
    terminalSeparatorType: TerminalSeparatorType,
    item: T?
): PagingData<T> = insertSeparators(terminalSeparatorType) { before, _ ->
    if (item != null && before == null) item else null
}

fun <T: Any> PagingData<T>.insertSourceHeaderOrNull(
    item: T?
): PagingData<T> = insertSeparators(TerminalSeparatorType.SOURCE_COMPLETE) { before, _ ->
    if (item != null && before == null) item else null
}

fun <T: Any> PagingData<T>.insertFullyHeaderOrNull(
    item: T?
): PagingData<T> = insertSeparators(TerminalSeparatorType.FULLY_COMPLETE) { before, _ ->
    if (item != null && before == null) item else null
}