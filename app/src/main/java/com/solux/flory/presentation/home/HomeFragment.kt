package com.solux.flory.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.solux.flory.R
import com.solux.flory.databinding.FragmentHomeBinding
import com.solux.flory.presentation.home.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.rangeValue.observe(viewLifecycleOwner) { rangeValue ->
            updateBackgroundForRange(rangeValue)
            updateUserIconForRange(rangeValue)
        }

        return binding.root
    }
    private fun updateBackgroundForRange(value: Int) {
        val backgroundResource = getBackgroundResourceForRange(value)
        binding.clHomeFragment.setBackgroundResource(backgroundResource)
    }

    private fun updateUserIconForRange(value: Int){
        val usericonResource = getUserIconResourceForRange(value)
        binding.ivHomeUserIcon.setImageResource(usericonResource)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModelData()
    }

    private fun setViewModelData() {
        viewModel.setRangeValue(18)
    }
}
