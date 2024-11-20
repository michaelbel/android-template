@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

inline val File.type: String
    get() = absolutePath.substring(absolutePath.lastIndexOf(".") + 1)

inline val File.toBitmap: Bitmap
    get() = BitmapFactory.decodeFile(absolutePath)

fun File.size(): Long {
    return try {
        var length = 0L
        if (this.exists()) {
            val files: Array<File>? = this.listFiles()
            files?.forEach {
                length += if (it.isFile) it.length() else it.size()
            }
        }
        length
    } catch (ignored: Exception) {
        0L
    }
}