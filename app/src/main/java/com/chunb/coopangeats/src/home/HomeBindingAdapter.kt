package com.chunb.coopangeats.src.home

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.chunb.coopangeats.R
import com.chunb.coopangeats.src.home.homewl.adapter.HomeEventAdapter
import com.chunb.coopangeats.src.home.homewl.model.HomeEventData
import com.chunb.coopangeats.src.home.homewol.adapter.HomeDefaultAdapter

object HomeBindingAdapter {

    @BindingAdapter("setRvList")
    @JvmStatic
    fun setRvList (view : RecyclerView, list : MutableList<String>) {
        val adapter = HomeDefaultAdapter(list)
        view.adapter = adapter
    }

    @BindingAdapter ("setVPList", "setIndicator")
    @JvmStatic
    fun setEventVP (view : ViewPager2, list : MutableList<HomeEventData>, textView : TextView) {
        val adapter = HomeEventAdapter(list)
        view.adapter = adapter
        view.setCurrentItem(Int.MAX_VALUE / 2 - 3, false)
        Log.d("----", "setEventVP: ${view.currentItem % 5}")

        view.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                textView.text = view.context.getString(R.string.HomeFragmentWL_event_counts).format((position % 5 + 1), list.size)
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })
    }
}