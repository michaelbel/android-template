package org.michaelbel.template

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.security.InvalidParameterException

typealias OnNavigationBackClick = () -> Unit

enum class Screen {
    Ads,

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
    Main,
    NavArgs,
    SavedState,
    WindowInsets,

    GitHubApi,
    TmdbApi
}

val screensMap: Map<Screen, Int> = mapOf(
    Screen.Ads to R.id.adsFragment,
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
    Screen.Main to R.id.mainFragment,
    Screen.NavArgs to R.id.navArgsFragment,
    Screen.SavedState to R.id.savedStateFragment,
    Screen.WindowInsets to R.id.insetsFragment,

    Screen.GitHubApi to R.id.gitHubApiFragment,
    Screen.TmdbApi to R.id.tmdbApiFragment
)

fun Fragment.navigate(to: Screen, from: Screen, args: Bundle = bundleOf()) {
    if (to == from) {
        throw InvalidParameterException("Can't navigate to $to")
    }
    screensMap[to]?.let { destination -> findNavController().navigate(destination, args) }
}