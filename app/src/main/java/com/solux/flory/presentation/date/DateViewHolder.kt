package com.solux.flory.presentation.date

import androidx.recyclerview.widget.RecyclerView
import com.solux.flory.R
import com.solux.flory.databinding.ItemDateBinding

class DateViewHolder(private val binding: ItemDateBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dateInfo: DateInfo) {
        if(dateInfo.date != 0) {
            binding.tvItemDate.text = dateInfo.date.toString()
            binding.ivItemFlower.setImageResource(R.drawable.ic_flower_rose)
        }
    }
}