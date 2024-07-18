package com.solux.flory.presentation.gift

import android.os.Bundle
import com.solux.flory.databinding.ActivityGiftSearchNeighborBinding
import com.solux.flory.util.base.BindingActivity

class SearchNeighborActivity : BindingActivity<ActivityGiftSearchNeighborBinding>({
    ActivityGiftSearchNeighborBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        leftArrowClick()
    }

    private fun leftArrowClick() {
        binding.ivSearchNeighborLeftArrow.setOnClickListener {
            finish()
        }
    }
}