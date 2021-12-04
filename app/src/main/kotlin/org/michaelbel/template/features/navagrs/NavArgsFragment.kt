package org.michaelbel.template.features.navagrs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.features.navagrs.ui.NavArgsScreen

/**
 * Navigation Arguments.
 */
@AndroidEntryPoint
class NavArgsFragment: Fragment() {

    @Inject lateinit var analytics: Analytics

    private val args: NavArgsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(NavArgsFragment::class.simpleName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
                NavArgsScreen(args, ::onNavigationBackClick)
            }
        }
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }
}