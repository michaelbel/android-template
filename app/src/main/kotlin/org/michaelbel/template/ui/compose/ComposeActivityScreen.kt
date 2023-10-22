package org.michaelbel.template.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.michaelbel.template.ui.TemplateTheme

@Composable
fun ComposeActivityScreen(
    onNavigateBack: () -> Unit
) {
    val navController: NavHostController = rememberAnimatedNavController()

    NavContent(
        navController = navController,
        onNavigateBack = onNavigateBack
    )
}

@Preview
@Composable
private fun ComposeActivityScreenPreview() {
    TemplateTheme {
        ComposeActivityScreen(
            onNavigateBack = {}
        )
    }
}