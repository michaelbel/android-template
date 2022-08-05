@file:Suppress("unused")

package org.michaelbel.core.ui.inputfilter

import android.text.InputFilter
import android.text.Spanned
import org.michaelbel.core.BuildConfig

class RangeInputFilter(
    private val min: Int = 0,
    private val max: Int = 0
): InputFilter {

    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        try {
            val input = Integer.parseInt(dest.toString() + source.toString())
            if (isInRange(min, max, input)) {
                return null
            }
        } catch (e: NumberFormatException) {
            if (BuildConfig.DEBUG) error(e)
        }

        return ""
    }

    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c in a..b else c in b..a
    }
}