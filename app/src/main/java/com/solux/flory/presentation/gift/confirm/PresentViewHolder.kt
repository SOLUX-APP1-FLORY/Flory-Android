package com.solux.flory.presentation.gift.confirm

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.solux.flory.databinding.ItemGiftPresentsBinding

class PresentViewHolder(
    private val binding: ItemGiftPresentsBinding,
    private val onClick: (PresentInfo) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, presentInfo: PresentInfo) {
        binding.ivPresentsImage.load(presentInfo.imageUrl)
        binding.tvPresentsSender.text = presentInfo.sender
        binding.root.setOnClickListener {
            onClick(presentInfo)
        }
    }
}
