package org.michaelbel.template

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import org.michaelbel.template.AppRoute

object MainNavigator {

    private val _eventChannel = Channel<AppRoute>()
    val eventFlow: Flow<AppRoute> = _eventChannel.receiveAsFlow()

    suspend fun forward(element: AppRoute) {
        _eventChannel.send(element)
    }
}
