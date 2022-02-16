package org.michaelbel.template.compose

import android.content.Context
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.runner.RunWith
import org.michaelbel.template.features.compose.ComposeActivity

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComposeActivity>()

    private val context: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    private val navController: NavController
        get() = TestNavHostController(ApplicationProvider.getApplicationContext())

    /*@Before
    fun setup() {
        composeTestRule.setContent {
            AppTheme {
                HomeScreen(navController)
            }
        }
    }*/

    /*@Test
    fun clipboardDestinationTest() {
        composeTestRule
            .onNodeWithText(context.getString(R.string.title_clipboard))
            .assertIsDisplayed()
            .performClick()

        Thread.sleep(5000L)

        Espresso.pressBack()
    }*/
}