package org.michaelbel.template.converters

import android.util.Size
import org.junit.Assert.assertEquals
import org.michaelbel.core.room.SizeConverter

class SizeConverterTest {

    private lateinit var size: Size
    private lateinit var sizeString: String

    //@Before
    fun setUp() {
        size = Size(100, 200)
        sizeString = "100x200"
    }

    //@Test
    fun sizeToStringTest() {
        assertEquals(sizeString, SizeConverter().sizeToString(size))
    }

    //@Test
    fun stringToSizeTest() {
        assertEquals(SizeConverter().stringToSize(sizeString), size)
    }
}