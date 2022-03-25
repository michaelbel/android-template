package org.michaelbel.template

import org.junit.Assert.assertTrue
import org.junit.Test

class MarkdownTest {

    /**
     * Тест ссылки
     */
    @Test
    fun testMarkdownLink() {
        val text = "[link](https:://google.com)"
        val regex: Regex = "\\[(.*?)]\\(.*?\\)".toRegex()
        assertTrue(text.matches(regex))
    }

    /**
     * Тест жирного курсивного текста
     */
    @Test
    fun testBoldItalicText() {
        val text = "***bold italic***"
        val regex: Regex = "(?<!\\\\)\\*\\*\\*(\\X+?)(?<!\\\\)\\*\\*\\*".toRegex()
        assertTrue(text.matches(regex))
    }

    /**
     * Тест жирного текста
     */
    @Test
    fun testBoldText() {
        val text = "**bold**"
        val regex: Regex = "(?<!\\\\)\\*\\*(\\X+?)(?<!\\\\)\\*\\*".toRegex()
        assertTrue(text.matches(regex))
    }

    /**
     * Тест курсивного текста
     */
    @Test
    fun testItalicText() {
        val text = "*italic*"
        val regex: Regex = "(?<!\\\\)\\*(\\X+?)(?<!\\\\)\\*".toRegex()
        assertTrue(text.matches(regex))
    }
}