package com.solux.flory.presentation.gift.confirm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftConfirmBinding
import com.solux.flory.presentation.gift.confirm.PresentDetailFragment.Companion.GIFTCONFIRM_KEY
import com.solux.flory.presentation.record.FlowerDialogFragment
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class ConfirmFragment: BindingFragment<FragmentGiftConfirmBinding>(FragmentGiftConfirmBinding::inflate){
    private val viewModel by viewModels<PresentViewModel>()
    private lateinit var adapter: PresentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initAdapter()
    }

    private fun initToolbar() {
        with(binding.toolbarGiftConfirm) {
            tvToolbarTitle.text = stringOf(R.string.tv_gift_confirm_toolbar_title)
            ibToolbarIcon.setOnClickListener{
                navigateToGiftConfirmFragment()
            }
        }
    }

    private fun initAdapter() {
        val adapter = PresentAdapter { presentInfo ->
            val bundle = Bundle().apply {
                putSerializable(GIFTCONFIRM_KEY, presentInfo)
            }

            findNavController().navigate(R.id.action_fragment_gift_confirm_to_fragment_gift_detail, bundle)
        }

        binding.rvPresents.adapter = adapter
        adapter.submitList(viewModel.mockPresent)
    }

    private fun navigateToGiftConfirmFragment(){
        findNavController().navigate(R.id.action_fragment_gift_confirm_to_fragment_gift)
    }
}