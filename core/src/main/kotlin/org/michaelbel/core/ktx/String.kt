@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.core.util.PatternsCompat
import java.util.Properties

fun String.append(text: String): String = "$this$text"

@Suppress("Deprecation")
inline val String.fromHtml: Spanned
    get() = if (Build.VERSION.SDK_INT >= 24) {
        Html.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(this)
    }

fun Context.loadProperty(fileName: String, key: String): String? {
    return try {
        val properties = Properties()
        val inputStream = assets.open(fileName)
        properties.load(inputStream)
        properties.getProperty(key)
    } catch (e: Exception) {
        null
    }
}

/**
 * Валидация текста на наличие только латиницы и кириллицы.
 */
inline val CharSequence.isTextOnly: Boolean
    get() = isNotEmpty() && isNotBlank() && matches("[a-zA-Zа-яА-я]+".toRegex())

/**
 * Проверка валидность URL.
 */
inline val String.isUrlValid: Boolean
    get() = PatternsCompat.WEB_URL.matcher(this).matches()

/**
 * Splits by spaces, newlines, and tabs only
 */
val String.camelCased: String
    get() {
        val split = lowercase().split(' ', '\n', '\t').toMutableList()
        if (split.size > 1) {
            for (i in 1 until split.size) {
                if (split[i].length > 1) {
                    val charArray = split[i].toCharArray()
                    charArray[0] = charArray[0].uppercaseChar()
                    split[i] = String(charArray)
                }
            }
        }
        return split.joinToString("")
    }

val String.containsLetters: Boolean
    get() = matches(".*[a-zA-Z].*".toRegex())

val String.containsNumbers: Boolean
    get() = matches(".*[0-9].*".toRegex())

/**
 * Does not allow whitespace or symbols
 * Allows empty string
 */
val String.isAlphanumeric: Boolean
    get() = matches("^[a-zA-Z0-9]*$".toRegex())

/**
 * Does not allow whitespace or symbols
 * Allows empty string
 */
val String.isAlphabetic: Boolean
    get() = matches("^[a-zA-Z]*$".toRegex())

/**
 * Does not allow whitespace or symbols
 * Allows empty string
 */
val String.isNumeric: Boolean
    get() = matches("^[0-9]*$".toRegex())

val String.isEmail: Boolean
    get() = matches(PatternsCompat.EMAIL_ADDRESS.toRegex())

/**
 * If there is more than one most common character,
 * this returns the character that occurred first in the String
 */
val String.mostCommonChar: Char?
    get() {
        if (this.isEmpty()) return null
        val map = hashMapOf<Char, Int>()
        for (char in toCharArray()) map[char] = (map[char] ?: 0) + 1
        var maxEntry = map.entries.elementAt(0)
        for (entry in map) maxEntry = if (entry.value > maxEntry.value) entry else maxEntry
        return maxEntry.key
    }

fun String.takeNumber(countBefore: Int, countAfter: Int): String {
    val filteredChars = filterIndexed { index, char ->
        char in "0123456789" || (char == '.' && indexOf('.') == index)
    }
    return if(filteredChars.contains('.')) {
        val beforeDecimal: String = filteredChars.substringBefore('.')
        val afterDecimal = filteredChars.substringAfter('.')
        beforeDecimal.take(countBefore) + "." + afterDecimal.take(countAfter)
    } else {
        filteredChars.take(countBefore)
    }
}