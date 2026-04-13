package org.michaelbel.shared.icons

import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

private var _formatPaint: ImageVector? = null
val FormatPaint: ImageVector
    get() {
        if (_formatPaint != null) {
            return _formatPaint!!
        }
        _formatPaint = materialIcon(name = "Outlined.FormatPaint") {
            materialPath {
                moveTo(18.0f, 4.0f)
                lineTo(18.0f, 3.0f)
                curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f)
                lineTo(5.0f, 2.0f)
                curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f)
                verticalLineToRelative(4.0f)
                curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f)
                horizontalLineToRelative(12.0f)
                curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f)
                lineTo(18.0f, 6.0f)
                horizontalLineToRelative(1.0f)
                verticalLineToRelative(4.0f)
                lineTo(9.0f, 10.0f)
                verticalLineToRelative(11.0f)
                curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f)
                horizontalLineToRelative(2.0f)
                curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f)
                verticalLineToRelative(-9.0f)
                horizontalLineToRelative(8.0f)
                lineTo(21.0f, 4.0f)
                horizontalLineToRelative(-3.0f)
                close()
                moveTo(16.0f, 6.0f)
                lineTo(6.0f, 6.0f)
                lineTo(6.0f, 4.0f)
                horizontalLineToRelative(10.0f)
                verticalLineToRelative(2.0f)
                close()
            }
        }
        return _formatPaint!!
    }