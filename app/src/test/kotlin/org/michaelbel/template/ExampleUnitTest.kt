package org.michaelbel.template

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_isNotCorrect() {
        assertNotEquals(4, 2 + 3)
    }

    // assertThat

    @Test
    fun checkTrue() {
        assertTrue(true)
    }

    @Test
    fun checkFalse() {
        assertFalse(false)
    }

    @Test
    fun checkNull() {
        val parameter: Any? = null
        assertNull(parameter)
    }

    @Test
    fun checkNotNull() {
        val parameter: Any = "Object"
        assertNotNull(parameter)
    }
}