package org.michaelbel.template.features.browser

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.ui.platform.ComposeView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.R
import org.michaelbel.template.features.browser.model.Browser
import org.michaelbel.template.features.browser.model.BrowserType
import org.michaelbel.template.features.browser.model.InAppBrowser
import org.michaelbel.template.features.browser.ui.BrowserScreen

@Suppress("SameParameterValue")
@AndroidEntryPoint
class BrowserFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
                BrowserScreen(::onNavigationBackClick, ::onClick)
            }
        }
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }

    private fun onClick(browserType: BrowserType) {
        when (browserType) {
            Browser -> {
                startActivity(browserIntent("https://www.google.com"))
            }
            InAppBrowser -> {
                startActivity(inAppBrowseIntent("https://www.google.com"))
            }
        }
    }

    private fun browserIntent(url: String): Intent {
        return Intent(Intent.ACTION_VIEW, url.toUri())
    }

    private fun inAppBrowseIntent(url: String): Intent {
        val colorSchemeParams: CustomTabColorSchemeParams = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(ContextCompat.getColor(requireContext(), R.color.Primary))
            .build()
        val customTabsIntentBuilder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        customTabsIntentBuilder.setDefaultColorSchemeParams(colorSchemeParams)
        val customTabsIntent: CustomTabsIntent = customTabsIntentBuilder.build()
        customTabsIntent.intent.data = url.toUri()
        return customTabsIntent.intent
    }
}