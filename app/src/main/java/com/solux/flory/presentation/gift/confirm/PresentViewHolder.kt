package com.solux.flory.presentation.gift.confirm

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.solux.flory.databinding.ItemGiftPresentsBinding
import com.solux.flory.domain.entity.BouquetInfoEntity

class PresentViewHolder(
    private val binding: ItemGiftPresentsBinding,
    private val onClick: (BouquetInfoEntity) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(bouquetInfo: BouquetInfoEntity) {
        binding.ivPresentsImage.load(bouquetInfo.bouquetUrl)

        binding.tvPresentsSender.text = bouquetInfo.sender ?: "unknown"
        binding.root.setOnClickListener {
            onClick(bouquetInfo)
        }
    }
}
