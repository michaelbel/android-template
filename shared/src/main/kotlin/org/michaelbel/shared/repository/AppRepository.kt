package org.michaelbel.shared.repository

import kotlinx.coroutines.flow.Flow
import org.michaelbel.shared.datastore.AppPreferences
import org.michaelbel.shared.ktor.AppService
import org.michaelbel.shared.room.AppDao
import org.michaelbel.shared.room.AppEntity

class AppRepository(
    private val appPreferences: AppPreferences,
    private val appDao: AppDao,
    private val appService: AppService
) {
    val entitiesFlow: Flow<List<AppEntity>> = appDao.entitiesFlow()
    val dynamicColorsFlow: Flow<Boolean> = appPreferences.valueFlow(AppPreferences.PreferenceKey.PreferenceDynamicColorsKey, true)

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
        appDao.upsertEntities(appEntities)
    }

    suspend fun setDynamicColors(enabled: Boolean) {
        appPreferences.setValue(AppPreferences.PreferenceKey.PreferenceDynamicColorsKey, enabled)
    }
}
