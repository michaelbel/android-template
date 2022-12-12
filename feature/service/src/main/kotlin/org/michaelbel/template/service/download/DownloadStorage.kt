package org.michaelbel.template.service.download

import android.content.Context
import android.content.Intent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DownloadStorage @Inject constructor(
    @ApplicationContext private val context: Context
) {

    val files: MutableList<String> = mutableListOf()

    fun downloadFile(url: String) {
        files.add(url)

        val intent = Intent(context, DownloadService::class.java)
        context.startService(intent)
    }

    fun onCleared() {
        files.clear()
    }
}