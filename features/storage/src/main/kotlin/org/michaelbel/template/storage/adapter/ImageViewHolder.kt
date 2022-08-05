package org.michaelbel.template.storage.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.michaelbel.template.storage.data.MediaStoreImage
import org.michaelbel.template.storage.databinding.GalleryLayoutBinding

class ImageViewHolder(
    private val binding: GalleryLayoutBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(mediaStoreImage: MediaStoreImage) {
        binding.imageView.load(mediaStoreImage.contentUri)
    }
}