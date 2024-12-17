package org.michaelbel.template.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.michaelbel.core.dispatchers.AppDispatchers
import org.michaelbel.template.repository.AppRepository
import org.michaelbel.template.room.AppEntity

class AppInteractor(
    private val appDispatchers: AppDispatchers,
    private val appRepository: AppRepository
) {
    fun entitiesFlow(): Flow<List<AppEntity>> {
        return appRepository.entitiesFlow()
    }

    fun entityFlow(id: Int): Flow<AppEntity> {
        return appRepository.entityFlow(id)
    }

    suspend fun loadDataResponse() {
        withContext(appDispatchers.io) { appRepository.loadDataResponse() }
    }
}