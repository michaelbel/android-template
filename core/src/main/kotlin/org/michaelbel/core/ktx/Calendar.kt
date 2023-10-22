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

val Calendar.isToday: Boolean
    get() {
        val todayCalendar: Calendar = Calendar.getInstance()
        val sameEra: Boolean = todayCalendar.get(Calendar.ERA) == get(Calendar.ERA)
        val sameYear: Boolean = todayCalendar.get(Calendar.YEAR) == get(Calendar.YEAR)
        val sameDayOfYear: Boolean = todayCalendar.get(Calendar.DAY_OF_YEAR) == get(Calendar.DAY_OF_YEAR)
        return sameEra && sameYear && sameDayOfYear
    }

val Calendar.isYesterday: Boolean
    get() {
        val tomorrowCalendar: Calendar = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -1)
        }
        val sameEra: Boolean = tomorrowCalendar.get(Calendar.ERA) == get(Calendar.ERA)
        val sameYear: Boolean = tomorrowCalendar.get(Calendar.YEAR) == get(Calendar.YEAR)
        val sameDayOfYear: Boolean = tomorrowCalendar.get(Calendar.DAY_OF_YEAR) == get(Calendar.DAY_OF_YEAR)
        return sameEra && sameYear && sameDayOfYear
    }

val Calendar.isTomorrow: Boolean
    get() {
        val tomorrowCalendar: Calendar = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, 1)
        }
        val sameEra: Boolean = tomorrowCalendar.get(Calendar.ERA) == get(Calendar.ERA)
        val sameYear: Boolean = tomorrowCalendar.get(Calendar.YEAR) == get(Calendar.YEAR)
        val sameDayOfYear: Boolean = tomorrowCalendar.get(Calendar.DAY_OF_YEAR) == get(Calendar.DAY_OF_YEAR)
        return sameEra && sameYear && sameDayOfYear
    }

val Calendar.isCurrentYear: Boolean
    get() {
        val currentYearCalendar: Calendar = Calendar.getInstance()
        val sameEra: Boolean = currentYearCalendar.get(Calendar.ERA) == get(Calendar.ERA)
        val sameYear: Boolean = currentYearCalendar.get(Calendar.YEAR) == get(Calendar.YEAR)
        return sameEra && sameYear
    }

val Pair<Calendar, Calendar>.areSameDays: Boolean
    get() {
        val firstDayOfYear: Int = first.get(Calendar.DAY_OF_YEAR)
        val secondDayOfYear: Int = second.get(Calendar.DAY_OF_YEAR)
        return firstDayOfYear == secondDayOfYear
    }

val Pair<Calendar, Calendar>.areDifferentDays: Boolean
    get() {
        val firstDayOfYear: Int = first.get(Calendar.DAY_OF_YEAR)
        val secondDayOfYear: Int = second.get(Calendar.DAY_OF_YEAR)
        return firstDayOfYear != secondDayOfYear
    }