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
        @StringRes override val titleRes: Int
    ): Destination(titleRes)
}

val fragmentMain: Destination
    get() = Destination.Fragment(R.id.mainFragment)

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