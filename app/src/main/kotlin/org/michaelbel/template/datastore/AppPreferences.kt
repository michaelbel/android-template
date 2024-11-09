package org.michaelbel.template.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AppPreferences(
    private val dataStore: DataStore<Preferences>
) {
    val usernameFlow: Flow<String?>
        get() = dataStore.data.map { preferences -> preferences[PREFERENCE_USERNAME_KEY] }

    suspend fun username(): String {
        return dataStore.data.first()[PREFERENCE_USERNAME_KEY].orEmpty()
    }

    suspend fun <T> setValue(key: PreferenceKey<T>, value: T) {
        dataStore.edit { preferences ->
            preferences[key.preferenceKey] = value
        }
    }

    suspend fun <T> removeValue(key: PreferenceKey<T>) {
        dataStore.edit { preferences ->
            preferences.remove(key.preferenceKey)
        }
    }

    companion object {
        const val DATA_STORE_NAME = "app.preferences_pb"
        private val PREFERENCE_USERNAME_KEY = stringPreferencesKey("username")
    }

    sealed class PreferenceKey<T>(
        val preferenceKey: Preferences.Key<T>
    ) {
        data object PreferenceUsernameKey: PreferenceKey<String>(PREFERENCE_USERNAME_KEY)
    }
}