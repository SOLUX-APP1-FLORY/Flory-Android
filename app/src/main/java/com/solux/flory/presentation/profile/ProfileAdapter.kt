package com.solux.flory.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.solux.flory.databinding.ItemProfileNeighborsBinding

class ProfileAdapter : ListAdapter<NeighborInfo, ProfileViewHolder>(DiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            ItemProfileNeighborsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffUtil = object : DiffUtil.ItemCallback<NeighborInfo>() {
            override fun areItemsTheSame(oldItem: NeighborInfo, newItem: NeighborInfo): Boolean {
                return oldItem.profileName == newItem.profileName
            }

            override fun areContentsTheSame(oldItem: NeighborInfo, newItem: NeighborInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}