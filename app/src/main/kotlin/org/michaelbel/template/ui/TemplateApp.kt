package org.michaelbel.template.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import org.michaelbel.template.ui.theme.BlueTheme

@Composable
fun TemplateApp(finishActivity: () -> Unit) {
    ProvideWindowInsets {
        BlueTheme {
            val navController = rememberNavController()
            Scaffold(
                backgroundColor = MaterialTheme.colors.primarySurface
            ) { innerPaddingModifier ->
                /*NavGraph(
                    finishActivity = finishActivity,
                    navController = navController,
                    modifier = Modifier.padding(innerPaddingModifier)
                )*/
            }
        }
    }
}