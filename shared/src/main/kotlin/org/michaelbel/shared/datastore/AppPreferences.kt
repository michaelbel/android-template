package org.michaelbel.shared.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AppPreferences(
    private val dataStore: DataStore<Preferences>
) {
    fun <T> valueFlow(key: PreferenceKey<T>, default: T): Flow<T> {
        return dataStore.data.map { preferences -> preferences[key.preferenceKey] ?: default }
    }

    suspend fun <T> getValue(key: PreferenceKey<T>): T? {
        return dataStore.data.first()[key.preferenceKey]
    }

    suspend fun <T> setValue(key: PreferenceKey<T>, value: T) {
        dataStore.edit { preferences -> preferences[key.preferenceKey] = value }
    }

    suspend fun <T> removeValue(key: PreferenceKey<T>) {
        dataStore.edit { preferences -> preferences.remove(key.preferenceKey) }
    }

    private companion object {
        private val PREFERENCE_USERNAME_KEY = stringPreferencesKey("username")
        private val PREFERENCE_DYNAMIC_COLORS_KEY = booleanPreferencesKey("dynamic_colors")
    }

    sealed class PreferenceKey<T>(
        val preferenceKey: Preferences.Key<T>
    ) {
        data object PreferenceUsernameKey: PreferenceKey<String>(PREFERENCE_USERNAME_KEY)
        data object PreferenceDynamicColorsKey: PreferenceKey<Boolean>(PREFERENCE_DYNAMIC_COLORS_KEY)
    }
}
