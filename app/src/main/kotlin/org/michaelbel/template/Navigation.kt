package org.michaelbel.template

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.security.InvalidParameterException

typealias OnNavigationBackClick = () -> Unit

enum class Screen {
    Ads,
    Clipboard,
    Config,
    ConstraintsBaseline,
    ConstraintsChains,
    ConstraintsCircular,
    ConstraintsConstrainedWidth,
    ConstraintsGoneMargins,
    ConstraintsGuideline,
    Dialogs,
    Fonts,
    InAppReview,
    Intents,
    Main,
    MaterialYou,
    NavArgs,
    NetworkImage,
    Notifications,
    Paging,
    SavedState,
    SettingsPanel,
    Social,
    SystemServices,
    Toast,
    WindowInsets
}

val screensMap: Map<Screen, Int> = mapOf(
    Screen.Ads to R.id.adsFragment,
    Screen.Clipboard to R.id.clipboardFragment,
    Screen.Config to R.id.configFragment,
    Screen.ConstraintsBaseline to R.id.constraintsBaselineFragment,
    Screen.ConstraintsChains to R.id.constraintsChainStyleFragment,
    Screen.ConstraintsCircular to R.id.constraintsCircularFragment,
    Screen.ConstraintsConstrainedWidth to R.id.constraintsConstrainedWidthFragment,
    Screen.ConstraintsGoneMargins to R.id.constraintsGoneMarginFragment,
    Screen.ConstraintsGuideline to R.id.constraintsGuidelineFragment,
    Screen.Dialogs to R.id.dialogsFragment,
    Screen.Fonts to R.id.fontsFragment,
    Screen.InAppReview to R.id.reviewFragment,
    Screen.Intents to R.id.intentsFragment,
    Screen.Main to R.id.mainFragment,
    Screen.MaterialYou to R.id.materialYouColorsFragment,
    Screen.NavArgs to R.id.navArgsFragment,
    Screen.NetworkImage to R.id.networkImageFragment,
    Screen.Notifications to R.id.notificationsFragment,
    Screen.Paging to R.id.pagingFragment,
    Screen.SavedState to R.id.savedStateFragment,
    Screen.SettingsPanel to R.id.settingsPanelFragment,
    Screen.Social to R.id.socialFragment,
    Screen.SystemServices to R.id.systemServicesFragment,
    Screen.Toast to R.id.toastFragment,
    Screen.WindowInsets to R.id.insetsFragment,
)

fun Fragment.navigate(to: Screen, from: Screen, args: Bundle = bundleOf()) {
    if (to == from) {
        throw InvalidParameterException("Can't navigate to $to")
    }
    screensMap[to]?.let { destination -> findNavController().navigate(destination, args) }
}