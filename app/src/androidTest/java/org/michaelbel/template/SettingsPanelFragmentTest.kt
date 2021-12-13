package org.michaelbel.template

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SettingsPanelFragmentTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun jumpToSettingsPanelFragment() {
        composeTestRule.activityRule.scenario.onActivity {
            val bundle = bundleOf()
            findNavController(it, R.id.navigationHostFragment)
                .navigate(R.id.settingsPanelFragment, bundle)
        }
    }

    @Test
    fun screen_launches() {
        //composeTestRule.onNodeWithText("Apple").assertIsDisplayed()
    }

    @Test
    fun testShareTextIntent() {
        /*Intents.init()

        composeTestRule.onNodeWithText("Apple").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Share").assertIsDisplayed().performClick()

        intended(
            chooser(
                allOf(
                    hasAction(Intent.ACTION_SEND),
                    hasType("text/plain"),
                    hasExtra(
                        Intent.EXTRA_TEXT,
                        "Check out the Apple plant in the Android Sunflower app"
                    )
                )
            )
        )
        Intents.release()

        // dismiss the Share Dialog
        InstrumentationRegistry.getInstrumentation()
            .uiAutomation
            .performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)*/
    }
}
