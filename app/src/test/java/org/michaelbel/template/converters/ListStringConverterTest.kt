package org.michaelbel.template.converters

import org.junit.Assert.assertEquals
import org.junit.Test
import org.michaelbel.core.test.Fails
import org.michaelbel.template.app.data.converters.ListStringConverter

@Fails
class ListStringConverterTest {

    private val list: List<String> = listOf("Apple", "Orange", "Banana")
    private val text: String = "Apple${SEPARATOR}Orange${SEPARATOR}Banana"

    @Test
    fun listToTextTest() {
        assertEquals(text, ListStringConverter().listToText(list))
    }

    @Test
    fun textToListText() {
        assertEquals(list, ListStringConverter().textToList(text))
    }

    private companion object {
        private const val SEPARATOR = "{ELEMENT_SEPARATOR}"
    }
}