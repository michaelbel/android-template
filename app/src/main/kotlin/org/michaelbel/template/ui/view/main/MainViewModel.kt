package org.michaelbel.template.ui.view.main

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.michaelbel.template.R
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val screensList = MutableStateFlow<List<ScreenData>>(listOf())
    private val networkLoading = MutableStateFlow(false)

    val uiState: StateFlow<MainScreenState> = combine(
        screensList,
        networkLoading
    ) { screensList: List<ScreenData>, _: Boolean ->
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

    private fun setContent() {
        viewModelScope.launch {
            screensList.value = listOf(
                ScreenData(
                    Screen.ConstraintsBaseline,
                    bundleOf(),
                    R.string.title_constraints_baseline
                ),
                ScreenData(
                    Screen.ConstraintsChains,
                    bundleOf(),
                    R.string.title_constraints_chains
                ),
                ScreenData(
                    Screen.ConstraintsCircular,
                    bundleOf(),
                    R.string.title_constraints_circular
                ),
                ScreenData(
                    Screen.ConstraintsConstrainedWidth,
                    bundleOf(),
                    R.string.title_constraints_constrained_width
                ),
                ScreenData(
                    Screen.ConstraintsGoneMargins,
                    bundleOf(),
                    R.string.title_constraints_gone_margins
                ),
                ScreenData(
                    Screen.ConstraintsGuideline,
                    bundleOf(),
                    R.string.title_constraints_guideline
                ),
                ScreenData(Screen.Fonts, bundleOf(), org.michaelbel.template.fonts.R.string.title_fonts),
                ScreenData(Screen.Storage, bundleOf(), org.michaelbel.template.storage.R.string.title_storage)
            )
        }
    }
}