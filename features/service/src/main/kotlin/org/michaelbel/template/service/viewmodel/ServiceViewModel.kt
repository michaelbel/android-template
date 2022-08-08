package org.michaelbel.template.service.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import org.michaelbel.template.service.download.DownloadStorage

@HiltViewModel
class ServiceViewModel @Inject constructor(
    private val downloadStorage: DownloadStorage
): ViewModel() {

    fun downloadFile(url: String) {
        downloadStorage.downloadFile(url)
    }
}