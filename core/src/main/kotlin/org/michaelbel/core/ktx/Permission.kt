@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun Context.permissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}