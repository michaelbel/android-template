package org.michaelbel.core.room

import androidx.room.TypeConverter
import java.util.Calendar

class CalendarConverter {

    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = value }
}