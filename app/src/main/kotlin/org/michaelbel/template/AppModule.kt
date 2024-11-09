package org.michaelbel.template

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import okio.Path.Companion.toPath
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import org.michaelbel.template.datastore.AppPreferences
import org.michaelbel.template.interactor.AppInteractor
import org.michaelbel.template.repository.AppRepository

val appModule = module {
    single<AppPreferences> {
        val dataStore = PreferenceDataStoreFactory.createWithPath(
            migrations = emptyList(),
            produceFile = { androidContext().filesDir.resolve(AppPreferences.DATA_STORE_NAME).absolutePath.toPath() }
        )
        AppPreferences(dataStore)
    }
    single<AppRepository> { AppRepository(get()) }
    single<AppInteractor> { AppInteractor(get()) }
    viewModelOf(::MainViewModel)
}