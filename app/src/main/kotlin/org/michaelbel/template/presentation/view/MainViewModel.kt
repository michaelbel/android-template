package org.michaelbel.template.presentation.view

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.inappupdate.InAppUpdate
import org.michaelbel.template.presentation.view.model.MainScreenState
import org.michaelbel.template.presentation.view.model.ScreenData

@HiltViewModel
class MainViewModel @Inject constructor(
    private val inAppUpdate: InAppUpdate
): ViewModel() {

    private val screensList = MutableStateFlow<List<ScreenData>>(listOf())
    private val networkLoading = MutableStateFlow(false)

    val observable = Observable.just(1, 2, 3)
        .map { number: Int -> number * number }

    private val flow: Flow<Int> = flowOf()

    val stateFlow: StateFlow<Int> = flow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0
        )

    val sharedFlow: SharedFlow<Int> = flow
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            replay = 0
        )

    val uiState: StateFlow<MainScreenState> = combine(
        screensList,
        networkLoading
    ) { screensList: List<ScreenData>, networkLoading: Boolean ->
        MainScreenState.MainScreen(
            list = screensList
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MainScreenState.Empty
    )

    var updateAvailableMessage: Boolean by mutableStateOf(false)

    init {
        inAppUpdate.onUpdateAvailableListener = { updateAvailable ->
            updateAvailableMessage = updateAvailable
        }
        setContent()

        observable.subscribe {

        }
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(MainFragment::class.simpleName)
    }

    fun startUpdateFlow(activity: Activity) {
        inAppUpdate.startUpdateFlow(activity)
    }

    private fun setContent() {
        viewModelScope.launch {
            screensList.value = listOf(
                ScreenData(Screen.Ads, bundleOf(), org.michaelbel.template.ads.R.string.title_ads),
                ScreenData(
                    Screen.ConstraintsBaseline,
                    bundleOf(),
                    org.michaelbel.template.constraintlayout.R.string.title_constraints_baseline
                ),
                ScreenData(
                    Screen.ConstraintsChains,
                    bundleOf(),
                    org.michaelbel.template.constraintlayout.R.string.title_constraints_chains
                ),
                ScreenData(
                    Screen.ConstraintsCircular,
                    bundleOf(),
                    org.michaelbel.template.constraintlayout.R.string.title_constraints_circular
                ),
                ScreenData(
                    Screen.ConstraintsConstrainedWidth,
                    bundleOf(),
                    org.michaelbel.template.constraintlayout.R.string.title_constraints_constrained_width
                ),
                ScreenData(
                    Screen.ConstraintsGoneMargins,
                    bundleOf(),
                    org.michaelbel.template.constraintlayout.R.string.title_constraints_gone_margins
                ),
                ScreenData(
                    Screen.ConstraintsGuideline,
                    bundleOf(),
                    org.michaelbel.template.constraintlayout.R.string.title_constraints_guideline
                ),
                ScreenData(Screen.Fonts, bundleOf(), org.michaelbel.template.fonts.R.string.title_fonts),
                ScreenData(Screen.Storage, bundleOf(), org.michaelbel.template.storage.R.string.title_storage)
            )
        }
    }
}