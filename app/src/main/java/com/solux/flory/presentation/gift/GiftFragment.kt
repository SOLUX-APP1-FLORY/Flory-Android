package com.solux.flory.presentation.gift

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftBinding
import com.solux.flory.presentation.gift.confirm.ConfirmFragment
import com.solux.flory.presentation.gift.send.SelectNeighborActivity
import com.solux.flory.util.base.BindingFragment

class GiftFragment : BindingFragment<FragmentGiftBinding>(FragmentGiftBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leftArrowClick()
        flowerConfirmImageClick()
        flowerSendImageClick()
    }

    private fun leftArrowClick() {
        binding.ivGiftLeftArrow.setOnClickListener {
            Intent(requireContext(), SearchNeighborActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun flowerConfirmImageClick() {
        binding.ivGiftFlowerconfirm.setOnClickListener {
            navigateToGiftConfirmFragment()
        }
    }

    private fun flowerSendImageClick() {
        binding.ivGiftFlowersend.setOnClickListener {
            Intent(requireContext(), SelectNeighborActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun navigateToGiftConfirmFragment(){
        findNavController().navigate(R.id.action_fragment_gift_to_fragment_gift_confirm)
    }
}