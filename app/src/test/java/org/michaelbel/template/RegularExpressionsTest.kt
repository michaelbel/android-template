package org.michaelbel.template

import androidx.core.util.PatternsCompat
import java.util.regex.Pattern
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RegularExpressionsTest {

    /**
     * Тест валидности Email-адреса.
     */
    @Test
    fun validEmailAddress() {
        val email = "michael-bel@outlook.com"
        assertTrue(email.matches(PatternsCompat.AUTOLINK_EMAIL_ADDRESS.toRegex()))
    }

    /**
     * Тест валидности числа.
     */
    @Test
    fun testValidNumber() {
        val url = "https://main.community/i/123456"
        val pattern = Pattern.compile("https?://main.community/i/\\d+")
        assertTrue(url.matches(pattern.toRegex()))
    }

    /**
     * Тест валидности числа и его длины (ровно 6 символов).
     */
    @Test
    fun testValidNumberLength() {
        val url = "https://main.community/i/123456"
        val pattern = Pattern.compile("https?://main.community/i/\\d{6}\$")
        assertTrue(url.matches(pattern.toRegex()))
    }

    /**
     * Тест валидности числа длинной от 1 до 6 символов.
     */
    @Test
    fun testValidNumberLengthRange() {
        val url = "https://main.community/i/123456"
        val pattern = Pattern.compile("https?://main.community/i/\\d{1,6}\$")
        assertTrue(url.matches(pattern.toRegex()))
    }

    /**
     * Тест валидности числа с минимальной длинной 6 символов.
     */
    @Test
    fun testValidNumberMinLength() {
        val url = "https://main.community/i/123456"
        val pattern = Pattern.compile("https?://main.community/i/\\d{6,}\$")
        assertTrue(url.matches(pattern.toRegex()))
    }

    /**
     * Тест валидности выражения, состоящего из 6 символов и включающего цифры и прописные буквы.
     */
    @Test
    fun testValidExpression() {
        val url = "https://main.community/i/GIICMQ"
        val pattern = Pattern.compile("https?://main.community/i/\\b[A-Z0-9]{6}")
        assertTrue(url.matches(pattern.toRegex()))
    }
}