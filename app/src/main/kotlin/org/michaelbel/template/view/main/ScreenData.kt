package org.michaelbel.template.view.main

import android.os.Bundle
import androidx.annotation.StringRes
import org.michaelbel.template.view.main.Screen

data class ScreenData(
    val screen: Screen,
    val args: Bundle,
    @StringRes val titleRes: Int
)