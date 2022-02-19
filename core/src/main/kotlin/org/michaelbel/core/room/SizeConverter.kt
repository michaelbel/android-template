package org.michaelbel.core.room

import android.util.Size
import androidx.room.TypeConverter

class SizeConverter {

    @TypeConverter
    fun sizeToString(size: Size): String {
        return size.toString()
    }

    @TypeConverter
    fun stringToSize(data: String): Size {
        val width: Int = data.split("x").component1().toInt()
        val height: Int = data.split("x").component2().toInt()
        return Size(width, height)
    }
}