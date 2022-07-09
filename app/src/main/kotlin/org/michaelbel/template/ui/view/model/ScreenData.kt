package org.michaelbel.template.ui.view.model

import android.os.Bundle
import androidx.annotation.StringRes
import org.michaelbel.template.ui.view.Screen

data class ScreenData(
    val screen: Screen,
    val args: Bundle,
    @StringRes val titleRes: Int
)