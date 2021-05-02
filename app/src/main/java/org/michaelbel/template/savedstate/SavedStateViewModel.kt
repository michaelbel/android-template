package org.michaelbel.template.savedstate

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * SavedStateHandle позволяет пережить убийство фонового процесса приложения!
 */
@HiltViewModel
class SavedStateViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    fun saveId(userId: Int) {
        savedStateHandle.set("userId", userId)
    }

    fun getUserId(): Int? {
        return savedStateHandle.get<Int>("userId")
    }
}