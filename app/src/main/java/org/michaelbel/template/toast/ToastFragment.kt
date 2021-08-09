package org.michaelbel.template.toast

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver
import com.google.android.material.composethemeadapter.MdcTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Android 11 Toast Updates: add callback.
 */
@AndroidEntryPoint
class ToastFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        val windowInsets = ViewWindowInsetObserver(this).start()

        setContent {
            CompositionLocalProvider(LocalWindowInsets provides windowInsets) {
                MdcTheme {
                    Box(modifier = Modifier.fillMaxSize()) {
                        TopAppBar(
                            title = { Text(text = "Toast") },
                            modifier = Modifier.align(Alignment.TopCenter),
                            navigationIcon = {
                                IconButton(onClick = { findNavController().popBackStack() }) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = "Arrow Back"
                                    )
                                }
                            },
                            elevation = 2.dp
                        )
                        Button(
                            onClick = { showToast() },
                            modifier = Modifier.align(Alignment.Center)
                        ) {
                            Text(text = "Show Toast")
                        }
                    }
                }
            }
        }
    }

    private fun showToast() {
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