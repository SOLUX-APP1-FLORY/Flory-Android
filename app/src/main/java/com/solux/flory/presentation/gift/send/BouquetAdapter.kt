package com.solux.flory.presentation.gift.send

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.solux.flory.databinding.ItemSelectBouquetBinding
import com.solux.flory.presentation.date.record.Flower

class BouquetAdapter(
    private val onClick: (Bouquet) -> Unit,
) : ListAdapter<Bouquet, BouquetViewHolder>(DiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BouquetViewHolder {
        return BouquetViewHolder(
            ItemSelectBouquetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClick
        )
    }

    override fun onBindViewHolder(holder: BouquetViewHolder, position: Int) {
        holder.bind(position, getItem(position))
    }

    companion object {
        private val DiffUtil = object : DiffUtil.ItemCallback<Bouquet>() {
            override fun areItemsTheSame(oldItem: Bouquet, newItem: Bouquet): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Bouquet, newItem: Bouquet): Boolean {
                return oldItem == newItem
            }
        }
    }
}

