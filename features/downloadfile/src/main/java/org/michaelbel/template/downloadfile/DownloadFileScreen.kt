package org.michaelbel.template.downloadfile

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DownloadFileScreen(
    navController: NavController
) {
    val context: Context = LocalContext.current
    val viewModel: DownloadFileViewModel = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val data = remember {
            mutableStateOf(
                DownloadFile(
                    id = "10",
                    name = "Pdf File 10 MB",
                    type = "PDF",
                    url = "https://www.learningcontainer.com/wp-content/uploads/2019/09/sample-pdf-download-10-mb.pdf",
                    downloadedUri = null
                )
            )
        }

        ItemFile(
            file = data.value,
            startDownload = {
                viewModel.startDownloadFileWork(data.value)

                /*startDownloadingFile(
                    file = data.value,
                    success = {
                        data.value = data.value.copy().apply {
                            isDownloading = false
                            downloadedUri = it
                        }
                    },
                    failed = {

                        data.value = data.value.copy().apply {
                            isDownloading = false
                            downloadedUri = null
                        }
                    },
                    running = {
                        data.value = data.value.copy().apply {
                            isDownloading = true
                        }
                    }
                )*/
            },
            openFile = {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setDataAndType(it.downloadedUri?.toUri(),"application/pdf")
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException){
                    Toast.makeText(
                        context,
                        "Can't open Pdf",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }
}

@Composable
fun ItemFile(
    file: DownloadFile,
    startDownload: (DownloadFile) -> Unit,
    openFile: (DownloadFile) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .border(width = 2.dp, color = Color.Blue, shape = RoundedCornerShape(16.dp))
            .clickable {
                if (!file.isDownloading) {
                    if (file.downloadedUri.isNullOrEmpty()) {
                        startDownload(file)
                    } else {
                        openFile(file)
                    }
                }
            }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = file.name,
                    color = Color.Black
                )

                Row {
                    val description = if (file.isDownloading){
                        "Downloading..."
                    }else{
                        if (file.downloadedUri.isNullOrEmpty()) "Tap to download the file" else "Tap to open file"
                    }
                    Text(
                        text = description,
                        color = Color.DarkGray
                    )
                }

            }

            if (file.isDownloading){
                CircularProgressIndicator(
                    color = Color.Blue,
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}