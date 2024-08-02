package com.solux.flory.presentation.profile

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.R
import com.solux.flory.databinding.ItemProfileNeighborsBinding

class ProfileViewHolder(private val binding: ItemProfileNeighborsBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(neighborInfo: NeighborInfo) {
        binding.ivProfileImage.setImageResource(R.drawable.ic_gift_user)
        binding.tvProfileName.text = neighborInfo.profileName
    }
}