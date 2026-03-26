package org.michaelbel.shared.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.michaelbel.shared.dispatchers.AppDispatchers
import org.michaelbel.shared.repository.AppRepository
import org.michaelbel.shared.room.AppEntity

class AppInteractor(
    private val appDispatchers: AppDispatchers,
    private val appRepository: AppRepository
) {
    val entitiesFlow: Flow<List<AppEntity>> = appRepository.entitiesFlow
    val dynamicColorsFlow: Flow<Boolean> = appRepository.dynamicColorsFlow

    fun entityFlow(id: Int): Flow<AppEntity> {
        return appRepository.entityFlow(id)
    }

    suspend fun loadDataResponse() {
        withContext(appDispatchers.io) { appRepository.loadDataResponse() }
    }

    suspend fun setDynamicColors(enabled: Boolean) {
        withContext(appDispatchers.io) { appRepository.setDynamicColors(enabled) }
    }
}
