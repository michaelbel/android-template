package org.michaelbel.template.features.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.template.R
import org.michaelbel.template.inappreview.InAppReview
import org.michaelbel.template.ui.theme.AppTheme

@AndroidEntryPoint
class ComposeActivity: ComponentActivity() {

    @Inject lateinit var inAppReview: InAppReview

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(org.michaelbel.core.R.style.Theme_App)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets {
                AppTheme {
                    ComposeActivityScreen(::launchReviewFlow)
                }
            }
        }
    }

    private fun launchReviewFlow() {
        inAppReview.launchReviewFlow(this)
    }
}

@Composable
private fun ComposeActivityScreen(
    onReviewButtonClick: () -> Unit
) {
    val navController: NavHostController = rememberAnimatedNavController()

    Scaffold(
        /*bottomBar = {
            BottomBar(navController)
        }*/
    ) {
        Content(
            navController = navController,
            onReviewButtonClick = onReviewButtonClick
        )
    }
}

@Composable
private fun BottomBar(
    navController: NavController
) {
    val items = listOf(
        ROUTE_HOME,
        ROUTE_CLIPBOARD,
        ROUTE_NETWORK_IMAGE,
        ROUTE_NOTIFICATIONS
    )

    NavigationBar(
        modifier = Modifier.systemBarsPadding()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.map { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = stringResource(R.string.bottom_item_compose)
                    )
                },
                label = {
                    Text(
                        text = "Compose"
                    )
                },
                selected = currentRoute == screen,
                onClick = {
                    navController.navigate(screen) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    val onReviewButtonClick: () -> Unit = {}

    AppTheme {
        ComposeActivityScreen(
            onReviewButtonClick = onReviewButtonClick
        )
    }
}

@Preview
@Composable
private fun ScreenPreviewDark() {
    val onReviewButtonClick: () -> Unit = {}

    AppTheme(
        darkTheme = true
    ) {
        ComposeActivityScreen(
            onReviewButtonClick = onReviewButtonClick
        )
    }
}