package org.michaelbel.template.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.michaelbel.template.ui.Destination
import org.michaelbel.template.ui.fragmentsItems

internal class MainViewModel: ViewModel() {

    private val screensList = MutableStateFlow<List<Destination.Fragment>>(listOf())
    private val networkLoading = MutableStateFlow(false)

    val uiState: StateFlow<MainScreenState> = combine(
        screensList,
        networkLoading
    ) { screensList: List<Destination.Fragment>, _: Boolean ->
        MainScreenState.MainScreen(
            list = screensList
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MainScreenState.Empty
    )

    init {
        setContent()
    }

    private fun setContent() = viewModelScope.launch {
        screensList.value = fragmentsItems
    }
}