@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun String.granted(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(context, this) == PackageManager.PERMISSION_GRANTED
}

fun String.denied(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(context, this) == PackageManager.PERMISSION_DENIED
}