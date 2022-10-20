package com.chunb.coopangeats.src.beforestart

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.chunb.coopangeats.src.beforestart.adapter.BeforeStartAdapterVP
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


object BeforeStartBindingAdapter {

    @BindingAdapter("setImageBackgroundFromResource")
    @JvmStatic
    fun setImageFromResource(view: ImageView, resource: Drawable) {
        view.background = resource
    }

    /*
    @BindingAdapter("setAdapterWithIntList")
    @JvmStatic
    fun setAdapter(view: ViewPager2, item: MutableList<Drawable>) {
        val adapter = BeforeStartAdapterVP(item)
        view.adapter = adapter
    }
    */

    @BindingAdapter("setTabWithViewPager", "setViewPagerList")
    @JvmStatic
    fun setTabWithVP(tab: TabLayout, vp: ViewPager2, item: MutableList<Drawable>) {
        val adapter = BeforeStartAdapterVP(item)
        vp.adapter = adapter

        TabLayoutMediator(tab, vp) { _, _ ->
        }.attach()
    }
}