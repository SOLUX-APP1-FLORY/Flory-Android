package com.solux.flory.presentation.gift.confirm

import android.content.Intent
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ItemGiftPresentsBinding
import com.solux.flory.presentation.date.record.RecordActivity
import com.solux.flory.presentation.gift.send.BouquetInfo
import com.solux.flory.presentation.gift.send.SelectneighborActivity
class PresentViewHolder(
    private val binding: ItemGiftPresentsBinding,
    private val onClick: (PresentInfo) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, presentInfo: PresentInfo) {
        binding.ivPresentsImage.load(presentInfo.imageUrl)
        binding.tvPresentsSender.text = presentInfo.sender
        binding.root.setOnClickListener {
            onClick(presentInfo)
        }
    }
}
