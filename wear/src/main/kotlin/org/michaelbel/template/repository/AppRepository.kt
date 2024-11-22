package org.michaelbel.template.repository

import org.michaelbel.template.datastore.AppPreferences
import org.michaelbel.template.ktor.AppService
import org.michaelbel.template.room.AppDao

class AppRepository(
    private val appPreferences: AppPreferences,
    private val appDao: AppDao,
    private val appService: AppService
)