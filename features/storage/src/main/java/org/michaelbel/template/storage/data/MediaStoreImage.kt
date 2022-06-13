package org.michaelbel.template.storage.data

import android.net.Uri
import androidx.recyclerview.widget.DiffUtil

data class MediaStoreImage(
    val id: Long,
    val contentUri: Uri
) {
    companion object {
        val DiffCallback = object: DiffUtil.ItemCallback<MediaStoreImage>() {
            override fun areItemsTheSame(
                oldItem: MediaStoreImage,
                newItem: MediaStoreImage
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MediaStoreImage,
                newItem: MediaStoreImage
            ): Boolean = oldItem == newItem
        }
    }
}