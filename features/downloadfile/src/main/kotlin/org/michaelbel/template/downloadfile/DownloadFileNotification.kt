@file:OptIn(NotificationDsl::class)

package org.michaelbel.template.downloadfile

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.kirich1409.androidnotificationdsl.NotificationDsl
import com.kirich1409.androidnotificationdsl.progress.progressNotification
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DownloadFileNotification @Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationManager: NotificationManager
) {

    fun show() {
        if (Build.VERSION.SDK_INT >= 26) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                setSound(null, null)
                enableVibration(false)
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
                description = CHANNEL_DESCRIPTION
            }
            notificationManager.createNotificationChannel(channel)
        }

        /*createNotificationChannels(context) {
            channel(
                id = CHANNEL_ID,
                name = CHANNEL_NAME,
                importance = NotificationImportance.DEFAULT
            )
        }*/

        val notification = progressNotification(context, CHANNEL_ID, R.drawable.ic_download) {
            title = "Downloading file..."
            progressText = "Downloading..."
            indeterminated = true
            progress {
                current = 0
                max = 0
            }
        }

        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    fun cancel() {
        notificationManager.cancel(NOTIFICATION_ID)
    }

    private companion object {
        private const val NOTIFICATION_ID = 1
        private const val CHANNEL_ID = "download_file_channel_id"
        private const val CHANNEL_NAME = "Download Files"
        private const val CHANNEL_DESCRIPTION = "Download Files"
    }
}