package com.solux.flory.presentation.date

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ItemDateBinding

class DateViewHolder(
    private val binding: ItemDateBinding,
    private val onClick: (DateInfo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dateInfo: DateInfo) {
        if (dateInfo.dayOfMonth != 0) {
            binding.tvItemDay.text = dateInfo.dayOfMonth.toString()
            dateInfo.imageUrl?.let {
                binding.ivItemFlower.load(it)
            }
        }
        binding.root.setOnClickListener {
            onClick(dateInfo)
        }
    }
}