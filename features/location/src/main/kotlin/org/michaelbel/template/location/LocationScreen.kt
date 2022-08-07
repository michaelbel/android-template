package org.michaelbel.template.location

import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import org.michaelbel.core.ktx.granted

@Composable
fun LocationScreen(
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
                text = stringResource(R.string.title_location)
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

    val fineLocationPermission = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted: Boolean ->

    }

    Box {
        Button(
            onClick = {
                if (Manifest.permission.ACCESS_FINE_LOCATION.granted(context)) {
                    Toast.makeText(context, "Fine Location Permission Granted", Toast.LENGTH_SHORT).show()
                } else {
                    fineLocationPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 16.dp)
        ) {
            Text(
                text = "ACCESS FINE LOCATION"
            )
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    LocationScreen(
        navController = navController
    )
}

@Preview
@Composable
private fun ScreenPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    LocationScreen(
        navController = navController
    )
}