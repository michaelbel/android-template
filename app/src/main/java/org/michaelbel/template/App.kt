package org.michaelbel.template

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        initFirebaseCrashlytics()
    }

    private fun initFirebaseCrashlytics() {
        FirebaseApp.initializeApp(applicationContext)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }
}