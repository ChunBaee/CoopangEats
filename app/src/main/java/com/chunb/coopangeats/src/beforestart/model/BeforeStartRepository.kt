package com.chunb.coopangeats_clone.src.beforestart.model

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.chunb.coopangeats_clone.R

class BeforeStartRepository (context: Context) {
    private val mContext = context

    fun setBeforeStartImageList() : MutableList<Drawable> {
        var mList = mutableListOf<Drawable>()
        return mList.apply {
            add(mContext.resources.getDrawable(R.drawable.bg_before_start_1, null))
            add(mContext.resources.getDrawable(R.drawable.bg_before_start_2, null))
            add(mContext.resources.getDrawable(R.drawable.bg_before_start_3, null))
        }
    }

}