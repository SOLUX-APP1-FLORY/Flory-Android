package com.solux.flory.presentation.gift.Searchneighbor

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ActivityGiftSearchneighborBinding
import com.solux.flory.databinding.ActivityMainBinding
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
                .replace(R.id.menu_gift, GiftFragment())
                .commit()
        }
    }
}