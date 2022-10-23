package com.chunb.coopangeats.src.home.homewol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chunb.coopangeats.databinding.ItemRvDefaultLocationBinding

class HomeDefaultAdapter(itemList : MutableList<String>) : RecyclerView.Adapter<HomeDefaultAdapter.HomeDefaultViewHolder>() {
    private val mItemList = itemList

    inner class HomeDefaultViewHolder (val binding : ItemRvDefaultLocationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : String) {
            binding.locationName = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDefaultViewHolder {
        return HomeDefaultViewHolder(ItemRvDefaultLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeDefaultViewHolder, position: Int) {
        holder.bind(mItemList[position])
    }

    override fun getItemCount(): Int = mItemList.size
}