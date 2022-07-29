@file:Suppress("unused")

package org.michaelbel.core.ui.list

import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.max
import kotlin.math.min

/**
 * @param radius corner radius size.
 */
class RoundCornersItemDecoration(
    private val radius: Float
): RecyclerView.ItemDecoration() {

    private val defaultRectToClip: RectF = RectF(Float.MAX_VALUE, Float.MAX_VALUE, 0F, 0F)

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val rectToClip: RectF = getRectToClip(parent)

        if (rectToClip == defaultRectToClip) {
            return
        }

        val path: Path = Path().apply {
            addRoundRect(rectToClip, radius, radius, Path.Direction.CW)
        }
        canvas.clipPath(path)
    }

    private fun getRectToClip(parent: RecyclerView): RectF {
        val rectToClip = RectF(defaultRectToClip)
        val childRect = Rect()

        fun drawTopCorners(itemView: View) {
            parent.getDecoratedBoundsWithMargins(itemView, childRect)
            rectToClip.left = min(rectToClip.left, childRect.left.toFloat())
            rectToClip.top = min(rectToClip.top, childRect.top.toFloat())
        }

        fun drawBottomCorners(itemView: View) {
            parent.getDecoratedBoundsWithMargins(itemView, childRect)
            rectToClip.right = max(rectToClip.right, childRect.right.toFloat())
            rectToClip.bottom = max(rectToClip.bottom, childRect.bottom.toFloat())
        }

        for (item in 0 until parent.childCount) {
            if (item == 0) {
                val child: View = parent.getChildAt(item)
                drawTopCorners(child)
            }

            if (item == parent.childCount - 1) {
                val child: View = parent.getChildAt(item)
                drawBottomCorners(child)
            }
        }

        return rectToClip
    }
}