package org.michaelbel.template

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.systemBarsPadding
import org.michaelbel.core.ktx.setNavigationBarColorRes
import org.michaelbel.core.ktx.setStatusBarColorRes
import org.michaelbel.template.ui.theme.AppTheme

class SystemBarsPaddingActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_App)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setStatusBarColorRes(R.color.transparent)
        window.setNavigationBarColorRes(R.color.transparent)
        setContent {
            ProvideWindowInsets {
                AppTheme {
                    Surface(
                        color = Color.Yellow,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ContentView(modifier = Modifier.systemBarsPadding())
                    }
                }
            }
        }
    }
}

fun launchSecondActivity(context: Context) {
    val intent = Intent(context, SystemBarsPaddingActivity::class.java)
    context.startActivity(intent)
}

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            "Top Text",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .weight(1f)
        )
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .weight(1f)
        )
        Text(
            "Bottom Text",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
    }
}