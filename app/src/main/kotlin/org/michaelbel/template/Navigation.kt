package org.michaelbel.template

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.security.InvalidParameterException

enum class Screen {
    Main,
    InAppReview,
    InAppUpdate,
    SavedState,
    Toast,
    Insets,
    Paging,
    Ads,
    NavArgs,
    Config,
    MaterialYou,
    Fonts,
    Search
}

val screensMap: Map<Screen, Int> = mapOf(
    Screen.Main to R.id.mainFragment,
    Screen.InAppReview to R.id.reviewFragment,
    Screen.InAppUpdate to R.id.updateFragment,
    Screen.SavedState to R.id.savedStateFragment,
    Screen.Toast to R.id.toastFragment,
    Screen.Insets to R.id.insetsFragment,
    Screen.Paging to R.id.pagingFragment,
    Screen.Ads to R.id.adsFragment,
    Screen.NavArgs to R.id.navArgsFragment,
    Screen.Config to R.id.configFragment,
    Screen.MaterialYou to R.id.materialYouColorsFragment,
    Screen.Fonts to R.id.fontsFragment,
    Screen.Search to R.id.searchFragment
)

fun Fragment.navigate(to: Screen, from: Screen, args: Bundle = bundleOf()) {
    if (to == from) {
        throw InvalidParameterException("Can't navigate to $to")
    }

    screensMap[to]?.let { destination -> findNavController().navigate(destination, args) }
}