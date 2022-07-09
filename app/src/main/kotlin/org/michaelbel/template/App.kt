package org.michaelbel.template

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.color.DynamicColors
import com.kirillr.strictmodehelper.kotlin.dsl.initStrictMode
import dagger.hilt.android.HiltAndroidApp
import org.michaelbel.core.BuildConfig

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initAppTheme()
        initAndroidStrictMode()
        initLeakCanary()
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

    private fun initLeakCanary() {

    }
}