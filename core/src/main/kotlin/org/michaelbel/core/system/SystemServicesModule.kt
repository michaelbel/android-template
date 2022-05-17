package org.michaelbel.core.system

import android.app.DownloadManager
import android.app.NotificationManager
import android.bluetooth.BluetoothManager
import android.content.Context
import android.net.ConnectivityManager
import android.os.BatteryManager
import android.os.Build
import android.os.Vibrator
import android.os.VibratorManager
import androidx.core.content.ContextCompat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SystemServicesModule {

    @Provides
    fun provideBatteryService(
        @ApplicationContext context: Context
    ): BatteryManager {
        return ContextCompat.getSystemService(context, BatteryManager::class.java) as BatteryManager
    }

    @Provides
    fun provideBluetoothService(
        @ApplicationContext context: Context
    ): BluetoothManager {
        return ContextCompat.getSystemService(
            context,
            BluetoothManager::class.java
        ) as BluetoothManager
    }

    @Provides
    fun provideConnectivityService(
        @ApplicationContext context: Context
    ): ConnectivityManager {
        return ContextCompat.getSystemService(
            context,
            ConnectivityManager::class.java
        ) as ConnectivityManager
    }

    @Provides
    fun provideVibratorService(
        @ApplicationContext context: Context
    ): Vibrator {
        return if (Build.VERSION.SDK_INT >= 31) {
            val vibratorManager: VibratorManager = ContextCompat.getSystemService(
                context,
                VibratorManager::class.java
            ) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("Deprecation")
            ContextCompat.getSystemService(context, Vibrator::class.java) as Vibrator
        }
    }

    @Provides
    fun provideDownloadService(
        @ApplicationContext context: Context
    ): DownloadManager {
        return ContextCompat.getSystemService(context, DownloadManager::class.java) as DownloadManager
    }

    @Provides
    fun provideNotificationService(
        @ApplicationContext context: Context
    ): NotificationManager {
        return ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager
    }
}