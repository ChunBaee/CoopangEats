package com.chunb.coopangeats.src.home

import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.chunb.coopangeats.R
import com.chunb.coopangeats.src.home.homewl.adapter.HomeCategoryAdapter
import com.chunb.coopangeats.src.home.homewl.adapter.HomeEventAdapter
import com.chunb.coopangeats.src.home.homewl.model.HomeCategoryData
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

    @BindingAdapter("setRv")
    @JvmStatic
    fun setRv(view : RecyclerView, list : MutableList<HomeCategoryData>) {
        val adapter = HomeCategoryAdapter(list)
        view.adapter = adapter
    }

    @BindingAdapter("targetView", "toolbanner", "stickyview")
    @JvmStatic
    fun setToolBannerVisibility(view : NestedScrollView, target : View, toolbanner : ConstraintLayout, stickyView : View) {
        var isOpened = false
        val animUp = AnimationUtils.loadAnimation(view.context, R.anim.fg_home_wl_toolbanner_up)
        val animDown = AnimationUtils.loadAnimation(view.context, R.anim.fg_home_wl_toolbanner_down)
        animDown.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                toolbanner.visibility = View.VISIBLE
            }
            override fun onAnimationEnd(animation: Animation?) {
            }
            override fun onAnimationRepeat(animation: Animation?) {
            }
        })

        animUp.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }
            override fun onAnimationEnd(animation: Animation?) {
                toolbanner.visibility = View.GONE

            }
            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        view.setOnScrollChangeListener { _, _, y, _, oy ->
            val array = intArrayOf(0, 0)
            val array1 = intArrayOf(0, 0)
            val array2 = intArrayOf(0, 0)
            target.getLocationOnScreen(array)
            view.getLocationOnScreen(array1)
            stickyView.getLocationOnScreen(array2)

            if(array[1] <= array1[1] && !isOpened) {
                toolbanner.startAnimation(animDown)
                isOpened = true
            } else if(array[1] > array1[1] && isOpened){
                toolbanner.startAnimation(animUp)
                isOpened = false
            } else if(array1[1] > array2[1]) {
                Log.d("----", "setToolBannerVisibility: its work ${y - oy}")
                stickyView.translationY = (y - oy).toFloat()
            }
        }
    }
}