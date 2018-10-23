package com.doghero.util

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import android.content.res.Resources
import android.support.annotation.DimenRes

class VerticalSpaceItemDecoration(
    @DimenRes private val verticalSpaceHeight: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) != parent.adapter!!.itemCount - 1) {
            outRect.bottom = view.resources.getDimension(verticalSpaceHeight).toInt()
        }
    }
}

private const val DENSITY = 0.5f

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + DENSITY).toInt()