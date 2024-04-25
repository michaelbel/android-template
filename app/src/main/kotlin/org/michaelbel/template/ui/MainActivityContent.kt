@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.template.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.michaelbel.template.ui.compose.ComposeActivity
import org.michaelbel.template.ui.view.ViewActivity

@Composable
fun MainActivityContent(
    modifier: Modifier = Modifier
) {
    val context: Context = LocalContext.current

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    context.startActivity(Intent(context, ViewActivity::class.java))
                }
            ) {
                Text(
                    text = "View"
                )
            }
            Button(
                onClick = {
                    context.startActivity(Intent(context, ComposeActivity::class.java))
                }
            ) {
                Text(
                    text = "Compose"
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainActivityContentPreview() {
    TemplateTheme {
        MainActivityContent()
    }
}