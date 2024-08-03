package com.solux.flory.presentation.searchNeighbor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.solux.flory.databinding.ItemGiftSearchNeighborsBinding
import com.solux.flory.domain.entity.NeighborSearchEntity


class SearchNeighborAdapter(
    private val onClick: (String) -> Unit = { _ -> },
) : ListAdapter<NeighborSearchEntity, SearchNeighborViewHolder>(DiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchNeighborViewHolder {
        val binding = ItemGiftSearchNeighborsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchNeighborViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: SearchNeighborViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffUtil = object : DiffUtil.ItemCallback<NeighborSearchEntity>() {
            override fun areItemsTheSame(
                oldItem: NeighborSearchEntity,
                newItem: NeighborSearchEntity
            ): Boolean {
                return oldItem.userId == newItem.userId
            }

            override fun areContentsTheSame(
                oldItem: NeighborSearchEntity,
                newItem: NeighborSearchEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}