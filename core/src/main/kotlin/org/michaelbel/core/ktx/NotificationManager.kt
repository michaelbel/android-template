@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import androidx.core.app.NotificationManagerCompat

val Context.areNotificationsEnabled: Boolean
    get() =  NotificationManagerCompat.from(this).areNotificationsEnabled()