@file:Suppress("unused")

package org.michaelbel.core.ktx

import androidx.compose.foundation.lazy.LazyListState

val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemScrollOffset > 0