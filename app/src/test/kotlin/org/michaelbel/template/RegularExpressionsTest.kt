package org.michaelbel.template

import org.junit.Assert.assertTrue
import org.junit.Test

class RegularExpressionsTest {

    /**
     * Тест валидности числа.
     */
    @Test
    fun testValidNumber() {
        val url = "https://main.community/i/123456"
        val regex: Regex = "https?://main.community/i/\\d+".toRegex()
        assertTrue(url.matches(regex))
    }

    /**
     * Тест валидности числа и его длины (ровно 6 символов).
     */
    @Test
    fun testValidNumberLength() {
        val url = "https://main.community/i/123456"
        val regex: Regex = "https?://main.community/i/\\d{6}\$".toRegex()
        assertTrue(url.matches(regex))
    }

    /**
     * Тест валидности числа длинной от 1 до 6 символов.
     */
    @Test
    fun testValidNumberLengthRange() {
        val url = "https://main.community/i/123456"
        val regex: Regex = "https?://main.community/i/\\d{1,6}\$".toRegex()
        assertTrue(url.matches(regex))
    }

    /**
     * Тест валидности числа с минимальной длинной 6 символов.
     */
    @Test
    fun testValidNumberMinLength() {
        val url = "https://main.community/i/123456"
        val regex: Regex = "https?://main.community/i/\\d{6,}\$".toRegex()
        assertTrue(url.matches(regex))
    }

    /**
     * Тест валидности выражения, состоящего из 6 символов и включающего цифры и прописные буквы.
     */
    @Test
    fun testValidExpression() {
        val url = "https://main.community/i/GIICMQ"
        val regex: Regex = "https?://main.community/i/\\b[A-Z0-9]{6}".toRegex()
        assertTrue(url.matches(regex))
    }
}