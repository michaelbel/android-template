package org.michaelbel.core.sharedpreferences.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import org.michaelbel.core.sharedpreferences.IntPreference

@Singleton
class SharedPreferenceStorage @Inject constructor(
    @ApplicationContext context: Context
): PreferenceStorage {

    private val prefs: Lazy<SharedPreferences> = lazy {
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override var appTheme by IntPreference(
        prefs,
        PREF_THEME,
        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    )

    private companion object {
        private const val PREFS_NAME = "shared_preferences_storage"
        private const val PREF_THEME = "pref_theme"
    }
}