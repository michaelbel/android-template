package org.michaelbel.template.ui

import androidx.annotation.IdRes
import androidx.annotation.StringRes

sealed class Destination(
    @StringRes open val titleRes: Int
) {

    data class Fragment(
        @IdRes val fragmentId: Int,
        @StringRes override val titleRes: Int = 0
    ): Destination(titleRes)
}

val fragmentsItems: List<Destination.Fragment>
    get() {
        return listOf()
    }