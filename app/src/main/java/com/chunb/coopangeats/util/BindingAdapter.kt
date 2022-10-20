package com.chunb.coopangeats_clone.util

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.chunb.coopangeats_clone.src.beforestart.adapter.BeforeStartAdapterVP


object BindingAdapter {

    @BindingAdapter("setImageBackgroundFromResource")
    @JvmStatic
    fun setImageFromResource(view: ImageView, resource: Drawable) {
        view.background = resource
    }

    @BindingAdapter("setAdapterWithIntList")
    @JvmStatic
    fun setAdapter (view : ViewPager2, item : MutableList<Drawable>) {
        val adapter = BeforeStartAdapterVP(item)
        view.adapter = adapter
    }
}