package org.michaelbel.template

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PackageNameTest {

    @Test
    fun packageNameTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val applicationId: String = if (BuildConfig.DEBUG) {
            "org.michaelbel.template.debug"
        } else {
            "org.michaelbel.template"
        }
        assertEquals(applicationId, appContext.packageName)
    }
}