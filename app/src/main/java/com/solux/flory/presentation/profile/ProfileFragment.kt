package com.solux.flory.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.solux.flory.databinding.FragmentProfileBinding
import com.solux.flory.util.base.BindingFragment

class ProfileFragment : BindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val viewModel by activityViewModels<ProfileViewModel>()
    private lateinit var adapter: ProfileAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = ProfileAdapter()
        binding.rvProfileNeighbors.adapter = adapter
        adapter.submitList(viewModel.mockNeighbors)
    }
}