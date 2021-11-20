package org.michaelbel.template

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.security.InvalidParameterException

typealias OnNavigationBackClick = () -> Unit

enum class Screen {
    Main,
    InAppReview,
    SavedState,
    Toast,
    Insets,
    Paging,
    Ads,
    NavArgs,
    Config,
    MaterialYou,
    Fonts,
    Social,
    Notifications,
    ConstraintsChains,
    ConstraintsGuideline,
    ConstraintsConstrainedWidth,
    ConstraintsCircular,
    ConstraintsGoneMargins,
    Intents,
    SettingsPanel,
    SystemServices,
    Dialogs
}

val screensMap: Map<Screen, Int> = mapOf(
    Screen.Main to R.id.mainFragment,
    Screen.InAppReview to R.id.reviewFragment,
    Screen.SavedState to R.id.savedStateFragment,
    Screen.Toast to R.id.toastFragment,
    Screen.Insets to R.id.insetsFragment,
    Screen.Paging to R.id.pagingFragment,
    Screen.Ads to R.id.adsFragment,
    Screen.NavArgs to R.id.navArgsFragment,
    Screen.Config to R.id.configFragment,
    Screen.MaterialYou to R.id.materialYouColorsFragment,
    Screen.Fonts to R.id.fontsFragment,
    Screen.Social to R.id.socialFragment,
    Screen.Notifications to R.id.notificationsFragment,
    Screen.ConstraintsChains to R.id.constraintsChainStyleFragment,
    Screen.ConstraintsGuideline to R.id.constraintsGuidelineFragment,
    Screen.ConstraintsConstrainedWidth to R.id.constraintsConstrainedWidthFragment,
    Screen.ConstraintsCircular to R.id.constraintsCircularFragment,
    Screen.ConstraintsGoneMargins to R.id.constraintsGoneMarginFragment,
    Screen.Intents to R.id.intentsFragment,
    Screen.SettingsPanel to R.id.settingsPanelFragment,
    Screen.SystemServices to R.id.systemServicesFragment,
    Screen.Dialogs to R.id.dialogsFragment
)

fun Fragment.navigate(to: Screen, from: Screen, args: Bundle = bundleOf()) {
    if (to == from) {
        throw InvalidParameterException("Can't navigate to $to")
    }
    screensMap[to]?.let { destination -> findNavController().navigate(destination, args) }
}