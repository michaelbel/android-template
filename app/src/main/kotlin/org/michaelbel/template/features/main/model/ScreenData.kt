package org.michaelbel.template.features.main.model

import android.os.Bundle
import androidx.annotation.StringRes
import org.michaelbel.template.Screen

data class ScreenData(
    val screen: Screen,
    val args: Bundle,
    @StringRes val titleRes: Int
)