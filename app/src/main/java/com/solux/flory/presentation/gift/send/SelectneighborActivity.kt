package com.solux.flory.presentation.gift.send

import android.content.Intent
import android.os.Bundle
import com.solux.flory.databinding.ActivityGiftSelectneighborBinding
import com.solux.flory.util.base.BindingActivity

class SelectneighborActivity : BindingActivity<ActivityGiftSelectneighborBinding> ({
    ActivityGiftSelectneighborBinding.inflate(it)
}){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        confimBtnClick()
    }
    private fun confimBtnClick() {
        binding.clSelectneighborConfirm.setOnClickListener {
            val intent = Intent(this@SelectneighborActivity, SendActivity::class.java)
            startActivity(intent)
        }
    }
}