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
    fun bind(position: Int, bouquetInfo: BouquetInfoEntity) {
        // image url 추후에 넣기
        binding.tvPresentsSender.text = bouquetInfo.sender
        binding.root.setOnClickListener {
            onClick(bouquetInfo)
        }
    }
}
