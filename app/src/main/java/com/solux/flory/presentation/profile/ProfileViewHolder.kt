package com.solux.flory.presentation.profile

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.solux.flory.databinding.ItemProfileNeighborsBinding

class ProfileViewHolder(private val binding: ItemProfileNeighborsBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(neighborInfo: NeighborInfo) {
        binding.ivProfileImage.load(neighborInfo.profileImage) {
            transformations(CircleCropTransformation())
        }
        binding.tvProfileName.text = neighborInfo.profileName
    }
}