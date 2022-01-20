@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import org.michaelbel.core.R

inline val Context.isTablet: Boolean
    get() = resources.getBoolean(R.bool.tablet)

inline val Context.isDarkTheme: Boolean
    get() = resources.getBoolean(R.bool.darkTheme)