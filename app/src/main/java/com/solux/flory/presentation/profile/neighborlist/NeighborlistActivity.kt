package com.solux.flory.presentation.profile.neighborlist

import android.os.Bundle
import com.solux.flory.databinding.ActivityNeighborsBinding
import com.solux.flory.util.base.BindingActivity
class NeighborlistActivity : BindingActivity<ActivityNeighborsBinding>({
    ActivityNeighborsBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        leftArrowClick()
        confirmBtnClick()
    }

    private fun leftArrowClick() {
        binding.ivNeighborlistLeftArrow.setOnClickListener {
            finish()
        }
    }

    private fun confirmBtnClick() {
        binding.btnNeighborlist.setOnClickListener {
            finish()
        }
    }
}