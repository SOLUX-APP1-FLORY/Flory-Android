package com.solux.flory.presentation.profile

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.databinding.ItemProfileNeighborlistBinding

class NeighborViewHolder(
    private val binding: ItemProfileNeighborlistBinding,
    private val onClick: (NeighborInfo) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root){
    fun bind(neighborInfo: NeighborInfo) {
        binding.ivSelectneighborImage.load(neighborInfo.profileImage) {
            transformations(CircleCropTransformation())
        }
        binding.tvSelectneighborNickname.text = neighborInfo.profileName
        binding.clFollowcancle.setOnClickListener{
            onClick(neighborInfo)
        }
    }
}