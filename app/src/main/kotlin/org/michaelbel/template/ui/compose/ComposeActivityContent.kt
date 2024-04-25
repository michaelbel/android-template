@file:OptIn(ExperimentalAnimationApi::class)

package org.michaelbel.template.ui.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.michaelbel.template.auth.AuthScreen
import org.michaelbel.template.ui.TemplateTheme
import org.michaelbel.template.ui.compose.lazylist.LazyListScreen
import org.michaelbel.template.ui.compose.list.ListScreen

@Composable
fun ComposeActivityContent(
    onNavigateBack: () -> Unit
) {
    val navController: NavHostController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable(route = "list") {
            ListScreen(navController, onNavigateBack)
        }
        composable(route = "auth") {
            AuthScreen(navController)
        }
        composable(route = "lazyList") {
            LazyListScreen(navController)
        }
    }
}

@Preview
@Composable
private fun ComposeActivityContentPreview() {
    TemplateTheme {
        ComposeActivityContent(
            onNavigateBack = {}
        )
    }
}