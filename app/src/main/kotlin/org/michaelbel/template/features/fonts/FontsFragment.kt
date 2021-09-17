package org.michaelbel.template.features.fonts

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import javax.inject.Inject

@AndroidEntryPoint
class FontsFragment: Fragment(R.layout.fragment_fonts) {

    @Inject lateinit var analytics: Analytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(FontsFragment::class.simpleName)
    }
}