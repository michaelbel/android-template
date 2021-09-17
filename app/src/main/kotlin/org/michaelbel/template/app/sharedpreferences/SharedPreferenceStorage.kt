package org.michaelbel.template.app.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.qualifiers.ApplicationContext
import org.michaelbel.template.app.sharedpreferences.property.IntPreference
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceStorage @Inject constructor(
    @ApplicationContext context: Context
): PreferenceStorage {

    companion object {
        private const val PREFS_NAME = "shared_preferences_storage"
        private const val PREF_THEME = "pref_theme"
    }

    private val prefs: Lazy<SharedPreferences> = lazy {
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override var appTheme by IntPreference(prefs, PREF_THEME, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
}