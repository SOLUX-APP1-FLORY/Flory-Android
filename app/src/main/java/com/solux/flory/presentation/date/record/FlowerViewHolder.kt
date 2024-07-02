package com.solux.flory.presentation.date.record

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ItemSelectFlowerBinding

class FlowerViewHolder(
    private val binding: ItemSelectFlowerBinding,
    private val onClick: (Flower) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, flower: Flower) {
        if (position % 2 == 0) {
            binding.clFlowerArea.setBackgroundResource(R.drawable.shape_peach_line_20_rect_shadow)
        } else {
            binding.clFlowerArea.setBackgroundResource(R.drawable.shape_white_line_20_rect_shadow)
        }
        binding.ivFlower.load(flower.imageUrl)
        binding.tvFlowerMeaning.text = flower.meaning
        binding.tvFlowerName.text = flower.name
        binding.root.setOnClickListener {
            onClick(flower)
        }
    }
}