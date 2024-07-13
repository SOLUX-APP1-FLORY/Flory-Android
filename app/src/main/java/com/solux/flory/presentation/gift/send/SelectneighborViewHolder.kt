package com.solux.flory.presentation.gift.send

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.R
import com.solux.flory.databinding.ItemGiftSelectneighborsBinding
import com.solux.flory.presentation.profile.NeighborInfo

class SelectneighborViewHolder(
    private val binding: ItemGiftSelectneighborsBinding,
    private val onClick: (NeighborInfo, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(neighborInfo: NeighborInfo, isSelected: Boolean) {
        binding.tvSelectneighborNickname.text = neighborInfo.profileName

        binding.ivSelectneighborImage.load(neighborInfo.profileImage) {
            transformations(CircleCropTransformation())
        }

        binding.ivSelectneighborCheckcircle.setImageResource(
            if (isSelected) R.drawable.ic_gift_checkcircle else R.drawable.ic_gift_uncheckcircle
        )

        binding.ivSelectneighborCheckcircle.setOnClickListener {
            onClick(neighborInfo, !isSelected)
        }
    }
}



