package org.michaelbel.template.ui.view.main

import android.os.Bundle
import androidx.annotation.StringRes

data class ScreenData(
    val screen: Screen,
    val args: Bundle,
    @StringRes val titleRes: Int
)