package com.solux.flory.presentation.gift.searchneighbor

import android.os.Bundle
import com.solux.flory.R
import com.solux.flory.databinding.ActivityGiftSearchneighborBinding
import com.solux.flory.presentation.gift.GiftFragment
import com.solux.flory.util.base.BindingActivity

class SearchneighborActivity : BindingActivity<ActivityGiftSearchneighborBinding>({
    ActivityGiftSearchneighborBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        leftArrowClick()
    }

    private fun leftArrowClick() {
        binding.ivSearchneighborLeftArrow.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.menu_gift, GiftFragment()) //근데 넘어갈 때 시간이 좀 걸림. ..뭐지? 이게아닌가
                .commit()
        }
    }
}