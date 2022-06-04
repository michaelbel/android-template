package org.michaelbel.template.downloadfile

data class DownloadFile(
    val id: String,
    val name: String,
    val type: String,
    val url: String,
    var downloadedUri: String? = null,
    var isDownloading: Boolean = false
)