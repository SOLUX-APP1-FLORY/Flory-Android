package com.solux.flory.presentation.gift.present

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ItemSelectBouquetBinding

class BouquetViewHolder(
    private val binding: ItemSelectBouquetBinding,
    private val onClick: (Bouquet) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, bouquet: Bouquet) {
        if (position % 2 == 0) {
            binding.clBouquetArea.setBackgroundResource(R.drawable.shape_peach_line_20_rect_shadow)
        } else {
            binding.clBouquetArea.setBackgroundResource(R.drawable.shape_white_line_20_rect_shadow)
        }
        binding.ivBouquet.load(bouquet.imageUrl)
        binding.tvBouquetMeaning.text = bouquet.meaning
        binding.tvBouquetName.text = bouquet.name
        binding.root.setOnClickListener {
            onClick(bouquet)
        }
    }
}