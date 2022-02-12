@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context

fun Context.checkPackageNameValid(action: () -> Unit) {
    val releasePackageName = "org.michaelbel.template"

    if (packageName == releasePackageName) {
        action()
    } else {
        TODO("Invalid package name!")
    }
}