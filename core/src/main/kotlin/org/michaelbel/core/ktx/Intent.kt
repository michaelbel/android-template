package org.michaelbel.core.ktx

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.core.net.toUri

fun Context.navigateToAppSetting() {
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        "package:$packageName".toUri()
    ).apply {
        addCategory(Intent.CATEGORY_DEFAULT)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(intent)
}