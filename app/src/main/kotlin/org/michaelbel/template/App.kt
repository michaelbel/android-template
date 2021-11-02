package org.michaelbel.template

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.vk.api.sdk.VK
import dagger.hilt.android.HiltAndroidApp
import org.michaelbel.core.crashlytics.CrashlyticsTree
import timber.log.Timber

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initAppTheme()
        initFirebaseCrashlytics()
        initTimber()
        initVK()
    }

    private fun initAppTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

    private fun initFirebaseCrashlytics() {
        FirebaseApp.initializeApp(applicationContext)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }

    private fun initTimber() {
        Timber.plant(CrashlyticsTree())
    }

    private fun initVK() {
        VK.initialize(this)
    }
}