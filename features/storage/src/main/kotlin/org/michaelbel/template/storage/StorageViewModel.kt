package org.michaelbel.template.storage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.michaelbel.template.storage.data.MediaExtractor
import org.michaelbel.template.storage.data.MediaStoreImage

@HiltViewModel
class StorageViewModel @Inject constructor(
    private val mediaExtractor: MediaExtractor
): ViewModel() {

    private val imagesListFlow: MutableStateFlow<List<MediaStoreImage>> = MutableStateFlow(emptyList())
    val imagesList: StateFlow<List<MediaStoreImage>> = imagesListFlow.asStateFlow()

    fun loadImages() = viewModelScope.launch {
        val images: List<MediaStoreImage> = withContext(Dispatchers.IO) {
            mediaExtractor.queryImages()
        }
        imagesListFlow.value = images
    }
}