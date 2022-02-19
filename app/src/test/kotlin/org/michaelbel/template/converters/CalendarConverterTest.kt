package org.michaelbel.template.converters

import java.util.Calendar
import org.junit.Assert.assertEquals
import org.michaelbel.core.room.CalendarConverter

class CalendarConverterTest {

    private val calendar = Calendar.getInstance().apply {
        set(Calendar.YEAR, 1998)
        set(Calendar.MONTH, Calendar.SEPTEMBER)
        set(Calendar.DAY_OF_MONTH, 4)
    }

    //@Test
    fun calendarToDatestampTest() {
        assertEquals(calendar.timeInMillis, CalendarConverter().calendarToDatestamp(calendar))
    }

    //@Test
    fun datestampToCalendarTest() {
        assertEquals(CalendarConverter().datestampToCalendar(calendar.timeInMillis), calendar)
    }
}