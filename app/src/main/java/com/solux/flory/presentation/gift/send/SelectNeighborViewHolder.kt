package com.solux.flory.presentation.gift.send

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.R
import com.solux.flory.databinding.ItemGiftSelectNeighborBinding
import com.solux.flory.presentation.profile.NeighborInfo

class SelectNeighborViewHolder(
    private val binding: ItemGiftSelectNeighborBinding,
    private val onClick: (NeighborInfo, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(neighborInfo: NeighborInfo, isSelected: Boolean) {
        with(binding){
            tvSelectneighborNickname.text = neighborInfo.profileName

            ivSelectneighborCheckcircle.setImageResource(
                if (isSelected) R.drawable.ic_gift_checkcircle else R.drawable.ic_gift_uncheckcircle
            )

            ivSelectneighborCheckcircle.setOnClickListener {
                onClick(neighborInfo, !isSelected)
            }
        }
    }
}



