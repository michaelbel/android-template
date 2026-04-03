package org.michaelbel.shared.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.michaelbel.shared.coroutines.AppDispatchers
import org.michaelbel.shared.repository.AppRepository
import org.michaelbel.shared.room.BoarEntity

class AppInteractor(
    private val appDispatchers: AppDispatchers,
    private val appRepository: AppRepository
) {
    val entitiesFlow: Flow<List<BoarEntity>> = appRepository.entitiesFlow
    val dynamicColorsFlow: Flow<Boolean> = appRepository.dynamicColorsFlow

    fun boarEntityFlow(boarId: Int): Flow<BoarEntity> {
        return appRepository.boarEntityFlow(boarId)
    }

    suspend fun loadDataResponse() {
        withContext(appDispatchers.io) { appRepository.loadDataResponse() }
    }

    suspend fun setDynamicColors(enabled: Boolean) {
        withContext(appDispatchers.io) { appRepository.setDynamicColors(enabled) }
    }
}
