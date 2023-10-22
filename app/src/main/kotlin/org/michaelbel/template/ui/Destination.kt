package org.michaelbel.template.ui

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import org.michaelbel.template.R

sealed class Destination(
    @StringRes open val titleRes: Int
) {

    data class Fragment(
        @IdRes val fragmentId: Int,
        @StringRes override val titleRes: Int = 0
    ): Destination(titleRes)

    data class Composable(
        val route: String,
        @StringRes override val titleRes: Int
    ): Destination(titleRes)
}

val fragmentsItems: List<Destination.Fragment>
    get() {
        return listOf(
            Destination.Fragment(
                R.id.constraintsBaselineFragment,
                R.string.title_constraints_baseline
            ),
            Destination.Fragment(
                R.id.constraintsChainStyleFragment,
                R.string.title_constraints_chains
            ),
            Destination.Fragment(
                R.id.constraintsCircularFragment,
                R.string.title_constraints_circular
            ),
            Destination.Fragment(
                R.id.constraintsConstrainedWidthFragment,
                R.string.title_constraints_constrained_width
            ),
            Destination.Fragment(
                R.id.constraintsGoneMarginFragment,
                R.string.title_constraints_gone_margins
            ),
            Destination.Fragment(
                R.id.constraintsGuidelineFragment,
                R.string.title_constraints_guideline
            ),
            Destination.Fragment(
                R.id.fontsFragment,
                org.michaelbel.template.fonts.R.string.title_fonts
            ),
            Destination.Fragment(
                R.id.storageFragment,
                org.michaelbel.template.storage.R.string.title_storage
            )
        )
    }

val composableItems: List<Destination.Composable>
    get() {
        return listOf(
            Destination.Composable("auth", R.string.title_social),
            Destination.Composable("download_file", R.string.title_storage),
            Destination.Composable("clipboard", R.string.title_clipboard),
            Destination.Composable("ime", R.string.title_ime_actions),
            Destination.Composable("review", R.string.title_in_app_review),
            Destination.Composable("intents", R.string.title_intents),
            Destination.Composable("location", R.string.title_location),
            Destination.Composable("config", R.string.title_remote_config),
            Destination.Composable("service", R.string.title_service),
            Destination.Composable("toast", R.string.title_toast),
            Destination.Composable("lazyList", R.string.title_lazy_list),
            Destination.Composable("getcontent", R.string.title_get_content),
            Destination.Composable("phone_calls", R.string.title_phone_calls),
        )
    }