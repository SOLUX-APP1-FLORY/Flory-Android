package com.solux.flory.presentation.gift.confirm

import android.os.Bundle
import coil.load
import com.solux.flory.databinding.ActivityGiftDetailBinding
import com.solux.flory.util.base.BindingActivity

class PresentDetailActivity : BindingActivity<ActivityGiftDetailBinding>({
    ActivityGiftDetailBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cancelBtnClick()
        impossibleBtnClick()
        val presentInfo = intent.getSerializableExtra("presentInfo") as? PresentInfo
        presentInfo?.let {
            binding.ivGiftdetailImage.load(it.imageUrl)
            binding.tvGiftdetailSender.text = it.sender
            binding.tvGiftdetailText.text = it.message
        }
    }

    private fun cancelBtnClick() {
        binding.clSelectneighborConfirm.setOnClickListener {
            finish()
        }
    }

    private fun impossibleBtnClick() {
        binding.ivGiftdetailImpossible.setOnClickListener {
            finish()
        }
    }
}