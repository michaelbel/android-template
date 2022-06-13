@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.net.Uri

fun Uri.orEmpty(): Uri {
    return Uri.EMPTY
}