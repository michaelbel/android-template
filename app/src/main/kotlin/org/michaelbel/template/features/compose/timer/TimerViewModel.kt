package org.michaelbel.template.features.compose.timer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class TimerViewModel @Inject constructor(): ViewModel() {

    var isTimeOver: Boolean by mutableStateOf(false)

    private var timerJob: Job? = null

    fun startTimer() {
        isTimeOver = false

        timerJob?.cancel()
        timerJob = tickerFlow(TimeUnit.SECONDS.toMillis(5))
            .onEach { isTimeOver = true }
            .launchIn(viewModelScope)
    }

    private fun tickerFlow(delay: Long): Flow<Unit> = flow {
        delay(delay)
        emit(Unit)
    }

    override fun onCleared() {
        super.onCleared()
        timerJob = null
    }
}