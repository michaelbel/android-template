package org.michaelbel.template.toast

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding

/**
 * Android 11 Toast Updates: add callback.
 */

@Composable
fun ToastScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            Toolbar(
                navController = navController
            )
        }
    ) {
        Content()
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_toast)
            )
        },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun Content() {
    val context: Context = LocalContext.current

    fun onShowToast() {
        val toast = Toast.makeText(
            context,
            "Simple toast message",
            Toast.LENGTH_SHORT
        ).also {
            it.setGravity(Gravity.CENTER, 0, 0)
            it.setMargin(0F, 0F)
        }

        if (Build.VERSION.SDK_INT >= 30) {
            toast.addCallback(object: Toast.Callback() {
                override fun onToastShown() {
                    /* not implemented */
                }

                override fun onToastHidden() {
                    /* not implemented */
                }
            })
        }

        toast.show()
    }

    Box {
        Button(
            onClick = { onShowToast() },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.show_toast)
            )
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    ToastScreen(
        navController = navController
    )
}

@Preview
@Composable
private fun ScreenPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    ToastScreen(
        navController = navController
    )
}