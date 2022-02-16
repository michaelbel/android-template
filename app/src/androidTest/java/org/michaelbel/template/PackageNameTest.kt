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
        assertEquals("org.michaelbel.template", appContext.packageName)
    }
}