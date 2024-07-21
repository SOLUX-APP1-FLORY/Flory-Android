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
        // Inflate the layout for this fragment using data binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        // Set the ViewModel in the binding
        binding.viewModel = viewModel

        // Observe LiveData for background change
        viewModel.rangeValue.observe(viewLifecycleOwner) { rangeValue ->
            updateBackgroundForRange(rangeValue)
        }

        // Return the root view of the fragment
        return binding.root
    }
    private fun updateBackgroundForRange(value: Int) {
        val backgroundResource = getBackgroundResourceForRange(value)
        binding.clHomeFragment.setBackgroundResource(backgroundResource)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModelData()
    }

    private fun setViewModelData() {
        viewModel.setRangeValue(18)
    }
}
