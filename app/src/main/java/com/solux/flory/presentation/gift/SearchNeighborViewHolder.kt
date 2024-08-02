package com.solux.flory.presentation.gift

import androidx.recyclerview.widget.RecyclerView
import com.solux.flory.databinding.ItemGiftSearchNeighborsBinding
import com.solux.flory.domain.entity.NeighborSearchEntity

class SearchNeighborViewHolder(
    private val binding: ItemGiftSearchNeighborsBinding,
    private val onClick: (String) -> Unit = { _ -> },
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: NeighborSearchEntity) {
        with(binding) {
            tvGiftNickname.text = data.nickname
            root.setOnClickListener {
                onClick(data.nickname)
            }
        }
    }
}