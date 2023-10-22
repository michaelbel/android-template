package org.michaelbel.template.downloadfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@HiltViewModel
class DownloadFileViewModel @Inject constructor(
    private val workManager: WorkManager
): ViewModel() {

    var workInfo: Flow<WorkInfo> = emptyFlow()

    fun startDownloadFileWork(file: DownloadFile) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresStorageNotLow(false)
            .setRequiresBatteryNotLow(false)
            .setRequiresCharging(false)
            .build()

        val data = Data.Builder().apply {
            putString(FileParams.KEY_FILE_NAME, file.name)
            putString(FileParams.KEY_FILE_URL, file.url)
            putString(FileParams.KEY_FILE_TYPE, file.type)
        }

        val workRequest: OneTimeWorkRequest = OneTimeWorkRequestBuilder<FileDownloadWorker>()
            .setConstraints(constraints)
            .setInputData(data.build())
            .build()

        workManager.enqueueUniqueWork(
            "downloadFileWork_${System.currentTimeMillis()}",
            ExistingWorkPolicy.KEEP,
            workRequest
        )
        workInfo = workManager.getWorkInfoByIdLiveData(workRequest.id).asFlow()
    }
}