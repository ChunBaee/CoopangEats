package com.chunb.coopangeats.src.home.homewl.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chunb.coopangeats.databinding.FragmentHomeWithLocationBinding
import com.chunb.coopangeats.databinding.ItemVpHomeWlEventBannerBinding
import com.chunb.coopangeats.src.home.homewl.model.HomeEventData

class HomeEventAdapter(itemList : MutableList<HomeEventData>) : RecyclerView.Adapter<HomeEventAdapter.HomeEventViewHolder>() {
    val mItemList = itemList
    inner class HomeEventViewHolder (val binding : ItemVpHomeWlEventBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : HomeEventData) {
            binding.imageURL = item.eventImg
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeEventViewHolder {
        return HomeEventViewHolder(ItemVpHomeWlEventBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeEventViewHolder, position: Int) {
        holder.bind(mItemList[position % mItemList.size])
    }

    override fun getItemCount(): Int = Int.MAX_VALUE
}