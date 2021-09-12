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
    Fonts
}

fun Fragment.navigate(to: Screen, from: Screen, args: Bundle = bundleOf()) {
    if (to == from) {
        throw InvalidParameterException("Can't navigate to $to")
    }

    when (to) {
        Screen.Main -> findNavController().navigate(R.id.mainFragment, args)
        Screen.InAppReview -> findNavController().navigate(R.id.reviewFragment, args)
        Screen.InAppUpdate -> findNavController().navigate(R.id.updateFragment, args)
        Screen.SavedState -> findNavController().navigate(R.id.savedStateFragment, args)
        Screen.Toast -> findNavController().navigate(R.id.toastFragment, args)
        Screen.Insets -> findNavController().navigate(R.id.insetsFragment, args)
        Screen.Paging -> findNavController().navigate(R.id.pagingFragment, args)
        Screen.Ads -> findNavController().navigate(R.id.adsFragment, args)
        Screen.NavArgs -> findNavController().navigate(R.id.navArgsFragment, args)
        Screen.Config -> findNavController().navigate(R.id.configFragment, args)
        Screen.MaterialYou -> findNavController().navigate(R.id.materialYouColorsFragment, args)
        Screen.Fonts -> findNavController().navigate(R.id.fontsFragment, args)
    }
}