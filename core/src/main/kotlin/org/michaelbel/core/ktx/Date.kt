@file:Suppress("unused")

package org.michaelbel.core.ktx

import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

var Date.calendar: Calendar
    get() = Calendar.getInstance().apply { time = this@calendar }
    set(value) {
        time = value.timeInMillis
    }

val Date.isToday: Boolean
    get() {
        val calToday = Calendar.getInstance()
        return calToday.get(Calendar.ERA) == calendar.get(Calendar.ERA) &&
                calToday.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                calToday.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)
    }

val Date.isTomorrow: Boolean
    get() {
        val tomorrow = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 1) }
        return tomorrow.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                tomorrow.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)
    }

fun diffBetweenDates(date1: Date, date2: Date): Long {
    return TimeUnit.MILLISECONDS.toMinutes(date1.time - date2.time)
}