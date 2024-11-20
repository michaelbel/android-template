@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.text.InputFilter
import android.widget.EditText

private val PHONE_NUMBER_CHARS: CharArray = charArrayOf('+', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

fun EditText.selectionToEnd() {
    if (text.isNotEmpty()) {
        setSelection(text.length)
    }
}

fun EditText.allowJustText() {
    val notJustText: (Char) -> Boolean = {
        !Character.isLetter(it) && !Character.isSpaceChar(it)
    }
    restrictMatch(notJustText)
}

private fun EditText.restrictMatch(predicate: (Char) -> Boolean) {
    val inputTextFilter = InputFilter { source, start, end, _, _, _ ->
        if ((start until end).any { predicate(source[it]) }) {
            source.trim { predicate(it) }.toString()
        } else {
            null
        }
    }
    this.filters = arrayOf(inputTextFilter).plus(filters)
}

fun EditText.allowJustPhoneNumber() {
    val inputTextFilter = InputFilter { source, _, _, _, _, _ ->
        val inputString = source.toString()
        val inputStringLength = inputString.length
        val endWithPlus: Boolean = inputStringLength > 1 && inputString.endsWith("+")
        val phoneNumberChars: Boolean = inputStringLength > 0 && !PHONE_NUMBER_CHARS.contains(inputString[inputStringLength - 1])
        if (endWithPlus || phoneNumberChars) {
            source.removeRange(inputStringLength - 1, inputStringLength)
        } else {
            null
        }
    }

    this.filters = arrayOf(inputTextFilter).plus(filters)
}