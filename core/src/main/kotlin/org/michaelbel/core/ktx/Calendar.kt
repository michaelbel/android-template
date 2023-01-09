@file:Suppress("unused")

package org.michaelbel.core.ktx

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private const val TIME_FORMAT = "HH:mm"
private const val DATE_FORMAT = "dd.MM.yy HH:mm"

fun Calendar.getFormattedTime(): String {
    val dateFormat = SimpleDateFormat(TIME_FORMAT, Locale.getDefault())
    return dateFormat.format(time)
}

fun Calendar.getFormattedDate(): String {
    val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
    return dateFormat.format(time)
}