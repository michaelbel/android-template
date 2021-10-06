package org.michaelbel.template.features.constraints

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import javax.inject.Inject

@AndroidEntryPoint
class ConstrainsFragment: Fragment(R.layout.fragment_constraints) {

    @Inject lateinit var analytics: Analytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(ConstrainsFragment::class.simpleName)
    }
}