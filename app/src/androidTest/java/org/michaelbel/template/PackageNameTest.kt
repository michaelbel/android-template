package org.michaelbel.template

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.michaelbel.core.test.Fails

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Fails
@RunWith(AndroidJUnit4::class)
class PackageNameTest {

    @Test
    fun packageNameTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("org.michaelbel.template", appContext.packageName)
    }
}