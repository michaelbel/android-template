package org.michaelbel.template.features.toast

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.features.toast.ui.ToastScreen
import timber.log.Timber

/**
 * Android 11 Toast Updates: add callback.
 */
@AndroidEntryPoint
class ToastFragment: Fragment() {

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(ToastFragment::class.simpleName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
                ToastScreen(::onNavigationBackClick, ::onShowToast)
            }
        }
    }

    private fun onNavigationBackClick() {
        findNavController().popBackStack()
    }

    private fun onShowToast() {
        val toast = Toast.makeText(
            requireContext(),
            "Simple toast message",
            Toast.LENGTH_SHORT
        ).also {
            it.setGravity(Gravity.CENTER, 0, 0)
            it.setMargin(0F, 0F)
        }

        if (Build.VERSION.SDK_INT >= 30) {
            toast.addCallback(object: Toast.Callback() {
                override fun onToastShown() {
                    Timber.d("onToastShown")
                }

                override fun onToastHidden() {
                    Timber.d("onToastHidden")
                }
            })
        }

        toast.show()
    }
}