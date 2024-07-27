package com.solux.flory.presentation.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.solux.flory.databinding.ItemSelectFlowerBinding

class FlowerAdapter(
    private val onClick: (Flower) -> Unit,
) : ListAdapter<Flower, FlowerViewHolder>(DiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        return FlowerViewHolder(
            ItemSelectFlowerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClick
        )
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bind(position, getItem(position))
    }

    companion object {
        private val DiffUtil = object : DiffUtil.ItemCallback<Flower>() {
            override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
                return oldItem == newItem
            }
        }
    }
}