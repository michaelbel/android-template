package org.michaelbel.core.room

import android.text.TextUtils
import androidx.room.TypeConverter

class ListStringConverter {

    @TypeConverter
    fun listToText(list: List<String>): String = TextUtils.join(SEPARATOR, list)

    @TypeConverter
    fun textToList(list: String): List<String> = list.split(SEPARATOR)

    private companion object {
        private const val SEPARATOR = "{ELEMENT_SEPARATOR}"
    }
}