package org.michaelbel.template.features.materialyoucolors

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import javax.inject.Inject

@AndroidEntryPoint
class MaterialYouColorsFragment: Fragment(R.layout.fragment_material_you_colors) {

    @Inject lateinit var analytics: Analytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(MaterialYouColorsFragment::class.simpleName)
    }
}