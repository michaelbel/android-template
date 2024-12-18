@file:Suppress("unused")

package org.michaelbel.core.ktx

import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

inline val WindowSizeClass.isCompact: Boolean
    get() = windowWidthSizeClass == WindowWidthSizeClass.COMPACT || windowHeightSizeClass == WindowHeightSizeClass.COMPACT

inline val WindowSizeClass.isMedium: Boolean
    get() = windowWidthSizeClass == WindowWidthSizeClass.MEDIUM

inline val WindowSizeClass.isExpanded: Boolean
    get() = windowWidthSizeClass == WindowWidthSizeClass.EXPANDED