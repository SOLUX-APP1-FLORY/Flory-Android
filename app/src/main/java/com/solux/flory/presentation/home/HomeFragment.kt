package com.solux.flory.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.solux.flory.R
import com.solux.flory.databinding.FragmentHomeBinding
import com.solux.flory.util.base.BindingFragment

class HomeFragment: BindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModelData()
        observeRangeValue()
    }


    private fun setViewModelData() {
        viewModel.setRangeValue(18)
    }

    private fun observeRangeValue() {
        viewModel.rangeValue.observe(viewLifecycleOwner) { rangeValue ->
            updateBackgroundForRange(rangeValue)
            updateUserIconForRange(rangeValue)
        }
    }

    private fun updateBackgroundForRange(value: Int) {
        val backgroundResource = getBackgroundResourceForRange(value)
        binding.clHomeFragment.setBackgroundResource(backgroundResource)
    }

    private fun updateUserIconForRange(value: Int) {
        val userIconResource = getUserIconResourceForRange(value)
        binding.ivHomeUserIcon.setImageResource(userIconResource)
    }

    private fun getBackgroundResourceForRange(value: Int): Int {
        return when {
            value <= 5 -> R.drawable.background_home1
            value <= 11 -> R.drawable.background_home2
            value <= 17 -> R.drawable.background_home3
            value <= 23 -> R.drawable.background_home4
            else -> R.drawable.background_home5
        }
    }

    private fun getUserIconResourceForRange(value: Int): Int {
        return when {
            value <= 11 -> R.drawable.ic_home_user_female1
            value <= 17 -> R.drawable.ic_home_user_female2
            else -> R.drawable.ic_home_user_female3
        }
    }
}
