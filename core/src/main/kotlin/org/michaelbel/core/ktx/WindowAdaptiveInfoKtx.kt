package org.michaelbel.core.ktx

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

inline val navigationSuiteType: NavigationSuiteType
    @Composable get() {
        val adaptiveInfo = currentWindowAdaptiveInfo()
        val density = LocalDensity.current
        val windowSize = with(density) { currentWindowSize().toSize().toDpSize() }
        return when {
            adaptiveInfo.windowPosture.isTabletop && isPortrait -> NavigationSuiteType.NavigationBar
            adaptiveInfo.windowSizeClass.isCompact && isPortrait -> NavigationSuiteType.NavigationBar
            adaptiveInfo.windowSizeClass.isExpanded && windowSize.width >= 1200.dp -> NavigationSuiteType.NavigationDrawer
            else -> NavigationSuiteType.NavigationRail
        }
    }