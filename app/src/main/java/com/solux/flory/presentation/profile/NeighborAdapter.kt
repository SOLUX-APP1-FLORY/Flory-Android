package com.solux.flory.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.solux.flory.databinding.ItemProfileNeighborlistBinding

class NeighborAdapter(
    private val onClick: (NeighborInfo) -> Unit,
) : ListAdapter<NeighborInfo, NeighborViewHolder>(DiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NeighborViewHolder {
        return NeighborViewHolder(
            ItemProfileNeighborlistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClick
        )
    }

    override fun onBindViewHolder(holder: NeighborViewHolder, position: Int) {
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