package com.solux.flory.presentation.gift.send

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentGiftSelectNeighborBinding
import com.solux.flory.presentation.gift.send.BouquetDialogFragment.Companion.NEIGHBOR_KEY
import com.solux.flory.presentation.profile.NeighborInfo
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.fragment.toast
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.selects.select

@AndroidEntryPoint
class SelectNeighborFragment :
    BindingFragment<FragmentGiftSelectNeighborBinding>(FragmentGiftSelectNeighborBinding::inflate) {
    private lateinit var adapter: SelectNeighborAdapter
    private val selectNeighborViewModel by viewModels<SelectNeighborViewModel>()
    private val neighborList = mutableListOf<NeighborInfo>()
    private var selectedNeighbor: NeighborInfo? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        confirmBtnClick()
        initToolbar()
        observeNeighborInfoState()
    }

    private fun observeNeighborInfoState() {
        selectNeighborViewModel.getNeighborInfoState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    neighborList.clear()
                    neighborList.addAll(convertStringsToNeighborInfo(it.data))
                    adapter.submitList(neighborList)
                }
                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun convertStringsToNeighborInfo(strings: List<String>): List<NeighborInfo> {
        return strings.map { NeighborInfo(profileName = it) }
    }

    private fun initToolbar() {
        with(binding.toolbarSelectNeighbor) {
            tvToolbarTitle.text = stringOf(R.string.tv_gift_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
            mdProfileDivider.visibility = View.GONE
        }
    }

    private fun initAdapter() {
        val adapter = SelectNeighborAdapter(){
            selectedNeighbor = it
        }
        binding.rvGiftSendNeighbor.adapter = adapter
        adapter.submitList(neighborList)
    }

    private fun confirmBtnClick() {
        binding.btnSelectNeighborConfirm.setOnClickListener {
            selectedNeighbor = adapter.getSelectedNeighbor()
            selectedNeighbor?.let { neighborInfo ->
                val bundle = Bundle().apply {
                    putSerializable(NEIGHBOR_KEY, neighborInfo)
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