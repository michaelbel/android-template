package org.michaelbel.template

import android.content.Context
import org.junit.Test
//import org.mockito.Mock
//import org.mockito.Mockito.`when`
//import org.mockito.junit.MockitoJUnitRunner

//@RunWith(MockitoJUnitRunner::class)
class StringsTest {

    //@Mock
    lateinit var context: Context

    @Test
    fun readStringFromContextTest() {
        //`when`(context.getString(R.string.app_name)).thenReturn(STRING_APP_NAME)
    }

    private companion object {
        private const val STRING_APP_NAME = "Template"
    }
}