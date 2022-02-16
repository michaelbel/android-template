package org.michaelbel.core.system

import android.bluetooth.BluetoothManager
import android.content.Context
import android.net.ConnectivityManager
import android.os.BatteryManager
import android.os.Build
import android.os.Vibrator
import android.os.VibratorManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SystemServicesModule {

    @Provides
    @Singleton
    fun provideBatteryService(@ApplicationContext context: Context): BatteryManager {
        return context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
    }

    @Provides
    @Singleton
    fun provideBluetoothService(@ApplicationContext context: Context): BluetoothManager {
        return context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    }

    @Provides
    @Singleton
    fun provideConnectivityService(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    fun provideVibratorService(@ApplicationContext context: Context): Vibrator {
        return if (Build.VERSION.SDK_INT >= 31) {
            val vibratorManager: VibratorManager = context.getSystemService(
                Context.VIBRATOR_MANAGER_SERVICE
            ) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("Deprecation")
            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }
    }
}