package org.michaelbel.template.features.social

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.michaelbel.core.analytics.Analytics
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SocialViewModel @Inject constructor(
    analytics: Analytics,
    private val dataStore: DataStore<Preferences>
): ViewModel() {

    val googleData: Flow<GoogleData> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            mapGoogleData(preferences)
        }

    init {
        analytics.trackScreen(SocialFragment::class.simpleName)
    }

    fun setGoogleAccount(account: GoogleSignInAccount) {
        viewModelScope.launch { saveGoogleAccount(account) }
    }

    private suspend fun saveGoogleAccount(account: GoogleSignInAccount) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.GOOGLE_PHOTO_URL] = account.photoUrl.toString()
            preferences[PreferencesKeys.GOOGLE_DISPLAY_NAME] = account.displayName.orEmpty()
            preferences[PreferencesKeys.GOOGLE_FAMILY_NAME] = account.familyName.orEmpty()
            preferences[PreferencesKeys.GOOGLE_GIVEN_NAME] = account.givenName.orEmpty()
            preferences[PreferencesKeys.GOOGLE_EMAIL] = account.email.orEmpty()
            preferences[PreferencesKeys.GOOGLE_ID] = account.id.orEmpty()
            preferences[PreferencesKeys.GOOGLE_ID_TOKEN] = account.idToken.orEmpty()
        }
    }

    private fun mapGoogleData(preferences: Preferences): GoogleData {
        val photoUrl: String = preferences[PreferencesKeys.GOOGLE_PHOTO_URL].orEmpty()
        val displayName: String = preferences[PreferencesKeys.GOOGLE_DISPLAY_NAME].orEmpty()
        val familyName: String = preferences[PreferencesKeys.GOOGLE_FAMILY_NAME].orEmpty()
        val givenName: String = preferences[PreferencesKeys.GOOGLE_GIVEN_NAME].orEmpty()
        val email: String = preferences[PreferencesKeys.GOOGLE_EMAIL].orEmpty()
        val id: String = preferences[PreferencesKeys.GOOGLE_ID].orEmpty()
        val idToken: String = preferences[PreferencesKeys.GOOGLE_ID_TOKEN].orEmpty()
        return GoogleData(
            photoUrl,
            displayName,
            familyName,
            givenName,
            email,
            id,
            idToken
        )
    }

    private object PreferencesKeys {
        val GOOGLE_PHOTO_URL = stringPreferencesKey("google_photo_url")
        val GOOGLE_DISPLAY_NAME = stringPreferencesKey("google_display_name")
        val GOOGLE_FAMILY_NAME = stringPreferencesKey("google_family_name")
        val GOOGLE_GIVEN_NAME = stringPreferencesKey("google_given_name")
        val GOOGLE_EMAIL = stringPreferencesKey("google_email")
        val GOOGLE_ID = stringPreferencesKey("google_id")
        val GOOGLE_ID_TOKEN = stringPreferencesKey("google_id_token")
    }

    data class GoogleData(
        val photoUrl: String,
        val displayName: String,
        val familyName: String,
        val givenName: String,
        val email: String,
        val id: String,
        val idToken: String
    ) {
        val isNotEmpty: Boolean
            get() = photoUrl.isNotEmpty() && displayName.isNotEmpty()
    }
}