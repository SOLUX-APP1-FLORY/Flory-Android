package com.solux.flory.presentation.date

import androidx.recyclerview.widget.RecyclerView
import com.solux.flory.R
import com.solux.flory.databinding.ItemDateBinding

class DateViewHolder(private val binding: ItemDateBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dateInfo: DateInfo) {
        if(dateInfo.dayOfWeek != 0) {
            binding.tvItemDay.text = dateInfo.dayOfWeek.toString()
            binding.ivItemFlower.setImageResource(R.drawable.ic_flower_rose)
        }
    }
}