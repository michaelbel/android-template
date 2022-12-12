package org.michaelbel.template.storage.data

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MediaExtractor @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val contentResolver: ContentResolver
        get() = context.contentResolver

    fun queryImages(): List<MediaStoreImage> {
        val imagesList: MutableList<MediaStoreImage> = mutableListOf()
        var photoCursor: Cursor? = null
        try {
            photoCursor = contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Images.Media._ID),
                null,
                null,
                MediaStore.Images.Media.DATE_TAKEN + " DESC"
            )
            photoCursor?.use { cursor: Cursor ->
                val columnIndexId: Int = photoCursor.getColumnIndex(MediaStore.Images.Media._ID)
                while (cursor.moveToNext()) {
                    val id: Long = photoCursor.getLong(columnIndexId)
                    val contentUri: Uri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        id
                    )
                    imagesList.add(MediaStoreImage(id, contentUri))
                }
            }
        } catch (e: Exception) {
            return imagesList
        } finally {
            if (photoCursor != null && !photoCursor.isClosed) {
                photoCursor.close()
            }
        }
        return imagesList
    }
}