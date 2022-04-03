package org.michaelbel.core.ktx

import org.junit.Assert
import org.junit.Test

class StringTest {

    @Test
    fun testAppend() {
        val text = "din-don"
        Assert.assertEquals(text, "din".append("-").append("don"))
    }

    @Test
    fun testTextOnly() {
        val text = "ИванJohn"
        Assert.assertTrue(text.isTextOnly)

        val textWithDigits = "42"
        Assert.assertFalse(textWithDigits.isTextOnly)
    }

    @Test
    fun testUrlValid() {
        val url = "https://google.com"
        Assert.assertTrue(url.isUrlValid)
    }

    @Test
    fun testContainsLetters() {
        val text = "qwertyuiopasdfghjklzxcvbnm123456789йцкенгшщзхъфывапролджэёячсмитьбю"
        Assert.assertTrue(text.containsLetters)
    }

    @Test
    fun testContainsNumbers() {
        val text = "qwertyuiopasdfghjklzxcvbnm123456789йцкенгшщзхъфывапролджэёячсмитьбю"
        Assert.assertTrue(text.containsNumbers)
    }

    @Test
    fun testAlphanumeric() {
        val text = "qwertyuiopasdfghjklzxcvbnm123456789"
        Assert.assertTrue(text.isAlphanumeric)
    }

    @Test
    fun testAlphabetic() {
        val text = "qwertyuiopasdfghjklzxcvbnm"
        Assert.assertTrue(text.isAlphabetic)
    }

    @Test
    fun testNumeric() {
        val text = "123456789"
        Assert.assertTrue(text.isNumeric)
    }

    @Test
    fun testValidEmail() {
        val email = "michael-bel@outlook.com"
        Assert.assertTrue(email.isEmail)
    }

    @Test
    fun testMostCommonChar() {
        val text = "01234567890"
        val char: Char = "0".first()
        Assert.assertEquals(text.mostCommonChar, char)
    }
}