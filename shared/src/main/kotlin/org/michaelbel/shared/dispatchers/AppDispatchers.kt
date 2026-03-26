package org.michaelbel.shared.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val immediate: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
