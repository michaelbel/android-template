package org.michaelbel.template.storage

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.core.ktx.granted
import org.michaelbel.core.ktx.launchAndRepeatWithViewLifecycle
import org.michaelbel.template.storage.adapter.GalleryAdapter
import org.michaelbel.template.storage.databinding.FragmentStorageBinding
import org.michaelbel.template.storage.viewmodel.StorageViewModel

@AndroidEntryPoint
class StorageFragment: Fragment(R.layout.fragment_storage) {

    private val viewModel: StorageViewModel by viewModels()
    private val binding: FragmentStorageBinding by viewBinding()

    private val readStoragePermissionContract = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted: Boolean ->
        if (granted) {
            binding.queryButton.isGone = true
            viewModel.loadImages()
        } else {
            Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                "package:${requireContext().packageName}".toUri()
            ).also { intent: Intent ->
                appSettingsContract.launch(intent)
            }
        }
    }

    private val appSettingsContract = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {}

    private val galleryAdapter: GalleryAdapter by lazy {
        GalleryAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.run {
            adapter = galleryAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }
        binding.queryButton.setOnClickListener {
            readStoragePermissionContract.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        launchAndRepeatWithViewLifecycle {
            viewModel.imagesList.collect(galleryAdapter::submitList)
        }

        if (Manifest.permission.READ_EXTERNAL_STORAGE.granted(requireContext())) {
            binding.queryButton.isGone = true
            viewModel.loadImages()
        } else {
            binding.queryButton.isVisible = true
        }
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(this::class.simpleName)
    }
}