package com.solux.flory.presentation.gift

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.solux.flory.databinding.FragmentGiftBinding
import com.solux.flory.presentation.gift.confirm.ConfirmActivity
import com.solux.flory.presentation.gift.send.SelectNeighborActivity
import com.solux.flory.util.base.BindingFragment

class GiftFragment : BindingFragment<FragmentGiftBinding>(FragmentGiftBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leftArrowClick()
        flowerconfirmImageClick()
        flowersendImageClick()
    }

    private fun leftArrowClick() {
        binding.ivGiftLeftArrow.setOnClickListener {
            Intent(requireContext(), SearchNeighborActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun flowerconfirmImageClick() {
        binding.ivGiftFlowerconfirm.setOnClickListener {
            Intent(requireContext(), ConfirmActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun flowersendImageClick() {
        binding.ivGiftFlowersend.setOnClickListener {
            Intent(requireContext(), SelectNeighborActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}