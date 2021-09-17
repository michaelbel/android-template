package org.michaelbel.template.update.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentUpdateBinding
import javax.inject.Inject

@AndroidEntryPoint
class UpdateFragment: Fragment(R.layout.fragment_update) {

    @Inject lateinit var analytics: Analytics

    private val binding: FragmentUpdateBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(UpdateFragment::class.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appUpdateManagerFactory = AppUpdateManagerFactory.create(requireContext())
        val appUpdateInfo = appUpdateManagerFactory.appUpdateInfo
        appUpdateInfo.addOnSuccessListener { updateInfo ->
            val message: String = String.format(
                getString(R.string.message_update_status),
                updateInfo.packageName(),
                updateInfo.availableVersionCode(),
                updateInfo.updateAvailability(),
                "${updateInfo.installStatus()}, ${installStatusName(updateInfo.installStatus())}",
                updateInfo.clientVersionStalenessDays(),
                updateInfo.updatePriority(),
                updateInfo.bytesDownloaded(),
                updateInfo.totalBytesToDownload(),
                updateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE),
                updateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE),
            )

            if (updateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                toggleButton(true)
            }

            binding.updateStatusTextView.text = message
        }
        appUpdateInfo.addOnFailureListener { exception ->
            binding.updateStatusTextView.text = "Exception: $exception"
            toggleButton(false)
        }
        appUpdateInfo.addOnCompleteListener {}

        binding.startUpdateButton.setOnClickListener {
            appUpdateManagerFactory.startUpdateFlow(
                appUpdateInfo.result,
                requireActivity(),
                AppUpdateOptions.defaultOptions(AppUpdateType.IMMEDIATE)
            )
        }
    }

    private fun toggleButton(visible: Boolean) {
        TransitionManager.beginDelayedTransition(binding.root)
        binding.startUpdateButton.isVisible = visible
    }

    private fun installStatusName(installStatus: Int): String {
        return when (installStatus) {
            InstallStatus.CANCELED -> "CANCELED"
            InstallStatus.DOWNLOADED -> "DOWNLOADED"
            InstallStatus.DOWNLOADING -> "DOWNLOADING"
            InstallStatus.FAILED -> "FAILED"
            InstallStatus.INSTALLED -> "INSTALLED"
            InstallStatus.INSTALLING -> "INSTALLING"
            InstallStatus.PENDING -> "PENDING"
            InstallStatus.UNKNOWN -> "UNKNOWN"
            else -> throw Exception("Unknown Install Status Name")
        }
    }
}