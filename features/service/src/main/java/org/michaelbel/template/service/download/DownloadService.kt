package org.michaelbel.template.service.download

import android.app.DownloadManager
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.IBinder
import androidx.core.net.toUri
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DownloadService: Service() {

    @Inject lateinit var notificationManager: NotificationManager
    @Inject lateinit var downloadManager: DownloadManager
    @Inject lateinit var downloadStorage: DownloadStorage

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onLowMemory() {
        super.onLowMemory()
        stopSelf()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        downloadFile()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        downloadStorage.onCleared()
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        stopSelf()
    }

    private fun downloadFile() {
        val uri: Uri = downloadStorage.files.first().toUri()

        val request: DownloadManager.Request = DownloadManager.Request(uri)
        request.setTitle("Downloading")
        request.setDescription("Please wait")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, uri.lastPathSegment)
        downloadManager.enqueue(request)
    }

    private companion object {
        private const val NOTIFICATION_CHANNEL = "File Downloader"
    }
}