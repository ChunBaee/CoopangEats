package com.chunb.coopangeats.src.home

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chunb.coopangeats.src.home.homewol.adapter.HomeDefaultAdapter

object HomeBindingAdapter {

    @BindingAdapter("setRvList")
    @JvmStatic
    fun setRvList (view : RecyclerView, list : MutableList<String>) {
        val adapter = HomeDefaultAdapter(list)
        view.adapter = adapter
    }
}