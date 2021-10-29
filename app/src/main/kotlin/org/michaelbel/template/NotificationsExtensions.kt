package org.michaelbel.template

import android.content.Context
import androidx.core.app.NotificationManagerCompat

fun Context.areNotificationsEnabled(): Boolean {
    return NotificationManagerCompat.from(this).areNotificationsEnabled()
}