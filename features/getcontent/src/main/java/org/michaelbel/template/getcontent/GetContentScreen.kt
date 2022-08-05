package org.michaelbel.template.getcontent

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding

/**
 * Pick image from gallery
 * Pick video from gallery
 */

@Composable
fun GetContentScreen(
    navController: NavController
) {
    val context: Context = LocalContext.current

    val speechRecognizeContract = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        val data: Intent? = activityResult.data
        val spokenText: String? =
            data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.let { results ->
                results[0]
            }
        Toast.makeText(context, spokenText, Toast.LENGTH_SHORT).show()
    }

    val resultContract = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {}

    Scaffold(
        topBar = {
            Toolbar(navController)
        }
    ) {
        Content(
            resultContract,
            speechRecognizeContract
        )
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_get_content)
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
private fun Content(
    resultContract: ManagedActivityResultLauncher<Intent, ActivityResult>,
    speechRecognizeContract: ManagedActivityResultLauncher<Intent, ActivityResult>
) {
    val context: Context = LocalContext.current
    val packageName: String = context.packageName

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            OutlinedButton(
                onClick = {

                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            ) {
                Text(
                    text = "Pick Image"
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {

                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            ) {
                Text(
                    text = "Pick Video"
                )
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    GetContentScreen(
        navController = navController
    )
}

@Preview
@Composable
private fun ScreenPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    GetContentScreen(
        navController = navController
    )
}