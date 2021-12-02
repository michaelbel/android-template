package org.michaelbel.template

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.google.android.material.color.DynamicColors
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.vk.api.sdk.VK
import dagger.hilt.android.HiltAndroidApp
import org.michaelbel.core.crashlytics.CrashlyticsTree
import org.michaelbel.template.ui.utils.UnsplashSizingInterceptor
import timber.log.Timber

@HiltAndroidApp
class App: Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()
        initAppTheme()
        initFirebaseCrashlytics()
        initTimber()
        initVK()
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .componentRegistry {
                add(UnsplashSizingInterceptor)
            }
            .build()
    }

    private fun initAppTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        DynamicColors.applyToActivitiesIfAvailable(this)
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