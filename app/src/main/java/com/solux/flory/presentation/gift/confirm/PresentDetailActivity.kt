package com.solux.flory.presentation.gift.confirm

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ActivityGiftDetailBinding
import com.solux.flory.databinding.ActivityRecordBinding
import com.solux.flory.presentation.date.record.Flower
import com.solux.flory.presentation.gift.confirm.PresentInfo
import com.solux.flory.presentation.gift.send.SelectBouquetActivity
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.base.BindingDialogFragment

class PresentDetailActivity : BindingActivity<ActivityGiftDetailBinding>({
    ActivityGiftDetailBinding.inflate(it)
}){
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

    private fun impossibleBtnClick(){
        binding.ivGiftdetailImpossible.setOnClickListener{
            finish()
        }
    }
}