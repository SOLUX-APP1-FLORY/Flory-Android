package com.solux.flory.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentNeighborsBinding
import com.solux.flory.util.base.BindingFragment

class NeighborsFragment :
    BindingFragment<FragmentNeighborsBinding>(FragmentNeighborsBinding::inflate) {
    private val viewModel by viewModels<ProfileViewModel>()
    private lateinit var adapter: NeighborAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        leftArrowClick()
        confirmBtnClick()
    }

    private fun initAdapter() {
        adapter = NeighborAdapter() {
            val dialog = NeighborDialogFragment(it)
            dialog.show(parentFragmentManager, dialog.tag)
        }
        binding.rvNeighbors.adapter = adapter
        adapter.submitList(viewModel.mockNeighbors)
    }

    private fun leftArrowClick() {
        binding.ivNeighborsLeftArrow.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_neighbors_to_fragment_profile
            )
        }
    }

    private fun confirmBtnClick() {
        binding.btnNeighborsConfirm.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_neighbors_to_fragment_profile
            )
        }
    }
}