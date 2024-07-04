package com.solux.flory.presentation.gift.confirm

import android.os.Bundle
import com.solux.flory.databinding.ActivityGiftConfirmBinding
import com.solux.flory.databinding.ActivityGiftSearchneighborBinding
import com.solux.flory.databinding.ActivityGiftSelectneighborBinding
import com.solux.flory.util.base.BindingActivity

class ConfirmActivity : BindingActivity<ActivityGiftConfirmBinding> ({
    ActivityGiftConfirmBinding.inflate(it)
}){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //꽃다발 확인

        impossibleBtnClick()
    }

    private fun impossibleBtnClick(){
        binding.ivGiftconfirmImpossible.setOnClickListener{
            finish()
        }
    }
}