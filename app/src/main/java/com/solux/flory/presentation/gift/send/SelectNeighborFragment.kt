package com.solux.flory.presentation.gift.send

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftSelectNeighborBinding
import com.solux.flory.presentation.profile.NeighborInfo
import com.solux.flory.presentation.profile.ProfileViewModel
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.fragment.toast
import com.solux.flory.util.setupToolbarClickListener

class SelectNeighborFragment :
    BindingFragment<FragmentGiftSelectNeighborBinding>(FragmentGiftSelectNeighborBinding::inflate) {
    private lateinit var adapter: SelectNeighborAdapter
    private val viewModel by viewModels<ProfileViewModel>()
    private var selectedNeighbor: NeighborInfo? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        confirmBtnClick()
        initToolbar()
    }

    private fun initToolbar() {
        with(binding.toolbarSelectNeighbor) {
            tvToolbarTitle.text = stringOf(R.string.tv_gift_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
            mdProfileDivider.visibility = View.GONE
        }
    }

    private fun initAdapter() {
        adapter = SelectNeighborAdapter { _ -> }
        binding.rvGiftSendNeighbor.adapter = adapter
        adapter.submitList(viewModel.mockNeighbors)
    }

    private fun confirmBtnClick() {
        binding.btnSelectNeighborConfirm.setOnClickListener {
            selectedNeighbor = adapter.getSelectedNeighbor()
            selectedNeighbor?.let { neighborInfo ->
                val bundle = Bundle().apply {
                    putSerializable("selectedNeighbor", neighborInfo)
                }
                findNavController().navigate(
                    R.id.action_fragment_select_neighbor_to_fragment_select_bouquet,
                    bundle
                )
            } ?: run {
                toast(stringOf(R.string.tv_select_neighbor_error))
            }
        }
    }

}