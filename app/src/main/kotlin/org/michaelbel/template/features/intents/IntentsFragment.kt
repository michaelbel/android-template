package org.michaelbel.template.features.intents

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.core.analytics.Event
import org.michaelbel.template.R
import org.michaelbel.template.features.intents.model.IntentItem
import org.michaelbel.template.features.intents.ui.IntentsScreen

@AndroidEntryPoint
class IntentsFragment: Fragment() {

    @Inject lateinit var analytics: Analytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(IntentsFragment::class.simpleName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
                IntentsScreen(::onNavigationBackClick, ::resolveIntent)
            }
        }
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }

    private fun resolveIntent(intent: IntentItem) {
        when (intent) {
            IntentItem.Share -> {
                val shareLink = "https://google.com"

                val shareIntent = Intent().apply {
                    type = "text/plain"
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, shareLink)
                }
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)))

                analytics.logEvent(Event.LINK_SHARE)
            }
            IntentItem.Email -> {
                val email = "michaelbel24865@gmail.com"
                val emailSubject = "Email Title"
                val emailText = "Email Body"

                val emailIntent = Intent(
                    Intent.ACTION_SENDTO,
                    Uri.fromParts("mailto", email, null)
                ).apply {
                    putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                    putExtra(Intent.EXTRA_TEXT, emailText)
                }
                startActivity(Intent.createChooser(emailIntent, getString(R.string.email_via)))
            }
            IntentItem.GooglePlay -> {
                val appMarketLink = "market://details?id=${requireContext().packageName}"
                val appBrowserLink = "https://play.google.com/store/apps/details?id=${requireContext().packageName}"

                try {
                    val googlePlayIntent = Intent(
                        Intent.ACTION_VIEW,
                        appMarketLink.toUri()
                    )
                    startActivity(googlePlayIntent)
                } catch (e: ActivityNotFoundException) {
                    val googlePlayIntent = Intent(
                        Intent.ACTION_VIEW,
                        appBrowserLink.toUri()
                    )
                    startActivity(googlePlayIntent)
                }
            }
            IntentItem.OpenTelegramChat -> {
                val telegramChat = "https://t.me/michaelbel"

                val telegramIntent = Intent(
                    Intent.ACTION_VIEW,
                    telegramChat.toUri()
                )
                startActivity(telegramIntent)
            }
        }
    }
}