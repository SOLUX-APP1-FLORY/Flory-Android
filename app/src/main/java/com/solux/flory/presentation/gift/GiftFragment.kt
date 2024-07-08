package com.solux.flory.presentation.gift

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.solux.flory.databinding.FragmentGiftBinding
import com.solux.flory.presentation.gift.confirm.ConfirmActivity
import com.solux.flory.presentation.gift.send.SelectneighborActivity
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
            val intent = Intent(requireContext(), SearchneighborActivity::class.java)
            startActivity(intent)
        }
    }

    private fun flowerconfirmImageClick() {
        binding.ivGiftFlowerconfirm.setOnClickListener {
            val intent = Intent(requireContext(), ConfirmActivity::class.java)
            startActivity(intent)
        }
    }

    private fun flowersendImageClick() {
        binding.ivGiftFlowersend.setOnClickListener {
            val intent = Intent(requireContext(), SelectneighborActivity::class.java)
            startActivity(intent)
        }
    }
}