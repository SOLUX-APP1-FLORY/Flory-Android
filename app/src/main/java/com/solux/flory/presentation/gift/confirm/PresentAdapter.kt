package com.solux.flory.presentation.gift.confirm

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.solux.flory.databinding.ItemGiftPresentsBinding
import com.solux.flory.presentation.gift.send.BouquetInfo
import com.solux.flory.presentation.gift.confirm.PresentViewModel

class PresentAdapter (
    private val onClick: (PresentInfo) -> Unit,
): ListAdapter<PresentInfo, PresentViewHolder>(DiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentViewHolder {
        return PresentViewHolder(
            ItemGiftPresentsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClick
        )
    }

    override fun onBindViewHolder(holder: PresentViewHolder, position: Int) {
        holder.bind(position, getItem(position))
    }

    companion object {
        private val DiffUtil = object : DiffUtil.ItemCallback<PresentInfo>() {
            override fun areItemsTheSame(oldItem: PresentInfo, newItem: PresentInfo): Boolean {
                return oldItem.message == newItem.message
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: PresentInfo, newItem: PresentInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}