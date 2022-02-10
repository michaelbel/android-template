package org.michaelbel.template.features.main

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import org.michaelbel.template.Screen
import org.michaelbel.template.app.InAppUpdate
import org.michaelbel.template.features.main.model.ScreenData
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val inAppUpdate: InAppUpdate
): ViewModel() {

    private val _drawerShouldBeOpened = MutableStateFlow(false)
    val drawerShouldBeOpened: StateFlow<Boolean> = _drawerShouldBeOpened

    fun openDrawer() {
        _drawerShouldBeOpened.value = true
    }

    fun resetOpenDrawerAction() {
        _drawerShouldBeOpened.value = false
    }

    private val screensList = MutableStateFlow<List<ScreenData>>(listOf())
    private val networkLoading = MutableStateFlow(false)

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
        setData()
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(MainFragment::class.simpleName)
    }

    fun startUpdateFlow(activity: Activity) {
        inAppUpdate.startUpdateFlow(activity)
    }

    private fun setData() {
        viewModelScope.launch {
            screensList.value = listOf(
                ScreenData(Screen.Ads, bundleOf(), R.string.title_ads),
                ScreenData(Screen.Config, bundleOf(), R.string.title_remote_config),
                ScreenData(
                    Screen.ConstraintsBaseline,
                    bundleOf(),
                    R.string.title_constraints_baseline
                ),
                ScreenData(Screen.ConstraintsChains, bundleOf(), R.string.title_constraints_chains),
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
                ScreenData(Screen.Dialogs, bundleOf(), R.string.title_dialogs),
                ScreenData(Screen.Fonts, bundleOf(), R.string.title_fonts),
                ScreenData(Screen.InAppReview, bundleOf(), R.string.title_in_app_review),
                ScreenData(Screen.Intents, bundleOf(), R.string.title_intents),
                ScreenData(
                    Screen.NavArgs,
                    bundleOf("firstText" to "Some Text", "secondNumber" to 100),
                    R.string.title_nav_args
                ),
                ScreenData(Screen.SavedState, bundleOf(), R.string.title_saved_state),
                ScreenData(Screen.Social, bundleOf(), R.string.title_social),
                ScreenData(Screen.SystemServices, bundleOf(), R.string.title_system_services),
                ScreenData(Screen.Timer, bundleOf(), R.string.title_timer),
                ScreenData(Screen.Toast, bundleOf(), R.string.title_toast),
                ScreenData(Screen.WindowInsets, bundleOf(), R.string.title_window_insets),

                ScreenData(Screen.GitHubApi, bundleOf(), R.string.title_github),
                ScreenData(Screen.TmdbApi, bundleOf(), R.string.title_tmdb)
            )
        }
    }
}