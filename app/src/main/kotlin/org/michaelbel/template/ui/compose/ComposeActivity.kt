package org.michaelbel.template.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.template.inappreview.InAppReview
import org.michaelbel.template.ui.AppTheme

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

    Scaffold {
        Content(
            navController = navController,
            onReviewButtonClick = onReviewButtonClick
        )
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