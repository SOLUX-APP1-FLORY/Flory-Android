package com.solux.flory.presentation.profile

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.databinding.ItemProfileNeighborlistBinding

class NeighborViewHolder(
    private val binding: ItemProfileNeighborlistBinding,
    private val onClick: (NeighborInfo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(neighborInfo: NeighborInfo) {
        with(binding) {
            ivSelectNeighborImage.load(neighborInfo.profileImage) {
                transformations(CircleCropTransformation())
            }
            tvSelectNeighborNickname.text = neighborInfo.profileName
            btnFollowCancle.setOnClickListener {
                onClick(neighborInfo)
            }
        }
    }
}