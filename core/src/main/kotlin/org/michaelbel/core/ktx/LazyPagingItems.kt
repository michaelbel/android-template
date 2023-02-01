@file:Suppress("unused")

package org.michaelbel.core.ktx

import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

private val <T: Any> LazyPagingItems<T>.isEmpty: Boolean
    get() = itemCount == 0

private val <T: Any> LazyPagingItems<T>.isNotEmpty: Boolean
    get() = itemCount > 0

val <T: Any> LazyPagingItems<T>.isLoading: Boolean
    get() = loadState.refresh is LoadState.Loading && isEmpty

val <T: Any> LazyPagingItems<T>.isContent: Boolean
    get() = loadState.append is LoadState.NotLoading && isNotEmpty

val <T: Any> LazyPagingItems<T>.isFailure: Boolean
    get() = loadState.refresh is LoadState.Error && isEmpty

val <T: Any> LazyPagingItems<T>.isPagingLoading: Boolean
    get() = loadState.append is LoadState.Loading && isNotEmpty

val <T: Any> LazyPagingItems<T>.isPagingFailure: Boolean
    get() = loadState.append is LoadState.Error && isNotEmpty

val <T: Any> LazyPagingItems<T>.throwable: Throwable
    get() = (loadState.refresh as LoadState.Error).error

fun <T: Any> LazyPagingItems<T>.getOrNull(index: Int): T? {
    return if (index < 0 || index >= itemCount) null else get(index)
}

fun <T: Any> LazyPagingItems<T>.firstOrNull(): T? {
    return if (isEmpty) null else get(0)
}
