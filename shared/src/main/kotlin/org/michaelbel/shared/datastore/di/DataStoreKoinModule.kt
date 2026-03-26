package org.michaelbel.shared.datastore.di

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import okio.Path.Companion.toPath
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.michaelbel.shared.datastore.AppPreferences

private const val DATA_STORE_NAME = "app.preferences_pb"

val dataStoreKoinModule = module {
    single<AppPreferences> {
        val dataStore = PreferenceDataStoreFactory.createWithPath(
            migrations = emptyList(),
            produceFile = { androidContext().filesDir.resolve(DATA_STORE_NAME).absolutePath.toPath() }
        )
        AppPreferences(dataStore)
    }
}
