package com.solux.flory.presentation.gift.send

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ItemSelectBouquetBinding
import com.solux.flory.presentation.gift.send.BouquetInfo

class BouquetViewHolder(
    private val binding: ItemSelectBouquetBinding,
    private val onClick: (BouquetInfo) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, bouquetInfo: BouquetInfo) {
        if (position % 2 == 0) {
            binding.clBouquetArea.setBackgroundResource(R.drawable.shape_peach_line_20_rect_shadow)
        } else {
            binding.clBouquetArea.setBackgroundResource(R.drawable.shape_white_line_20_rect_shadow)
        }
        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvBouquetMeaning.text = bouquetInfo.meaning
        binding.tvBouquetName.text = bouquetInfo.name
        binding.root.setOnClickListener {
            onClick(bouquetInfo)
        }
    }
}