package com.solux.flory.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentNeighborsBinding
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class NeighborsFragment :
    BindingFragment<FragmentNeighborsBinding>(FragmentNeighborsBinding::inflate) {
    private val viewModel by viewModels<ProfileViewModel>()
    private lateinit var adapter: NeighborAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initAdapter()
        confirmBtnClick()
    }

    private fun initToolbar() {
        with(binding.toolbarNeighbors) {
            tvToolbarTitle.text = stringOf(R.string.tv_neighbors_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun initAdapter() {
        adapter = NeighborAdapter() {
            val dialog = NeighborDialogFragment(it)
            dialog.show(parentFragmentManager, dialog.tag)
        }
        binding.rvNeighbors.adapter = adapter
        adapter.submitList(viewModel.mockNeighbors)
    }

    private fun confirmBtnClick() {
        binding.btnNeighborsConfirm.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_neighbors_to_fragment_profile
            )
        }
    }
}