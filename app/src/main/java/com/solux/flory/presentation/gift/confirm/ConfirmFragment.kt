package com.solux.flory.presentation.gift.confirm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftConfirmBinding
import com.solux.flory.domain.entity.BouquetInfoEntity
import com.solux.flory.presentation.gift.confirm.PresentDetailFragment.Companion.GIFTCONFIRM_KEY
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ConfirmFragment :
    BindingFragment<FragmentGiftConfirmBinding>(FragmentGiftConfirmBinding::inflate) {
    private val presentViewModel by viewModels<PresentViewModel>()
    private lateinit var adapter: PresentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        observeGetBouquetState()
    }

    override fun onResume() {
        super.onResume()
        presentViewModel.getBouquetInfo()
    }

    private fun observeGetBouquetState() {
        presentViewModel.getBouquetState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    initAdapter(it.data)  // 데이터가 업데이트될 때 리스트를 제출
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun initToolbar() {
        with(binding.toolbarGiftConfirm) {
            tvToolbarTitle.text = stringOf(R.string.tv_gift_confirm_toolbar_title)
            ibToolbarIcon.setOnClickListener {
                navigateToGiftConfirmFragment()
            }
        }
    }

    private fun initAdapter(data: List<BouquetInfoEntity>) {
        adapter = PresentAdapter {
            val bundle = Bundle().apply {
                putInt(GIFTCONFIRM_KEY, it.giftId)
            }
            findNavController().navigate(
                R.id.action_fragment_gift_confirm_to_fragment_gift_detail,
                bundle
            )
        }
        adapter.submitList(data)
        binding.rvPresents.adapter = adapter
    }

    private fun navigateToGiftConfirmFragment() {
        findNavController().navigate(R.id.action_fragment_gift_confirm_to_fragment_gift)
    }
}
