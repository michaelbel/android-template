package org.michaelbel.template

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.google.android.material.color.DynamicColors
import com.kirillr.strictmodehelper.kotlin.dsl.initStrictMode
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import org.michaelbel.core.BuildConfig
import org.michaelbel.template.ui.utils.UnsplashSizingInterceptor

@HiltAndroidApp
class App: Application(), Configuration.Provider, ImageLoaderFactory {

    @Inject lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        initAppTheme()
        //initAndroidStrictMode()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
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

    private fun initAndroidStrictMode() {
        initStrictMode(
            enable = BuildConfig.DEBUG,
            enableDefaults = false
        ) {
            threadPolicy {
                resourceMismatches = true
                customSlowCalls = true
                unbufferedIo = true

                penalty {
                    log = true
                }
            }

            vmPolicy {
                fileUriExposure = true
                leakedRegistrationObjects = true
                cleartextNetwork = true
                cleartextNetwork = true
                untaggedSockets = true
                contentUriWithoutPermission = true

                penalty {
                    log = true
                }
            }
        }
    }
}