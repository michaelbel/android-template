package org.michaelbel.template.service.ui

import android.Manifest
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.core.ktx.granted
import org.michaelbel.template.service.R
import org.michaelbel.template.service.viewmodel.ServiceViewModel

@Composable
fun ServiceScreen(
    navController: NavController
) {
    val viewModel: ServiceViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            Toolbar(navController)
        }
    ) {
        Content(viewModel)
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_service)
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
    viewModel: ServiceViewModel
) {
    val context: Context = LocalContext.current

    fun downloadFile() {
        val url = "https://sample-videos.com/audio/mp3/wave.mp3"
        viewModel.downloadFile(url)

        //val directoryPath: String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
        //val fileName = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.getDefault()).format(Date()) + ".mp3"
        //val urlOfTheFile = "https://sample-videos.com/audio/mp3/wave.mp3"
        //DownloadManagerMy.initDownload(context, urlOfTheFile, directoryPath, fileName)
    }

    val writeStoragePermission = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted: Boolean ->
        if (granted) {
            downloadFile()
        } else {
            Toast.makeText(context, "Access Denied", Toast.LENGTH_SHORT).show()
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            OutlinedButton(
                onClick = {
                    if (Build.VERSION.SDK_INT <= 28) {
                        if (Manifest.permission.WRITE_EXTERNAL_STORAGE.granted(context)) {
                            downloadFile()
                        } else {
                            writeStoragePermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        }
                    } else {
                        downloadFile()
                    }
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) {
                Text(
                    text = stringResource(R.string.download_file)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {

                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) {
                Text(
                    text = stringResource(R.string.play_music)
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

    ServiceScreen(
        navController = navController
    )
}

@Preview
@Composable
private fun ScreenPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    ServiceScreen(
        navController = navController
    )
}