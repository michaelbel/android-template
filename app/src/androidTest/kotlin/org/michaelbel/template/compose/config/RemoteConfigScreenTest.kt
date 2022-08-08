package org.michaelbel.template.compose.config

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.michaelbel.template.ui.compose.ComposeActivity
import org.michaelbel.template.remoteconfig.ui.RemoteConfigScreen
import org.michaelbel.template.ui.AppTheme

@RunWith(AndroidJUnit4::class)
class RemoteConfigScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComposeActivity>()

    private val navController: NavController
        get() = TestNavHostController(ApplicationProvider.getApplicationContext())

    private val buttons: Array<String>
        get() = arrayOf(
            "Fetch Boolean Value",
            "Fetch String Value",
            "Fetch Number Value"
        )

    private val results: Array<String>
        get() = arrayOf(
            "true",
            "Hello World!",
            "42"
        )

    @Before
    fun setup() {
        composeTestRule.setContent {
            AppTheme {
                RemoteConfigScreen(navController)
            }
        }
    }

    @Test
    fun fetchBooleanValueTest() {
        composeTestRule
            .onNodeWithText(buttons.component1())
            .assertIsDisplayed()
            .performClick()
        composeTestRule
            .onNodeWithText(results.component1())
            .assertIsDisplayed()
    }

    @Test
    fun fetchStringValueTest() {
        composeTestRule
            .onNodeWithText(buttons.component2())
            .assertIsDisplayed()
            .performClick()
        composeTestRule
            .onNodeWithText(results.component2())
            .assertIsDisplayed()
    }

    @Test
    fun fetchNumberValueTest() {
        composeTestRule
            .onNodeWithText(buttons.component3())
            .assertIsDisplayed()
            .performClick()
        composeTestRule
            .onNodeWithText(results.component3())
            .assertIsDisplayed()
    }
}