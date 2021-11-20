package org.michaelbel.template.features.savedstate

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics

/**
 * SavedStateHandle позволяет пережить убийство фонового процесса приложения!
 */
@HiltViewModel
class SavedStateViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val analytics: Analytics
): ViewModel() {

    init {
        analytics.trackScreen(SavedStateFragment::class.simpleName)
    }

    fun saveId(userId: Int) {
        savedStateHandle.set("userId", userId)
    }

    fun getUserId(): Int? {
        return savedStateHandle.get<Int>("userId")
    }
}