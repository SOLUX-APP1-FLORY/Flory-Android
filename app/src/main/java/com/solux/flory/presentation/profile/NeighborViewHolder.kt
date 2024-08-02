package com.solux.flory.presentation.profile

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.R
import com.solux.flory.databinding.ItemProfileNeighborlistBinding

class NeighborViewHolder(
    private val binding: ItemProfileNeighborlistBinding,
    private val onClick: (NeighborInfo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(neighborInfo: NeighborInfo) {
        with(binding) {
            ivSelectNeighborImage.setImageResource(R.drawable.ic_gift_user)
            tvSelectNeighborNickname.text = neighborInfo.profileName
            btnFollowCancel.setOnClickListener {
                onClick(neighborInfo)
            }
        }
    }
}