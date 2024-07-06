package com.solux.flory.presentation.gift.send

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ItemSelectBouquetBinding

class BouquetViewHolder(
    private val binding: ItemSelectBouquetBinding,
    private val onClick: (BouquetInfo) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, bouquetInfo: BouquetInfo) {
        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvBouquetMeaning.text = bouquetInfo.meaning
        binding.tvBouquetName.text = bouquetInfo.name
        binding.root.setOnClickListener {
            onClick(bouquetInfo)
        }
    }
}