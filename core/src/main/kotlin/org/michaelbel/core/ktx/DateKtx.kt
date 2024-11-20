@file:Suppress("unused")

package org.michaelbel.core.ktx

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

private const val DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"

val Long.calendar: Calendar
    get() = Calendar.getInstance().apply { timeInMillis = this@calendar }

var Date.calendar: Calendar
    get() = Calendar.getInstance().apply { time = this@calendar }
    set(value) {
        time = value.timeInMillis
    }

val Date.isToday: Boolean
    get() = calendar.isToday

val Date.isYesterday: Boolean
    get() = calendar.isYesterday

val Date.isTomorrow: Boolean
    get() = calendar.isTomorrow

val Date.isCurrentYear: Boolean
    get() = calendar.isCurrentYear

fun diffBetweenDates(date1: Date, date2: Date): Long {
    return TimeUnit.MILLISECONDS.toMinutes(date1.time - date2.time)
}

val String.datetimeToCalendar: Calendar
    get() {
        val simpleDateFormat = SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault())
        val date: Date = simpleDateFormat.parse(this) ?: return Calendar.getInstance()
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar
    }

val String.datetimeToDate: Date
    get() {
        val simpleDateFormat = SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault())
        val date: Date? = simpleDateFormat.parse(this)
        return requireNotNull(date)
    }

val Pair<Date, Date>.areSameDays: Boolean
    get() = (first.calendar to second.calendar).areSameDays

val Pair<Date, Date>.areDifferentDays: Boolean
    get() = (first.calendar to second.calendar).areDifferentDays