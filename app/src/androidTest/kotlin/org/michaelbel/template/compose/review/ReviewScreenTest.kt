package org.michaelbel.template.compose.review

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.michaelbel.template.inappreview.ui.ReviewScreen
import org.michaelbel.template.ui.compose.ComposeActivity
import org.michaelbel.template.ui.AppTheme

@RunWith(AndroidJUnit4::class)
class ReviewScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComposeActivity>()

    private val context: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    private val navController: NavController
        get() = TestNavHostController(ApplicationProvider.getApplicationContext())

    private val onReviewButtonClick: () -> Unit = {}

    @Before
    fun setup() {
        composeTestRule.setContent {
            AppTheme {
                ReviewScreen(navController, onReviewButtonClick)
            }
        }
    }

    @Test
    fun screenTest() {
        composeTestRule
            .onNodeWithText("Review")
            .assertIsDisplayed()
    }
}