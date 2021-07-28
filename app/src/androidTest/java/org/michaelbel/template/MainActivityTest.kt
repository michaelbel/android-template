package org.michaelbel.template

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = activityScenarioRule<MainActivity>()

    @Test
    fun testIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.navigationHostFragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}