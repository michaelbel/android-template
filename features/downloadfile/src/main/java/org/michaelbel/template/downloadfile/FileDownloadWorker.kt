package org.michaelbel.template.downloadfile

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.core.net.toUri
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.io.File
import java.io.FileOutputStream
import java.net.URL

@HiltWorker
class FileDownloadWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val params: WorkerParameters,
    private val downloadFileNotification: DownloadFileNotification
): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val fileUrl = inputData.getString(FileParams.KEY_FILE_URL).orEmpty()
        val fileName = inputData.getString(FileParams.KEY_FILE_NAME).orEmpty()
        val fileType = inputData.getString(FileParams.KEY_FILE_TYPE).orEmpty()

        if (fileName.isEmpty() || fileType.isEmpty() || fileUrl.isEmpty()) {
            Result.failure()
        }

        downloadFileNotification.show()

        val uri = getSavedFileUri(
            fileName = fileName,
            fileType = fileType,
            fileUrl = fileUrl,
            context = context
        )

        //downloadFileNotification.cancel()

        return if (uri != null) {
            Result.success(workDataOf(FileParams.KEY_FILE_URI to uri.toString()))
        } else {
            Result.failure()
        }
    }
}

private fun getSavedFileUri(
    fileName:String,
    fileType:String,
    fileUrl:String,
    context: Context
): Uri? {
    val mimeType: String = when (fileType) {
        "PDF" -> "application/pdf"
        "PNG" -> "image/png"
        "MP4" -> "video/mp4"
        else -> ""
    }

    if (mimeType.isEmpty()) return null

    if (Build.VERSION.SDK_INT >= 29) {
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
            put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
            put(MediaStore.MediaColumns.RELATIVE_PATH, "Download/DownloaderDemo")
        }

        val resolver = context.contentResolver

        val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)

        return if (uri != null) {
            URL(fileUrl).openStream().use { input->
                resolver.openOutputStream(uri).use { output->
                    input.copyTo(output!!, DEFAULT_BUFFER_SIZE)
                }
            }
            uri
        } else {
            null
        }
    } else {
        val target = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            fileName
        )
        URL(fileUrl).openStream().use { input->
            FileOutputStream(target).use { output ->
                input.copyTo(output)
            }
        }

        return target.toUri()
    }
}