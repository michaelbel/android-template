package org.michaelbel.template.features.main

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
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

@HiltViewModel
class MainViewModel @Inject constructor(
    analytics: Analytics,
    private val inAppUpdate: InAppUpdate
): ViewModel() {

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
        analytics.trackScreen(MainFragment::class.simpleName)
        inAppUpdate.onUpdateAvailableListener = { updateAvailable ->
            updateAvailableMessage = updateAvailable
        }
        setData()
    }

    fun startUpdateFlow(activity: Activity) {
        inAppUpdate.startUpdateFlow(activity)
    }

    private fun setData() {
        viewModelScope.launch {
            screensList.value = listOf(
                ScreenData(Screen.InAppReview, bundleOf(), R.string.title_in_app_review),
                ScreenData(Screen.SavedState, bundleOf(), R.string.title_saved_state),
                ScreenData(Screen.Toast, bundleOf(), R.string.title_toast),
                ScreenData(Screen.Insets, bundleOf(), R.string.title_window_insets),
                ScreenData(Screen.Paging, bundleOf(), R.string.title_paging),
                ScreenData(Screen.Ads, bundleOf(), R.string.title_ads),
                ScreenData(
                    Screen.NavArgs,
                    bundleOf("firstText" to "Some Text", "secondNumber" to 100),
                    R.string.title_nav_args
                ),
                ScreenData(Screen.Config, bundleOf(), R.string.title_remote_config),
                ScreenData(Screen.MaterialYou, bundleOf(), R.string.title_material_you_colors),
                ScreenData(Screen.Fonts, bundleOf(), R.string.title_fonts),
                ScreenData(Screen.Social, bundleOf(), R.string.title_social),
                ScreenData(Screen.Notifications, bundleOf(), R.string.title_notifications),
                ScreenData(Screen.ConstraintsChains, bundleOf(), R.string.title_constraints_chains),
                ScreenData(
                    Screen.ConstraintsGuideline,
                    bundleOf(),
                    R.string.title_constraints_guideline
                ),
                ScreenData(
                    Screen.ConstraintsConstrainedWidth,
                    bundleOf(),
                    R.string.title_constraints_constrained_width
                ),
                ScreenData(
                    Screen.ConstraintsCircular,
                    bundleOf(),
                    R.string.title_constraints_circular
                ),
                ScreenData(
                    Screen.ConstraintsGoneMargins,
                    bundleOf(),
                    R.string.title_constraints_gone_margins
                ),
                ScreenData(Screen.Intents, bundleOf(), R.string.title_intents),
                ScreenData(Screen.SettingsPanel, bundleOf(), R.string.title_settings_panel),
                ScreenData(Screen.SystemServices, bundleOf(), R.string.title_system_services),
                ScreenData(Screen.Dialogs, bundleOf(), R.string.title_dialogs),
                ScreenData(Screen.Clipboard, bundleOf(), R.string.title_clipboard)
            )
        }
    }
}