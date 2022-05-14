package org.michaelbel.core.initializer

import android.content.Context
import androidx.startup.Initializer
import org.michaelbel.core.BuildConfig
import org.michaelbel.core.crashlytics.CrashlyticsTree
import timber.log.Timber

@Suppress("unused")
class TimberInitializer: Initializer<Unit> {

    override fun create(context: Context) {
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else CrashlyticsTree())
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(FirebaseCrashlyticsInitializer::class.java)
    }
}