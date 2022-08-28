package org.michaelbel.core.ui.appbar

import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

@Suppress("unused")
abstract class AppBarStateChangeListener: AppBarLayout.OnOffsetChangedListener {

    private var currentState: AppBarState = AppBarState.IDLE

    override fun onOffsetChanged(appBarLayout: AppBarLayout, i: Int) {
        when {
            i == 0 -> {
                if (currentState != AppBarState.EXPANDED) {
                    onStateChanged(appBarLayout, AppBarState.EXPANDED)
                }
                currentState = AppBarState.EXPANDED
            }
            abs(i) >= appBarLayout.totalScrollRange -> {
                if (currentState != AppBarState.COLLAPSED) {
                    onStateChanged(appBarLayout, AppBarState.COLLAPSED)
                }
                currentState = AppBarState.COLLAPSED
            }
            else -> {
                if (currentState != AppBarState.IDLE) {
                    onStateChanged(appBarLayout, AppBarState.IDLE)
                }
                currentState = AppBarState.IDLE
            }
        }
    }

    abstract fun onStateChanged(appBarLayout: AppBarLayout, state: AppBarState)

    enum class AppBarState {
        EXPANDED,
        COLLAPSED,
        IDLE
    }
}