package org.michaelbel.shared.repository

import kotlinx.coroutines.flow.Flow
import org.michaelbel.shared.datastore.AppPreferences
import org.michaelbel.shared.ktor.AppService
import org.michaelbel.shared.room.BoarDao
import org.michaelbel.shared.room.BoarEntity

class AppRepository(
    private val appPreferences: AppPreferences,
    private val appDao: BoarDao,
    private val appService: AppService
) {
    val entitiesFlow: Flow<List<BoarEntity>> = appDao.selectFlow()
    val dynamicColorsFlow: Flow<Boolean> = appPreferences.valueFlow(AppPreferences.PreferenceKey.PreferenceDynamicColorsKey, true)

    fun boarEntityFlow(boarId: Int): Flow<BoarEntity> {
        return appDao.selectFlow(boarId)
    }

    suspend fun loadDataResponse() {
        val entities = appService.getDataResponse().map {
            BoarEntity(
                boarId = it.id,
                name = it.name,
                description = it.description,
                picture = it.picture
            )
        }
        appDao.upsert(entities)
    }

    suspend fun setDynamicColors(enabled: Boolean) {
        appPreferences.setValue(AppPreferences.PreferenceKey.PreferenceDynamicColorsKey, enabled)
    }
}
