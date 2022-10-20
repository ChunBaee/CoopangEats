package com.chunb.coopangeats_clone.src.beforestart.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chunb.coopangeats_clone.databinding.ItemVpBeforeStartBinding

class BeforeStartAdapterVP(itemList : MutableList<Drawable>) : RecyclerView.Adapter<BeforeStartAdapterVP.BeforeStartViewHolder>() {
    var mItemList = itemList
    inner class BeforeStartViewHolder(val binding : ItemVpBeforeStartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Drawable) {
            binding.imageDrawable = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeforeStartViewHolder {
        return BeforeStartViewHolder(ItemVpBeforeStartBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BeforeStartViewHolder, position: Int) {
        holder.bind(mItemList[position])
    }

    override fun getItemCount(): Int = mItemList.size
}