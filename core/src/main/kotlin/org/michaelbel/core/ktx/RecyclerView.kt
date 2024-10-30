@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

val RecyclerView.ViewHolder.context: Context
    get() = itemView.context

val RecyclerView.linearLayoutManager: LinearLayoutManager
    get() = layoutManager as LinearLayoutManager

val RecyclerView.gridLayoutManager: GridLayoutManager
    get() = layoutManager as GridLayoutManager

val RecyclerView.staggeredGridLayoutManager: StaggeredGridLayoutManager
    get() = layoutManager as StaggeredGridLayoutManager

fun RecyclerView.smartScrollToTop() {
    val smoothScrollCount = 10
    val scrollLambda = { lastVisiblePosition: Int ->
        if (lastVisiblePosition <= smoothScrollCount) {
            smoothScrollToPosition(0)
        } else {
            scrollToPosition(smoothScrollCount)
            setOnGlobalLayoutListenerSingle {
                smoothScrollToPosition(0)
            }
        }
    }

    when (layoutManager) {
        is LinearLayoutManager -> {
            scrollLambda(linearLayoutManager.findLastVisibleItemPosition())
        }
        is StaggeredGridLayoutManager -> {
            val visiblePositions: IntArray = staggeredGridLayoutManager.findLastVisibleItemPositions(null)
            scrollLambda(visiblePositions.maxOrNull() ?: 0)
        }
        else -> { /* not implemented */ }
    }
}