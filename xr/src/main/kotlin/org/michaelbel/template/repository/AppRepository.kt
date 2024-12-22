package org.michaelbel.template.repository

import kotlinx.coroutines.flow.Flow
import org.michaelbel.template.datastore.AppPreferences
import org.michaelbel.template.ktor.AppService
import org.michaelbel.template.room.AppDao
import org.michaelbel.template.room.AppEntity

class AppRepository(
    private val appPreferences: AppPreferences,
    private val appDao: AppDao,
    private val appService: AppService
) {
    fun entitiesFlow(): Flow<List<AppEntity>> {
        return appDao.entitiesFlow()
    }

    fun entityFlow(id: Int): Flow<AppEntity> {
        return appDao.entityFlow(id)
    }

    suspend fun loadDataResponse() {
        val appEntities = appService.getDataResponse().map {
            AppEntity(
                id = it.id,
                name = it.name,
                description = it.description,
                picture = it.picture
            )
        }
        appDao.insertEntities(appEntities)
    }
}