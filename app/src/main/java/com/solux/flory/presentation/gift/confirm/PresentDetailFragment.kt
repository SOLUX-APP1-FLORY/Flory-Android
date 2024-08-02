package com.solux.flory.presentation.gift.confirm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftDetailBinding
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class PresentDetailFragment : BindingFragment<FragmentGiftDetailBinding>(FragmentGiftDetailBinding::inflate) {

    private var presentInfo: PresentInfo? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            presentInfo = it.getInt(GIFTCONFIRM_KEY) as? PresentInfo
        }

        initView()
        initToolbar()
        confirmBtnClick()
    }

    private fun initView() {
        presentInfo?.let {
            binding.ivGiftDetailImage.load(it.imageUrl)
            binding.tvGiftDetailText.text = it.message
            binding.tvGiftDetailSender.text = it.sender
        }
    }

    private fun initToolbar() {
        with(binding.toolbarGiftDetail) {
            setupToolbarClickListener(ibToolbarIcon)
            mdProfileDivider.visibility = View.GONE
        }
    }

    private fun confirmBtnClick() {
        binding.btnGiftDetailConfirm.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_gift_detail_to_fragment_gift_confirm)
        }
    }

    companion object {
        const val GIFTCONFIRM_KEY = "presentInfo"
    }
}
