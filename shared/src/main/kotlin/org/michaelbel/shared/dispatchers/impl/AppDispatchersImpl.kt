package org.michaelbel.shared.dispatchers.impl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.michaelbel.shared.dispatchers.AppDispatchers

internal class AppDispatchersImpl: AppDispatchers {

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val immediate: CoroutineDispatcher
        get() = Dispatchers.Main.immediate

    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}
