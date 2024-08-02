package com.solux.flory.presentation.gift.confirm

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.solux.flory.databinding.ItemGiftPresentsBinding
import com.solux.flory.domain.entity.BouquetInfoEntity

class PresentAdapter (
    private val onClick: (BouquetInfoEntity) -> Unit,
): ListAdapter<BouquetInfoEntity, PresentViewHolder>(DiffUtil) {
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
        private val DiffUtil = object : DiffUtil.ItemCallback<BouquetInfoEntity>() {
            override fun areItemsTheSame(oldItem: BouquetInfoEntity, newItem: BouquetInfoEntity): Boolean {
                return oldItem.giftId == newItem.giftId
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: BouquetInfoEntity, newItem: BouquetInfoEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}